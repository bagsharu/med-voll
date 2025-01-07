package bagsharu.voll.med.api.controller;

import bagsharu.voll.med.api.model.medico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


        //System.out.println(dados);
        repository.save(new Medico(dados));
    }

    @GetMapping
    public ResponseEntity <Page<DadosMedicosCadastrados>> listar(Pageable paginacao){

        // Retorna uma lista de DadosMedicosCadastrados com base no banco de dados, o map é para
        // converter de Medico para o DTO.
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosMedicosCadastrados::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizadosMedico dados) {

        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

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
