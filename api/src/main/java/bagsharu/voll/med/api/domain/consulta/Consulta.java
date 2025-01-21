package bagsharu.voll.med.api.domain.consulta;

import bagsharu.voll.med.api.domain.medico.Medico;
import bagsharu.voll.med.api.domain.pacientes.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Optional;

@Table(name = "consultas")
@Entity(name = "Consulta")
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private LocalDateTime data;

    public Consulta(Long id, Medico medico, Paciente paciente, LocalDateTime data) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDateTime getData() {
        return data;
    }
}
