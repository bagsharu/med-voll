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

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {

        /*

        O POST devolve um código HTTP 201, porém este código exige informações adicionais como:
        URI (Location), um body com as informações enviadas e o código 201.

        */
        repository.save(new Medico(dados));
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
