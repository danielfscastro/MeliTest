package br.com.meliteste.adapters.out.gateway;

import br.com.meliteste.application.core.exception.ClientResponseStatusException;
import br.com.meliteste.application.ports.out.gateway.ApplyDiscountPurchaseGateway;
import org.springframework.stereotype.Component;

@Component
public class ApplyDiscountPurchaseImpl implements ApplyDiscountPurchaseGateway {

    public double applyDiscount(long purchaseId, double discountValue) throws ClientResponseStatusException  {
        System.out.println("aplicou disconto na compra");
        return 0;
    }
};