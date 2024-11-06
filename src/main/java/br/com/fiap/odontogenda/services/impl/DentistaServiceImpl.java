package br.com.fiap.odontogenda.services.impl;

import br.com.fiap.odontogenda.converters.DentistaConverter;
import br.com.fiap.odontogenda.dto.DentistaDTO;
import br.com.fiap.odontogenda.exceptions.DentistaNaoEncontradoException;
import br.com.fiap.odontogenda.models.Dentista;
import br.com.fiap.odontogenda.repositories.DentistaRepository;
import br.com.fiap.odontogenda.services.DentistaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DentistaServiceImpl implements DentistaService {
    
    private final DentistaRepository dentistaRepository;

    @Override
    public DentistaDTO salvar(DentistaDTO dentistaDTO) {
        Dentista dentista = DentistaConverter.paraEntidade(dentistaDTO);
        dentista = dentistaRepository.save(dentista);
        return DentistaConverter.paraDTO(dentista);
    }

    @Override
    public DentistaDTO consultar(String id) {
        Dentista dentista = dentistaRepository.findById(UUID.fromString(id)).orElseThrow(DentistaNaoEncontradoException::new);
        return DentistaConverter.paraDTO(dentista);
    }

    @Override
    public List<DentistaDTO> listar() {
        return dentistaRepository.findAll().stream().map(DentistaConverter::paraDTO).toList();
    }

    @Override
    public void deletar(String id) {
        UUID uuid = UUID.fromString(id);
        if (dentistaRepository.existsById(uuid)) {
            dentistaRepository.deleteById(uuid);
        } else throw new DentistaNaoEncontradoException();
    }

    @Override
    public void atualizar(String id, DentistaDTO dentistaDTO) {
        UUID uuid = UUID.fromString(id);
        Dentista dentista = dentistaRepository.findById(uuid).orElseThrow(DentistaNaoEncontradoException::new);
        DentistaConverter.atualizarEntidade(dentista, dentistaDTO);
        dentistaRepository.save(dentista);
    }
}
