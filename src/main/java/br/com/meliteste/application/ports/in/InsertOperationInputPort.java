package br.com.meliteste.application.ports.in;

import br.com.meliteste.application.core.domain.Operation;

public interface InsertOperationInputPort {
    void save(Operation operation);
}
