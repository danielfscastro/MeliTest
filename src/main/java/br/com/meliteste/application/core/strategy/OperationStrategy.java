package br.com.meliteste.application.core.strategy;

import br.com.meliteste.application.core.domain.Operation;

public interface OperationStrategy {
    void execute(Operation operation);
}
