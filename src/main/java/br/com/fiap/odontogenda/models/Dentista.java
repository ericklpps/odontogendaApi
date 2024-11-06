package br.com.fiap.odontogenda.models;

import br.com.fiap.odontogenda.exceptions.HorarioJaMarcadoException;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "og_dentistas")
public class Dentista {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Embedded
    private InfoBasic info;

    @OneToMany(mappedBy = "dentista", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Consulta> consultas = new ArrayList<>();

    public final void checarHorarioDisponivel(LocalDateTime dataHoraRequisitada) {
        LocalDate dataRequisitada = dataHoraRequisitada.toLocalDate();
        LocalTime horaRequisitada = dataHoraRequisitada.toLocalTime();

        trazConsultasComMesmaData(dataRequisitada)
                .filter(consulta -> horarioSobrepoe30minutos(consulta.getHora(), horaRequisitada))
                .findFirst()
                .ifPresent(consulta -> {
                    throw new HorarioJaMarcadoException(consulta.getData().atTime(consulta.getHora()));
                });
    }

    private Stream<Consulta> trazConsultasComMesmaData(LocalDate data) {
        return this.consultas.stream()
                .filter(consulta -> consulta.getData().isEqual(data));
    }

    private boolean horarioSobrepoe30minutos(LocalTime time1, LocalTime time2) {
        long minutosAte = time1.until(time2, ChronoUnit.MINUTES);
        return minutosAte <= 30;
    }
}