package bagsharu.voll.med.api.domain.consulta;

import bagsharu.voll.med.api.domain.medico.Medico;
import bagsharu.voll.med.api.domain.medico.MedicoRepository;
import bagsharu.voll.med.api.domain.pacientes.PacienteRepository;
import bagsharu.voll.med.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentoConsulta dados) {

        if(pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("Id do paciente não existe");
        }

        if(dados.idMedico() != null && medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoException("Id do médico não existe");
        }

        // Recebe informações com base no Id
        var paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var medico = escolherMedico(dados);

        // Cria um objeto Consulta com todas as informações
        var consulta = new Consulta(null, medico, paciente,dados.data());

        consultaRepository.save(consulta);

    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if (dados.especialidade() == null) {
            throw new ValidacaoException("Especialidade é obrigatório quando médico não foi escolhido!");
        }

        return medicoRepository.escolherMedicoAleatorio(dados.especialidade());
    }

}
