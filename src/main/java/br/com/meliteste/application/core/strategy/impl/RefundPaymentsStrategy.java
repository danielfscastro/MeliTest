package br.com.meliteste.application.core.strategy.impl;

import br.com.meliteste.application.core.domain.Operation;
import br.com.meliteste.application.core.exception.ClientResponseStatusException;
import br.com.meliteste.application.core.strategy.OperationStrategy;
import br.com.meliteste.application.ports.out.gateway.RefundPaymentsGateway;
import org.springframework.stereotype.Component;

public class RefundPaymentsStrategy implements OperationStrategy {
    private final RefundPaymentsGateway refundPaymentsGateway;

    public RefundPaymentsStrategy(RefundPaymentsGateway refundPaymentsGateway) {
        this.refundPaymentsGateway = refundPaymentsGateway;
    }

    @Override
    public void execute(Operation operation) {
        refundPaymentsGateway.refundPayment(operation.getParams().getId());
    }
}
