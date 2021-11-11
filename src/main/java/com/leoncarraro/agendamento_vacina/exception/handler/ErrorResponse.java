package com.leoncarraro.agendamento_vacina.exception.handler;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private final String message;
    private final Integer httpStatusCode;

}
