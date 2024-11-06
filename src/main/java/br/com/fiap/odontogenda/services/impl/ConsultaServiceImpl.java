package br.com.fiap.odontogenda.services.impl;

import br.com.fiap.odontogenda.converters.ConsultaConverter;
import br.com.fiap.odontogenda.dto.ConsultaDTO;
import br.com.fiap.odontogenda.exceptions.ClienteNaoEncontradoException;
import br.com.fiap.odontogenda.exceptions.DentistaNaoEncontradoException;
import br.com.fiap.odontogenda.models.Cliente;
import br.com.fiap.odontogenda.models.Consulta;
import br.com.fiap.odontogenda.models.Dentista;
import br.com.fiap.odontogenda.repositories.ClienteRepository;
import br.com.fiap.odontogenda.repositories.ConsultaRepository;
import br.com.fiap.odontogenda.repositories.DentistaRepository;
import br.com.fiap.odontogenda.services.ConsultaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final ClienteRepository clienteRepository;
    private final DentistaRepository dentistaRepository;

    @Override
    public ConsultaDTO marcar(ConsultaDTO consultaDTO) {
        Cliente cliente = clienteRepository.findById(UUID.fromString(consultaDTO.getClienteId()))
                .orElseThrow(ClienteNaoEncontradoException::new);

        Dentista dentista = dentistaRepository.findById(UUID.fromString(consultaDTO.getDentistaId()))
                .orElseThrow(DentistaNaoEncontradoException::new);

        dentista.checarHorarioDisponivel(consultaDTO.getData().atTime(consultaDTO.getHora()));

        Consulta consulta = ConsultaConverter.paraEntidade(consultaDTO, dentista, cliente);

        consulta = consultaRepository.save(consulta);

        return ConsultaConverter.paraDTO(consulta);
    }

    @Override
    public void cancelar(String id) {
        UUID uuid = UUID.fromString(id);
        if (consultaRepository.existsById(uuid)) {
            consultaRepository.deleteById(uuid);
        } else throw new DentistaNaoEncontradoException();
    }
}
