package bagsharu.voll.med.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentoErros {

    // Anotação Spring para sinalizar que este metodo trata erros "Not Found"
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro4040 (){

        return ResponseEntity.notFound().build();
    }
}
