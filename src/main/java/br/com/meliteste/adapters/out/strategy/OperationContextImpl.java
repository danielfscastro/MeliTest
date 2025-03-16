package br.com.meliteste.adapters.out.strategy;

import br.com.meliteste.application.core.exception.ClientResponseStatusException;
import br.com.meliteste.application.core.exception.StrategyNotFoundException;
import br.com.meliteste.application.core.domain.Operation;
import br.com.meliteste.application.core.domain.OperationType;
import br.com.meliteste.application.core.strategy.OperationContext;
import br.com.meliteste.application.core.strategy.OperationStrategy;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class OperationContextImpl implements OperationContext {

    private final Map<OperationType, OperationStrategy> strategies;

    public void execute(OperationType operationType, Operation operation){
        OperationStrategy strategy = strategies.get(operationType);

        if (strategy == null) {
            throw new StrategyNotFoundException("Strategy not found!");
        }

        //codigo para simular erros e executar o retry
        switch (Integer.valueOf(String.valueOf(operation.getParams().getId()))) {
            case 400: // Bad Request
            case 404:
            case 422: // Unprocessable Entity
            case 499: // Client Closed Request (ou maior que 499)
            case 500: // (ou outros códigos que você considere)
            case 501:
            case 502:
            case 503:
            case 504:
                HttpStatus.valueOf(Long.valueOf(operation.getParams().getId()).intValue()).value();
                throw new ClientResponseStatusException(HttpStatus.valueOf(Long.valueOf(operation.getParams().getId()).intValue()).value(), HttpStatus.valueOf(Long.valueOf(operation.getParams().getId()).intValue()).getReasonPhrase());
            default:
                strategy.execute(operation);
        }




    }
}
