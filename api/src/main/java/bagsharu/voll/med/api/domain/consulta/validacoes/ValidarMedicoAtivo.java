package bagsharu.voll.med.api.domain.consulta.validacoes;

import bagsharu.voll.med.api.domain.consulta.DadosAgendamentoConsulta;
import bagsharu.voll.med.api.domain.medico.MedicoRepository;
import bagsharu.voll.med.api.infra.exception.ValidacaoException;

public class ValidarMedicoAtivo {

    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados){

        if(dados.idMedico() == null){
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo){
            throw new ValidacaoException("Consulta não pode ser agendade com médico excluído.");
        }
    }
}
