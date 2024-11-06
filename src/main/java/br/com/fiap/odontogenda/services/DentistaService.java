package br.com.fiap.odontogenda.services;

import br.com.fiap.odontogenda.dto.DentistaDTO;

import java.util.List;

public interface DentistaService {
    DentistaDTO salvar(DentistaDTO dentista);
    DentistaDTO consultar(String id);
    List<DentistaDTO> listar();
    void deletar(String id);
    void atualizar(String id, DentistaDTO dentista);
}
