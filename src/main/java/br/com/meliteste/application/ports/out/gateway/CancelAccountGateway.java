package br.com.meliteste.application.ports.out.gateway;

import br.com.meliteste.application.core.exception.ClientResponseStatusException;

public interface CancelAccountGateway {
  boolean cancel(long accountId) throws ClientResponseStatusException;
};