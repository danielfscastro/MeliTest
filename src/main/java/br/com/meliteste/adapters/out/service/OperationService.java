package br.com.meliteste.adapters.out.service;

import br.com.meliteste.adapters.in.controller.mapper.OperationRequestMapper;
import br.com.meliteste.adapters.in.controller.request.OperationRequest;
import br.com.meliteste.application.core.domain.Operation;
import br.com.meliteste.application.core.domain.OperationType;
import br.com.meliteste.application.core.exception.ClientResponseStatusException;
import br.com.meliteste.application.ports.in.ExecuteGatewaysInputPort;
import br.com.meliteste.application.ports.in.InsertOperationInputPort;
import lombok.AllArgsConstructor;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OperationService {

    private final ExecuteGatewaysInputPort executeGatewaysInputPort;

    private final OperationRequestMapper operationRequestMapper;

    private final InsertOperationInputPort insertOperationInputPort;

    @Retryable(
            retryFor = { ClientResponseStatusException.class },
            maxAttempts = 3,
            backoff = @Backoff(delay = 2000)
    )
    public void executeOperation(OperationRequest operationRequest) {
        System.out.println("executing operation " + operationRequest);
        Operation operation = operationRequestMapper.toOperation(operationRequest);
        executeGatewaysInputPort.execute(OperationType.fromValue(operation.getName()), operation);
        insertOperationInputPort.save(operation);
    }
}