package br.com.meliteste.adapters.out;

import br.com.meliteste.adapters.in.entity.OperationEntity;
import br.com.meliteste.adapters.out.repository.OperationExecutionRepository;
import br.com.meliteste.adapters.out.repository.mapper.OperationEntityMapper;
import br.com.meliteste.application.core.domain.Operation;
import br.com.meliteste.application.ports.out.InsertOperationOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class InsertOperationAdapter implements InsertOperationOutputPort {

    private OperationExecutionRepository operationExecutionRepository;

    private OperationEntityMapper operationEntityMapper;

    @Override
    public void save(Operation operation) {
        OperationEntity operationEntity = operationEntityMapper.toOperationEntity(operation);
        operationExecutionRepository.save(operationEntity);
    }
}
