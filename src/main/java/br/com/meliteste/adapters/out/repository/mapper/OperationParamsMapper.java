package br.com.meliteste.adapters.out.repository.mapper;

import br.com.meliteste.application.core.domain.OperationParams;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OperationParamsMapper {

    OperationParamsMapper INSTANCE = Mappers.getMapper(OperationParamsMapper.class);

    // Mapear para OperationParams
    OperationParams toOperationParams(String paramsJson); // Converter JSON string para OperationParams

    // Mapear para String JSON
    String toJson(OperationParams params);

}
