package br.com.meliteste.application.ports.in;

import br.com.meliteste.application.core.domain.Operation;

import java.util.Optional;

public interface FindOperationByExternalIdInputPort {
    Operation find(String externalId);
}
