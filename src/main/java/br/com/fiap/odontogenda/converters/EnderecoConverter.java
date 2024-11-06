package br.com.fiap.odontogenda.converters;

import br.com.fiap.odontogenda.dto.EnderecoDTO;
import br.com.fiap.odontogenda.models.Endereco;

public class EnderecoConverter {

    private EnderecoConverter() {}

    public static Endereco paraEntidade(EnderecoDTO enderecoDTO) {
        return Endereco.builder()
                .pais(enderecoDTO.getPais())
                .bairro(enderecoDTO.getBairro())
                .cidade(enderecoDTO.getCidade())
                .logradouro(enderecoDTO.getLogradouro())
                .numero(enderecoDTO.getNumero())
                .build();
    }

    public static EnderecoDTO paraDTO(Endereco endereco) {
        return EnderecoDTO.builder()
                .id(endereco.getId().toString())
                .pais(endereco.getPais())
                .bairro(endereco.getBairro())
                .cidade(endereco.getCidade())
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .build();
    }
}
