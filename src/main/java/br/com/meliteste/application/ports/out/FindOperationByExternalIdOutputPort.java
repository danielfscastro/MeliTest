package br.com.meliteste.application.ports.out;

import br.com.meliteste.application.core.domain.Operation;

import java.util.Optional;

public interface FindOperationByExternalIdOutputPort {
    Optional<Operation> find(String externalId);
}
