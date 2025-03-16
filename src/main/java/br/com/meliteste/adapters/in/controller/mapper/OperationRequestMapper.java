package br.com.meliteste.adapters.in.controller.mapper;

import br.com.meliteste.adapters.in.controller.request.OperationRequest;
import br.com.meliteste.application.core.domain.Operation;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface OperationRequestMapper {
    Operation toOperation(OperationRequest operationRequest);

    OperationRequest toOperationRequest(Operation operation);
}
