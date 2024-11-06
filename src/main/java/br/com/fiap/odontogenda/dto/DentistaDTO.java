package br.com.fiap.odontogenda.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link br.com.fiap.odontogenda.models.Dentista}
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DentistaDTO implements Serializable {
    private String id;

    @NotNull(message = "O nomeCompleto deve ser preenchido")
    private String nomeCompleto;

    @NotNull(message = "A dataNascimento deve ser preenchida")
    @Past(message = "A dataNascimento é inválida")
    private LocalDate dataNascimento;

    @NotNull(message = "O numeroTelefone deve ser preenchido")
    private String numeroTelefone;

    @NotNull(message = "O email deve ser preenchido")
    @Email(message = "O email é inválido")
    private String email;

    @NotNull(message = "O endereço deve ser preenchido")
    private EnderecoDTO endereco;

    private List<ConsultaDTO> consultas;
}