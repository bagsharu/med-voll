package bagsharu.voll.med.api.domain.consulta;

import bagsharu.voll.med.api.domain.medico.MedicoRepository;
import bagsharu.voll.med.api.domain.pacientes.PacienteRepository;
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

        // Recebe informações com base no Id
        var paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var medico = medicoRepository.findById(dados.idMedico()).get();

        // Cria um objeto Consulta com todas as informações
        var consulta = new Consulta(null, medico, paciente,dados.data());

        consultaRepository.save(consulta);

    }

}
