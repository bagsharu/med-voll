package bagsharu.voll.med.api.domain.consulta.validacoes;

import bagsharu.voll.med.api.domain.consulta.DadosAgendamentoConsulta;
import bagsharu.voll.med.api.infra.exception.ValidacaoException;

import java.time.Duration;
import java.time.LocalDateTime;

public class ValidarHorarioAntecedencia implements ValidadorAgendamento {
    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30) {
            throw new ValidacaoException("Consulta deve ser agendada com antecedência mínima de 30 minutos");
        }

    }
}
