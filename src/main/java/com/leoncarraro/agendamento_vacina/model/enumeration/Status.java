package com.leoncarraro.agendamento_vacina.model.enumeration;

public enum Status {

    INATIVO (0),
    ATIVO (1);

    private final int status;

    Status(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

}
