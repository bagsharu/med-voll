package bagsharu.voll.med.api.domain.consulta;

import bagsharu.voll.med.api.domain.medico.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(Long idMedico, @NotNull Long idPaciente, @NotNull @Future LocalDateTime data, Especialidade especialidade) {
}
