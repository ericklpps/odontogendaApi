package br.com.fiap.odontogenda.converters;

import br.com.fiap.odontogenda.dto.ClienteDTO;
import br.com.fiap.odontogenda.dto.EnderecoDTO;
import br.com.fiap.odontogenda.models.Cliente;
import br.com.fiap.odontogenda.models.Contato;
import br.com.fiap.odontogenda.models.Endereco;
import br.com.fiap.odontogenda.models.InfoBasic;

public class ClienteConverter {

    private ClienteConverter() {}

    public static Cliente paraEntidade(ClienteDTO clienteDTO) {
        Endereco endereco = EnderecoConverter.paraEntidade(clienteDTO.getEndereco());

        Contato contato = Contato.builder()
                .email(clienteDTO.getEmail())
                .numeroTelefone(clienteDTO.getNumeroTelefone())
                .build();

        InfoBasic infoBasic = InfoBasic.builder()
                .nomeCompleto(clienteDTO.getNomeCompleto())
                .dataNascimento(clienteDTO.getDataNascimento())
                .contato(contato)
                .endereco(endereco)
                .build();

        return Cliente.builder()
                .info(infoBasic)
                .usuario(clienteDTO.getUsuario())
                .senha(clienteDTO.getSenha())
                .build();
    }



    public static ClienteDTO paraDTO(Cliente cliente) {
        EnderecoDTO endereco = EnderecoConverter.paraDTO(cliente.getInfo().getEndereco());

        return ClienteDTO.builder()
                .id(cliente.getId().toString())
                .nomeCompleto(cliente.getInfo().getNomeCompleto())
                .numeroTelefone(cliente.getInfo().getContato().getNumeroTelefone())
                .email(cliente.getInfo().getContato().getEmail())
                .dataNascimento(cliente.getInfo().getDataNascimento())
                .senha(cliente.getSenha())
                .endereco(endereco)
                .usuario(cliente.getUsuario())
                .build();
    }

    public static void atualizarEntidade(Cliente cliente, ClienteDTO clienteDTO) {
        if (clienteDTO.getEndereco() != null) {
            Endereco endereco = EnderecoConverter.paraEntidade(clienteDTO.getEndereco());
            cliente.getInfo().setEndereco(endereco);
        }

        if (clienteDTO.getEmail() != null || clienteDTO.getNumeroTelefone() != null) {
            Contato contato = Contato.builder()
                    .email(clienteDTO.getEmail())
                    .numeroTelefone(clienteDTO.getNumeroTelefone())
                    .build();
            cliente.getInfo().setContato(contato);
        }

        if (clienteDTO.getNomeCompleto() != null) {
            cliente.getInfo().setNomeCompleto(clienteDTO.getNomeCompleto());
        }

        if (clienteDTO.getDataNascimento() != null) {
            cliente.getInfo().setDataNascimento(clienteDTO.getDataNascimento());
        }

        if (clienteDTO.getUsuario() != null) {
            cliente.setUsuario(clienteDTO.getUsuario());
        }

        if (clienteDTO.getSenha() != null) {
            cliente.setSenha(clienteDTO.getSenha());
        }
    }
}
