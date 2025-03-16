package br.com.meliteste.application.core.domain;

public class OperationParams {
    private long id;
    private double value;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "OperationParams{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
