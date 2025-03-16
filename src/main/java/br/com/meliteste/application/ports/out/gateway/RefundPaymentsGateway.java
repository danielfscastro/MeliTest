package br.com.meliteste.application.ports.out.gateway;

import br.com.meliteste.application.core.exception.ClientResponseStatusException;

public interface RefundPaymentsGateway {
  boolean refundPayment(long paymentId) throws ClientResponseStatusException;
};