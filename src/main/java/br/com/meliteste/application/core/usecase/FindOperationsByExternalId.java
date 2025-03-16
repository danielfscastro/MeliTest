package br.com.meliteste.application.core.usecase;

import br.com.meliteste.application.ports.in.FindOperationByExternalIdInputPort;
import br.com.meliteste.application.ports.out.FindOperationByExternalIdOutputPort;
import br.com.meliteste.application.core.domain.Operation;
import br.com.meliteste.application.core.exception.ClientResponseStatusException;

public class FindOperationsByExternalId implements FindOperationByExternalIdInputPort {
    private final FindOperationByExternalIdOutputPort findOperationOutputPort;

    public FindOperationsByExternalId(FindOperationByExternalIdOutputPort findOperationOutputPort) {
        this.findOperationOutputPort = findOperationOutputPort;
    }

    @Override
    public Operation find(String externalId) {
        return findOperationOutputPort.find(externalId).orElseThrow(() -> new ClientResponseStatusException(204,"No content found"));
    }
}
