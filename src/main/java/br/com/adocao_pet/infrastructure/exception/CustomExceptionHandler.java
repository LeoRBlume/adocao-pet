package br.com.adocao_pet.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<ErrorResponseDTO> handleUnprocessableEntityException(UnprocessableEntityException ex) {
        return new ResponseEntity<>(new ErrorResponseDTO(ex.getMessage(), ex.getCause(), LocalDateTime.now()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
