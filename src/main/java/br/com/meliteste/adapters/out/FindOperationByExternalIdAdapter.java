package br.com.meliteste.adapters.out;

import br.com.meliteste.adapters.out.repository.OperationExecutionRepository;
import br.com.meliteste.adapters.out.repository.mapper.OperationEntityMapper;
import br.com.meliteste.application.core.domain.Operation;
import br.com.meliteste.application.ports.out.FindOperationByExternalIdOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class FindOperationByExternalIdAdapter implements FindOperationByExternalIdOutputPort {

    private final OperationExecutionRepository operationExecutionRepository;

    private final OperationEntityMapper operationEntityMapper;

    @Override
    public Optional<Operation> find(String externalId) {
        return operationExecutionRepository.findByExternalId(externalId).map(operationEntityMapper::toOperation);
    }
}
