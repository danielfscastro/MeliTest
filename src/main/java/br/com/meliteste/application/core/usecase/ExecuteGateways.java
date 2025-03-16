package br.com.meliteste.application.core.usecase;

import br.com.meliteste.application.core.domain.Operation;
import br.com.meliteste.application.core.domain.OperationType;
import br.com.meliteste.application.core.exception.ClientResponseStatusException;
import br.com.meliteste.application.core.strategy.OperationContext;
import br.com.meliteste.application.ports.in.ExecuteGatewaysInputPort;
import br.com.meliteste.application.ports.out.ExecuteGatewaysOutputPort;

public class ExecuteGateways implements ExecuteGatewaysInputPort {

    private final ExecuteGatewaysOutputPort executeGatewayOutputPort;

    public ExecuteGateways(ExecuteGatewaysOutputPort executeGatewayOutputPort) {
        this.executeGatewayOutputPort = executeGatewayOutputPort;
    }

    @Override
    public Integer execute(OperationType operationType, Operation operation) throws ClientResponseStatusException {
        return executeGatewayOutputPort.execute(operationType, operation);
    }

}
