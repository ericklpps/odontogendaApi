package br.com.fiap.odontogenda.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Contato {
    @Column(nullable = false, unique = true)
    private String numeroTelefone;

    @Column(nullable = false, unique = true)
    private String email;
}