package com.leoncarraro.agendamento_vacina.exception.handler;

import com.leoncarraro.agendamento_vacina.exception.LoginException;
import com.leoncarraro.agendamento_vacina.exception.UserNotFoundException;
import com.leoncarraro.agendamento_vacina.exception.VaccineApplicationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler({ UserNotFoundException.class, LoginException.class })
    public ResponseEntity<ErrorResponse> loginExceptionHandler(Exception exception) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(exception.getMessage())
                .httpStatusCode(HttpStatus.FORBIDDEN.value())
                .build();

        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(errorResponse);
    }

    @ExceptionHandler({ VaccineApplicationNotFoundException.class })
    public ResponseEntity<ErrorResponse> vaccineApplicationNotFoundExceptionHandler(Exception exception) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(exception.getMessage())
                .httpStatusCode(HttpStatus.NOT_FOUND.value())
                .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }
}
