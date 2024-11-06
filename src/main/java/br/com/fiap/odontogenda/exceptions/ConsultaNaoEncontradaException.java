package br.com.fiap.odontogenda.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class ConsultaNaoEncontradaException extends EntityNotFoundException {
    private static final String MENSAGEM = "Consulta não encontrada";

    public ConsultaNaoEncontradaException() {
        super(MENSAGEM);
    }
}
