package bagsharu.voll.med.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Boolean existByMedicoIdAndData(Long aLong, @NotNull @Future LocalDateTime data);

    Boolean existsByPacienteIdAndDataBetween(@NotNull Long aLong, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
}
