package br.com.fiap.odontogenda.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link br.com.fiap.odontogenda.models.Endereco}
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoDTO implements Serializable {
    private String id;
    @NotNull(message = "O numero do endereço deve ser preenchido")
    private String numero;
    @NotNull(message = "O logradouro do endereço deve ser preenchido")
    private String logradouro;
    @NotNull(message = "A cidade do endereço deve ser preenchida")
    private String cidade;
    @NotNull(message = "O bairro do endereço deve ser preenchido")
    private String bairro;
    @NotNull(message = "O país do endereço deve ser preenchido")
    private String pais;
}