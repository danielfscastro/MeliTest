package br.com.meliteste.application.core.strategy.impl;

import br.com.meliteste.application.core.domain.Operation;
import br.com.meliteste.application.core.exception.ClientResponseStatusException;
import br.com.meliteste.application.core.strategy.OperationStrategy;
import br.com.meliteste.application.ports.out.gateway.ApplyDiscountPurchaseGateway;
import org.springframework.stereotype.Component;

public class ApplyDiscountPurchaseStrategy implements OperationStrategy {
    private final ApplyDiscountPurchaseGateway applyDiscountPurchaseGateway;

    public ApplyDiscountPurchaseStrategy(ApplyDiscountPurchaseGateway applyDiscountPurchaseGateway) {
        this.applyDiscountPurchaseGateway = applyDiscountPurchaseGateway;
    }

    @Override
    public void execute(Operation operation) {
        applyDiscountPurchaseGateway.applyDiscount(operation.getParams().getId(), operation.getParams().getValue());
    }
}
