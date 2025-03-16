package br.com.meliteste.adapters.in.entity;

import br.com.meliteste.adapters.out.repository.mapper.OperationEntityMapper;
import br.com.meliteste.adapters.out.repository.mapper.OperationParamsMapper;
import br.com.meliteste.application.core.domain.Operation;

import br.com.meliteste.application.core.domain.OperationParams;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.Data;
import java.util.HashMap;
import java.util.Map;

@Data
@Entity(name = "Operation")
public class OperationEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private long id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "params")
    private String paramsAsJson;

    @Column(name = "external_id") // Mapeia a coluna `external_id` na tabela
    private String externalId;

    // Método para obter params como OperationParams
    public OperationParams getParams() {
        return OperationParamsMapper.INSTANCE.toOperationParams(this.paramsAsJson);
    }

    // Método para definir params a partir de OperationParams
    public void setParams(OperationParams params) {
        this.paramsAsJson = OperationParamsMapper.INSTANCE.toJson(params);
    }

}
