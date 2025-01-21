package bagsharu.voll.med.api.domain.consulta.validacoes;

import bagsharu.voll.med.api.domain.consulta.DadosAgendamentoConsulta;
import bagsharu.voll.med.api.domain.pacientes.PacienteRepository;
import bagsharu.voll.med.api.infra.exception.ValidacaoException;

public class ValidarPacienteAtivo {

    private PacienteRepository pacienteRepository;

    public void validar(DadosAgendamentoConsulta dados){
        var pacienteAtivo = pacienteRepository.findAtivoById(dados.idPaciente());

        if(!pacienteAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendade com paciente excluído");
        }
    }
}
