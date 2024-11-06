package br.com.fiap.odontogenda.services;

import br.com.fiap.odontogenda.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {
    ClienteDTO salvar(ClienteDTO clienteDTO);
    ClienteDTO consultar(String id);
    List<ClienteDTO> listar();
    void deletar(String id);
    void atualizar(String id, ClienteDTO clienteDTO);
}
