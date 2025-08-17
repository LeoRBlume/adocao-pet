package br.com.adocao_pet.infrastructure.exception;

import java.time.LocalDateTime;

public record ErrorResponseDTO(String message, Throwable throwable, LocalDateTime timestamp) {

}
