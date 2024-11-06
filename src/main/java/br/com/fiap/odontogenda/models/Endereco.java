package br.com.fiap.odontogenda.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "og_enderecos")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false, length = 10)
    private String numero;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false, length = 100)
    private String cidade;

    @Column(nullable = false, length = 50)
    private String bairro;

    @Column(nullable = false, length = 100)
    private String pais;
}