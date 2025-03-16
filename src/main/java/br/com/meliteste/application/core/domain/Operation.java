package br.com.meliteste.application.core.domain;

import java.util.HashMap;
import java.util.Objects;

public class Operation {


    private String name;
    private OperationParams params;
    private String externalId;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public OperationParams getParams() {
        return params;
    }
    public void setParams(OperationParams params) {
        this.params = params;
    }
    public String getExternalId() {
        return externalId;
    }
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "name='" + name + '\'' +
                ", params=" + params +
                ", externalId='" + externalId + '\'' +
                '}';
    }

}