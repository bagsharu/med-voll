package bagsharu.voll.med.api.domain.consulta.validacoes;

import bagsharu.voll.med.api.domain.consulta.ConsultaRepository;
import bagsharu.voll.med.api.domain.consulta.DadosAgendamentoConsulta;
import bagsharu.voll.med.api.infra.exception.ValidacaoException;

public class ValidarMedicoConsultaMesmoHorario {

    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        var medicoPossuiOutraConsultaMesmoHorario = repository.existByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaMesmoHorario) {
            throw new ValidacaoException("Médico já possui consulta agendada nesse mesmo horário");
        }
    }
}
