package bagsharu.voll.med.api.controller;

import bagsharu.voll.med.api.model.medico.DadosCadastroMedico;
import bagsharu.voll.med.api.model.medico.DadosMedicosCadastrados;
import bagsharu.voll.med.api.model.medico.Medico;
import bagsharu.voll.med.api.model.medico.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<DadosMedicosCadastrados> listar(){

        // Retorna uma lista de DadosMedicosCadastrados com base no banco de dados, o map é para
        // converter de Medico para o DTO.
        return repository.findAll().stream().map(DadosMedicosCadastrados::new).toList();
    }
}
