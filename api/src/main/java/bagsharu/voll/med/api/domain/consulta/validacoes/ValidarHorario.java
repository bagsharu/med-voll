package bagsharu.voll.med.api.domain.consulta.validacoes;

import bagsharu.voll.med.api.domain.consulta.DadosAgendamentoConsulta;
import bagsharu.voll.med.api.infra.exception.ValidacaoException;

import java.time.DayOfWeek;

public class ValidarHorario implements ValidadorAgendamento {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesAbertura = dataConsulta.getHour() < 7;
        var depoisEncerramento = dataConsulta.getHour() > 18;

        if (domingo || antesAbertura || depoisEncerramento) {
            throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica");
        }
    }
}
