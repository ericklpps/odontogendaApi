package br.com.fiap.odontogenda.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteDTO implements Serializable {
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

    @NotNull(message = "O usuario deve ser preenchido")
    private String usuario;

    @NotNull(message = "A senha deve ser preenchida")
    @Length(message = "A senha deve ter um mínimo de 8 caractéres", min = 8)
    private String senha;
}
