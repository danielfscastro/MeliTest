package br.com.meliteste.application.ports.out;

import br.com.meliteste.application.core.domain.Operation;

public interface InsertOperationOutputPort {
    void save(Operation operation);
}
