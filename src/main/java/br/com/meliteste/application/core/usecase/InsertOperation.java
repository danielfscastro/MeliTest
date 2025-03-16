package br.com.meliteste.application.core.usecase;

import br.com.meliteste.application.ports.in.InsertOperationInputPort;
import br.com.meliteste.application.ports.out.FindOperationByExternalIdOutputPort;
import br.com.meliteste.application.ports.out.InsertOperationOutputPort;
import br.com.meliteste.application.core.domain.Operation;

public class InsertOperation implements InsertOperationInputPort {

    private final InsertOperationOutputPort insertOperationOutputPort;

    private final FindOperationByExternalIdOutputPort findOperationOutputPort;

    public InsertOperation(InsertOperationOutputPort insertOperationOutputPort,
                           FindOperationByExternalIdOutputPort findOperationOutputPort) {
        this.insertOperationOutputPort = insertOperationOutputPort;
        this.findOperationOutputPort = findOperationOutputPort;
    }

    @Override
    public void save(Operation operation) {
        findOperationOutputPort.find(operation.getExternalId());
        insertOperationOutputPort.save(operation);
    }
}
