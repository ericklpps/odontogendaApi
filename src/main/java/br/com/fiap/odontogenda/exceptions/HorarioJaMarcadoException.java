package br.com.fiap.odontogenda.exceptions;

import java.time.LocalDateTime;

public class HorarioJaMarcadoException extends RuntimeException {
    private static final String MENSAGEM = "Horário já marcado: %s, o horário escolhido deve ser no mínimo 30 minutos após último agendamento";

    public HorarioJaMarcadoException(LocalDateTime horarioMarcado) {
        super(String.format(MENSAGEM, horarioMarcado.toString()));
    }
}
