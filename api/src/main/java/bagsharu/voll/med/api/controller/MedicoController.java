package bagsharu.voll.med.api.controller;

import bagsharu.voll.med.api.model.medico.DadosCadastroMedico;
import bagsharu.voll.med.api.model.medico.Medico;
import bagsharu.voll.med.api.model.medico.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    }
}
