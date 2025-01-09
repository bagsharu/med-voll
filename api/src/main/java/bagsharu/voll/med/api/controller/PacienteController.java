package bagsharu.voll.med.api.controller;

import bagsharu.voll.med.api.domain.medico.DadosMedicosCadastrados;
import bagsharu.voll.med.api.domain.pacientes.DadosCadastroPaciente;
import bagsharu.voll.med.api.domain.pacientes.DadosDetalhadosPaciente;
import bagsharu.voll.med.api.domain.pacientes.Paciente;
import bagsharu.voll.med.api.domain.pacientes.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public ResponseEntity<Page<DadosDetalhadosPaciente>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {

        // Retorna uma lista de DadosCadastroPaciente com base no banco de dados, o map é para
        // converter de Medico para o DTO.
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosDetalhadosPaciente::new);
        
        return ResponseEntity.ok(page);
    }
}
