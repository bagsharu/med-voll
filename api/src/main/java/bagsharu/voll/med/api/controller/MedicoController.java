package bagsharu.voll.med.api.controller;

import bagsharu.voll.med.api.model.medico.DadosCadastroMedico;
import bagsharu.voll.med.api.model.medico.Medico;
import bagsharu.voll.med.api.model.medico.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroMedico dados) {


        System.out.println(dados);
        repository.save(new Medico(dados));
    }
}
