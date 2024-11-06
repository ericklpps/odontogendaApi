package br.com.fiap.odontogenda.converters;

import br.com.fiap.odontogenda.dto.ConsultaDTO;
import br.com.fiap.odontogenda.dto.DentistaDTO;
import br.com.fiap.odontogenda.dto.EnderecoDTO;
import br.com.fiap.odontogenda.models.*;

import java.util.ArrayList;
import java.util.List;

public class DentistaConverter {

    private DentistaConverter() {}

    public static Dentista paraEntidade(DentistaDTO dentistaDTO) {
        Endereco endereco = EnderecoConverter.paraEntidade(dentistaDTO.getEndereco());

        Contato contato = Contato.builder()
                .email(dentistaDTO.getEmail())
                .numeroTelefone(dentistaDTO.getNumeroTelefone())
                .build();

        InfoBasic infoBasic = InfoBasic.builder()
                .nomeCompleto(dentistaDTO.getNomeCompleto())
                .dataNascimento(dentistaDTO.getDataNascimento())
                .contato(contato)
                .endereco(endereco)
                .build();

        return Dentista.builder()
                .info(infoBasic)
                .build();
    }

    public static DentistaDTO paraDTO(Dentista dentista) {
        EnderecoDTO endereco = EnderecoConverter.paraDTO(dentista.getInfo().getEndereco());
        List<Consulta> consultas = dentista.getConsultas();
        List<ConsultaDTO> consultaDTOS = new ArrayList<>();

        if (consultas != null && !consultas.isEmpty()) {
            consultaDTOS.addAll(dentista.getConsultas().stream().map(ConsultaConverter::paraDTO).toList());
        }
        return DentistaDTO.builder()
                .id(dentista.getId().toString())
                .nomeCompleto(dentista.getInfo().getNomeCompleto())
                .numeroTelefone(dentista.getInfo().getContato().getNumeroTelefone())
                .email(dentista.getInfo().getContato().getEmail())
                .dataNascimento(dentista.getInfo().getDataNascimento())
                .endereco(endereco)
                .consultas(consultaDTOS)
                .build();
    }

    public static void atualizarEntidade(Dentista dentista, DentistaDTO dentistaDTO) {
        if (dentistaDTO.getEndereco() != null) {
            Endereco endereco = EnderecoConverter.paraEntidade(dentistaDTO.getEndereco());
            dentista.getInfo().setEndereco(endereco);
        }

        if (dentistaDTO.getEmail() != null || dentistaDTO.getNumeroTelefone() != null) {
            Contato contato = Contato.builder()
                    .email(dentistaDTO.getEmail())
                    .numeroTelefone(dentistaDTO.getNumeroTelefone())
                    .build();
            dentista.getInfo().setContato(contato);
        }

        if (dentistaDTO.getNomeCompleto() != null) {
            dentista.getInfo().setNomeCompleto(dentistaDTO.getNomeCompleto());
        }

        if (dentistaDTO.getDataNascimento() != null) {
            dentista.getInfo().setDataNascimento(dentistaDTO.getDataNascimento());
        }
    }
}
