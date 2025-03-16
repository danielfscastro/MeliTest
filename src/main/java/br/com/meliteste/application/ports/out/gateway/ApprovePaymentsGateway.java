package br.com.meliteste.application.ports.out.gateway;

import br.com.meliteste.application.core.exception.ClientResponseStatusException;

public interface ApprovePaymentsGateway {

   boolean approve(long paymentId) throws ClientResponseStatusException;

};