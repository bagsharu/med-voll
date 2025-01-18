package bagsharu.voll.med.api.controller;

import bagsharu.voll.med.api.domain.usuario.DadosAutenticacao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {

        // Converte informações do DTO login/senha para os dados recebidos pelo manager
        var token = new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());
        var auth = manager.authenticate(token);
    }
}
