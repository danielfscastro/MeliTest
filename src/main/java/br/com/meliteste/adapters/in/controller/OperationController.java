package br.com.meliteste.adapters.in.controller;

import br.com.meliteste.adapters.in.controller.mapper.OperationRequestMapper;
import br.com.meliteste.adapters.in.controller.request.OperationRequest;
import br.com.meliteste.adapters.in.controller.response.ResponseDto;
import br.com.meliteste.application.core.domain.Operation;
import br.com.meliteste.application.core.domain.OperationType;
import br.com.meliteste.application.core.exception.ClientResponseStatusException;
import br.com.meliteste.application.ports.in.ExecuteGatewaysInputPort;
import br.com.meliteste.application.ports.in.FindOperationByExternalIdInputPort;
import br.com.meliteste.application.ports.in.InsertOperationInputPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RestController
@RequestMapping(path = "/api/v1/operation", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
@AllArgsConstructor
public class OperationController {
    private final InsertOperationInputPort insertOperationInputPort;

    private final FindOperationByExternalIdInputPort findOperationByExternalIdInputPort;

    private final ExecuteGatewaysInputPort executeGatewaysInputPort;

    private final OperationRequestMapper operationRequestMapper;

    @PostMapping("/create")
    @Retryable(
            retryFor = { ClientResponseStatusException.class }, // Exceções que vão gerar retry
            maxAttempts = 3,
            backoff = @Backoff(delay = 2000)
    )
//    public ResponseEntity<ResponseDto> createOperation(@RequestBody OperationRequest operationRequest) {
//        System.out.println(operationRequest);
//        Operation operation = operationRequestMapper.toOperation(operationRequest);
//
//        executeGatewaysInputPort.execute(OperationType.fromValue(operation.getName()), operation);
//
//        insertOperationInputPort.save(operation);
//
//        return buildResponseEntity(HttpStatus.CREATED, HttpStatus.CREATED.value() + "", "Operação criada com sucesso");
//
//    }
    public ResponseEntity<ResponseDto> processOperations(@RequestBody List<OperationRequest> operationRequests) {
        ExecutorService executorService = Executors.newFixedThreadPool(10); // Define um pool de threads

        try {
            // Cria uma lista de tarefas usando Callable
            List<Callable<Void>> tasks = operationRequests.stream()
                    .map(operationRequest -> (Callable<Void>) () -> {
                        System.out.println(operationRequest);
                        Operation operation = operationRequestMapper.toOperation(operationRequest);
                        executeGatewaysInputPort.execute(OperationType.fromValue(operation.getName()), operation);
                        insertOperationInputPort.save(operation);
                        return null; // Callable precisa retornar algo; apenas retornamos null.
                    })
                    .toList();

            // Executa todas as tarefas e aguarda a conclusão
            List<Future<Void>> futures = executorService.invokeAll(tasks);

            // Opcional: Verifica se todas as tarefas foram concluídas com sucesso
            for (Future<Void> future : futures) {
                try {
                    future.get(); // Se houver uma exceção, será lançada aqui
                } catch (Exception e) {
                    Throwable cause = e.getCause();
                    if (cause instanceof ClientResponseStatusException) {
                        // Logue detalhes específicos do erro
                        ClientResponseStatusException clientException = (ClientResponseStatusException) cause;
                        System.err.println("Erro detalhado: " + clientException.getMessage());
                    }
                    // Lidar com exceção durante a execução da tarefa
                    System.err.println("Erro ao processar operação: " + cause);
                    cause.printStackTrace();

                }
            }

            return buildResponseEntity(HttpStatus.CREATED, HttpStatus.CREATED.value() + "", "Operações criadas com sucesso.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaura o estado de interrupção
            return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value() + "" ,"Erro ao processar operações");
        } finally {
            executorService.shutdown(); // Certifique-se de desligar o executor
        }
    }

    @GetMapping("/fetch")
    public ResponseEntity<Operation> fetch(@RequestParam String externalId) {
        Operation operation = findOperationByExternalIdInputPort.find(externalId);
        System.out.println(operation);
        return ResponseEntity.status(HttpStatus.OK).body(operation);
    }

    private ResponseEntity<ResponseDto> buildResponseEntity(HttpStatus status, String statusCode, String message) {
        return ResponseEntity
                .status(status)
                .body(new ResponseDto(statusCode, message));
    }

}
