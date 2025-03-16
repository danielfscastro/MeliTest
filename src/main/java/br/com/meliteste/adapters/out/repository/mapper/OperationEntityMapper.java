package br.com.meliteste.adapters.out.repository.mapper;

import br.com.meliteste.adapters.in.entity.OperationEntity;
import br.com.meliteste.application.core.domain.Operation;
import br.com.meliteste.application.core.domain.OperationParams;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OperationEntityMapper {

    // Mapeamento de Operation para OperationEntity
    @Mapping(target = "paramsAsJson", expression = "java(convertParamsToJson(operation.getParams()))")
    OperationEntity toOperationEntity(Operation operation);

    // Mapeamento de OperationEntity para Operation
    @Mapping(target = "params", expression = "java(convertJsonToParams(operationEntity.getParamsAsJson()))")
    Operation toOperation(OperationEntity operationEntity);

    // Método auxiliar para converter OperationParams para JSON
    default String convertParamsToJson(OperationParams params) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(params);
        } catch (JsonProcessingException e) {
            e.printStackTrace(); // Handle exception as needed
            return null; // handle accordingly
        }
    }

    // Método auxiliar para converter JSON para OperationParams
    default OperationParams convertJsonToParams(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, OperationParams.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace(); // Handle exception as needed
            return null; // handle accordingly
        }
    }
}
