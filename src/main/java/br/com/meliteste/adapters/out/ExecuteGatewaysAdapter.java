package br.com.meliteste.adapters.out;

import br.com.meliteste.application.core.domain.Operation;
import br.com.meliteste.application.core.domain.OperationType;
import br.com.meliteste.application.core.exception.ClientResponseStatusException;
import br.com.meliteste.application.core.strategy.OperationContext;
import br.com.meliteste.application.ports.out.ExecuteGatewaysOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ExecuteGatewaysAdapter implements ExecuteGatewaysOutputPort {

    private final OperationContext context;

    @Override
    public Integer execute(OperationType operationType, Operation operation) throws ClientResponseStatusException {
        context.execute(operationType, operation);
        return 0;
    }
}
