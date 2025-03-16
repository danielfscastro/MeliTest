package br.com.meliteste.application.core.domain;

public enum OperationType {
    APPROVE_PAYMENTS("approve_payments"),
    REFUND_PAYMENTS("refund_payments"),
    CANCEL_ACCOUNT("cancel_account"),
    APPLY_DISCOUNT_PURCHASE("apply_discount_purchase");

    private final String value;

    OperationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OperationType fromValue(String value) {
        for (OperationType type : OperationType.values()) {
            if (type.getValue().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant for value: " + value);
    }
}
