package br.com.fiap.odontogenda.services.impl;

import br.com.fiap.odontogenda.converters.ClienteConverter;
import br.com.fiap.odontogenda.dto.ClienteDTO;
import br.com.fiap.odontogenda.exceptions.ClienteNaoEncontradoException;
import br.com.fiap.odontogenda.models.Cliente;
import br.com.fiap.odontogenda.repositories.ClienteRepository;
import br.com.fiap.odontogenda.services.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteDTO salvar(ClienteDTO clienteDTO) {
        Cliente cliente = ClienteConverter.paraEntidade(clienteDTO);
        cliente = clienteRepository.save(cliente);
        return ClienteConverter.paraDTO(cliente);
    }

    @Override
    public ClienteDTO consultar(String id) {
        Cliente cliente = clienteRepository.findById(UUID.fromString(id)).orElseThrow(ClienteNaoEncontradoException::new);
        return ClienteConverter.paraDTO(cliente);
    }

    @Override
    public List<ClienteDTO> listar() {
        return clienteRepository.findAll().stream().map(ClienteConverter::paraDTO).toList();
    }

    @Override
    public void deletar(String id) {
        UUID uuid = UUID.fromString(id);
        if (clienteRepository.existsById(uuid)) {
            clienteRepository.deleteById(uuid);
        } else throw new ClienteNaoEncontradoException();
    }

    @Override
    public void atualizar(String id, ClienteDTO clienteDTO) {
        UUID uuid = UUID.fromString(id);
        Cliente cliente = clienteRepository.findById(uuid).orElseThrow(ClienteNaoEncontradoException::new);
        ClienteConverter.atualizarEntidade(cliente, clienteDTO);
        clienteRepository.save(cliente);
    }
}
