package br.com.meliteste.application.ports.out;

import br.com.meliteste.application.core.domain.Operation;
import br.com.meliteste.application.core.domain.OperationType;
import br.com.meliteste.application.core.exception.ClientResponseStatusException;
import br.com.meliteste.application.core.strategy.OperationContext;

public interface ExecuteGatewaysOutputPort {
    Integer execute(OperationType operationType, Operation operation) throws ClientResponseStatusException;
}
