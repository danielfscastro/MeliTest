package br.com.meliteste.application.core.strategy.impl;

import br.com.meliteste.application.core.domain.Operation;
import br.com.meliteste.application.core.exception.ClientResponseStatusException;
import br.com.meliteste.application.core.strategy.OperationStrategy;
import br.com.meliteste.application.ports.out.gateway.CancelAccountGateway;
import org.springframework.stereotype.Component;

public class CancelAccountStrategy implements OperationStrategy {
    private final CancelAccountGateway cancelAccountGateway;

    public CancelAccountStrategy(CancelAccountGateway cancelAccountGateway) {
        this.cancelAccountGateway = cancelAccountGateway;
    }

    @Override
    public void execute(Operation operation) {
        cancelAccountGateway.cancel(operation.getParams().getId());
    }
}
