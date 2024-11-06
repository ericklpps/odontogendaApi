package br.com.fiap.odontogenda.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class ClienteNaoEncontradoException extends EntityNotFoundException {
    private static final String MENSAGEM = "Cliente não encontrado";

    public ClienteNaoEncontradoException() {
        super(MENSAGEM);
    }
}
