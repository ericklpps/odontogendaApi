package br.com.fiap.odontogenda.services;

import br.com.fiap.odontogenda.dto.ConsultaDTO;

public interface ConsultaService {
    ConsultaDTO marcar(ConsultaDTO consultaDTO);
    void cancelar(String id);
}
