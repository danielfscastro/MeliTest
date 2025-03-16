package br.com.meliteste.adapters.in.controller.request;

import br.com.meliteste.application.core.domain.Operation;
import br.com.meliteste.application.core.domain.OperationParams;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;

@Getter
@Setter
@ToString
public class OperationRequest {
    private String name;
    private OperationParams params;
    private String externalId;
}
