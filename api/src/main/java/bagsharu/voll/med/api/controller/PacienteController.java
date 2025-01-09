package bagsharu.voll.med.api.controller;

import bagsharu.voll.med.api.domain.pacientes.DadosCadastroPaciente;
import bagsharu.voll.med.api.domain.pacientes.DadosDetalhadosPaciente;
import bagsharu.voll.med.api.domain.pacientes.Paciente;
import bagsharu.voll.med.api.domain.pacientes.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhadosPaciente> cadastrar(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriBuilder) {

        // Armazenar dados do paciente em uma variável
        var paciente = new Paciente(dados);
        repository.save(paciente);


        // Armazena a URI em uma variável, o objeto uriBuilder pertence ao próprio Spring e cria o endreço
        // acessado pelo client quando um novo médico é cadastrado.
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(paciente.getId()).toUri();

        // Retorna o código 201, a uri e os dados enviados e cadastrados no banco de dados
        return ResponseEntity.created(uri).body(new DadosDetalhadosPaciente(paciente));
    }
}
