package br.com.meliteste.application.core.strategy;

import br.com.meliteste.application.core.domain.Operation;
import br.com.meliteste.application.core.domain.OperationType;
import br.com.meliteste.application.core.exception.StrategyNotFoundException;

public interface OperationContext {
    void execute(OperationType operationType, Operation operation) throws StrategyNotFoundException;
}
