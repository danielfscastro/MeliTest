package br.com.meliteste.application.ports.out.gateway;

import br.com.meliteste.application.core.exception.ClientResponseStatusException;

public interface ApplyDiscountPurchaseGateway {
  double applyDiscount(long purchaseId,double discountValue) throws ClientResponseStatusException;
};