package br.com.meliteste.application.core.strategy.impl;

import br.com.meliteste.application.core.domain.Operation;
import br.com.meliteste.application.core.exception.ClientResponseStatusException;
import br.com.meliteste.application.core.strategy.OperationStrategy;
import br.com.meliteste.application.ports.out.gateway.ApprovePaymentsGateway;
import org.springframework.stereotype.Component;

public class ApprovePaymentsStrategy implements OperationStrategy {

    private final ApprovePaymentsGateway approvePaymentsGateway;

    public ApprovePaymentsStrategy(ApprovePaymentsGateway approvePaymentsGateway) {
        this.approvePaymentsGateway = approvePaymentsGateway;
    }

    @Override
    public void execute(Operation operation) {
        approvePaymentsGateway.approve(operation.getParams().getId());
    }
}
