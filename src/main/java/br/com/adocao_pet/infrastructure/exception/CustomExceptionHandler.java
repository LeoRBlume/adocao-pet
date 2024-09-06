package br.com.adocao_pet.infrastructure.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);


    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<ErrorResponseDTO> handleUnprocessableEntityException(UnprocessableEntityException ex) {
        logger.warn("Unprocessable entity encountered: {}", ex.getMessage());
        return new ResponseEntity<>(new ErrorResponseDTO(ex.getMessage(), ex.getCause(), LocalDateTime.now()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
