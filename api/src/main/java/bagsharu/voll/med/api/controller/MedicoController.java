package bagsharu.voll.med.api.controller;

import bagsharu.voll.med.api.model.medico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhadosMedico> cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder) {

        /*

        O POST devolve um código HTTP 201, porém este código exige informações adicionais como:
        URI (Location), um body com as informações enviadas e o código 201.

        */

        // Armazena os dados recebidos em uma variável e salva no banco de dados
        var medicoCadastro = new Medico(dados);
        repository.save(medicoCadastro);

        // Armazena a URI em uma variável, o objeto uriBuilder pertence ao próprio Spring e cria o endreço
        // acessado pelo client quando um novo médico é cadastrado.
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medicoCadastro.getId()).toUri();

        // Retorna o código 201, a uri e os dados enviados e cadastrados no banco de dados
        return ResponseEntity.created(uri).body(new DadosDetalhadosMedico(medicoCadastro));
    }

    @GetMapping
    public ResponseEntity <Page<DadosMedicosCadastrados>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){

        // Retorna uma lista de DadosMedicosCadastrados com base no banco de dados, o map é para
        // converter de Medico para o DTO.
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosMedicosCadastrados::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizadosMedico dados) {

        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhadosMedico(medico));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
//        repository.deleteById(id);
        var medico = repository.getReferenceById(id);
        medico.excluir();

        return ResponseEntity.noContent().build();
    }
}
