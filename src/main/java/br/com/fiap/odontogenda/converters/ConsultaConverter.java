package br.com.fiap.odontogenda.converters;

import br.com.fiap.odontogenda.dto.ConsultaDTO;
import br.com.fiap.odontogenda.models.Cliente;
import br.com.fiap.odontogenda.models.Consulta;
import br.com.fiap.odontogenda.models.Dentista;

public class ConsultaConverter {

    private ConsultaConverter() {}

    public static Consulta paraEntidade(ConsultaDTO consultaDTO, Dentista dentista, Cliente cliente) {
        return Consulta.builder()
                .cliente(cliente)
                .dentista(dentista)
                .data(consultaDTO.getData())
                .hora(consultaDTO.getHora())
                .build();
    }

    public static ConsultaDTO paraDTO(Consulta consulta) {
        return ConsultaDTO.builder()
                .id(consulta.getId().toString())
                .clienteId(consulta.getCliente().getId().toString())
                .dentistaId(consulta.getDentista().getId().toString())
                .data(consulta.getData())
                .hora(consulta.getHora())
                .build();
    }
}
