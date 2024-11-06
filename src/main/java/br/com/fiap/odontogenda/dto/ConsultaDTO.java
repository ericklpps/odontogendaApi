package br.com.fiap.odontogenda.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * DTO for {@link br.com.fiap.odontogenda.models.Consulta}
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultaDTO implements Serializable {
    private String id;

    @NotNull(message = "A data deve ser preenchida")
    @Future(message = "A data deve ser futura")
    private LocalDate data;

    @NotNull(message = "A hora deve ser preenchida")
    @Future(message = "A hora deve ser futura")
    private LocalTime hora;

    private String clienteId;

    private String dentistaId;
}