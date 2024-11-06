package br.com.fiap.odontogenda.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class DentistaNaoEncontradoException extends EntityNotFoundException {
    private static final String MENSAGEM = "Dentista não encontrado";

    public DentistaNaoEncontradoException() {
        super(MENSAGEM);
    }
}
