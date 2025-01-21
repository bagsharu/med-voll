package bagsharu.voll.med.api.domain.consulta.validacoes;

import bagsharu.voll.med.api.domain.consulta.DadosAgendamentoConsulta;

public interface ValidadorAgendamento {

    void validar(DadosAgendamentoConsulta dados);
}
