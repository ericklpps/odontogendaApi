package br.com.fiap.odontogenda.dto;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public record ErrorDTO(Object message, LocalDateTime timestamp) {
    public ErrorDTO(Object message) {
        this(message, LocalDateTime.now().atOffset(ZoneOffset.UTC).toLocalDateTime());
    }
}
