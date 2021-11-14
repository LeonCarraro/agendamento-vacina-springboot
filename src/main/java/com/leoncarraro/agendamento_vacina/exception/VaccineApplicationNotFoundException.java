package com.leoncarraro.agendamento_vacina.exception;

public class VaccineApplicationNotFoundException extends RuntimeException {

    public VaccineApplicationNotFoundException(String message) {
        super(message);
    }

}
