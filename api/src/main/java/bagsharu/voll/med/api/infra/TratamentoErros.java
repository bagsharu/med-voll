package bagsharu.voll.med.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentoErros {

    // Anotação Spring para sinalizar que este metodo trata erros "Not Found"
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404 (){

        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400 (MethodArgumentNotValidException exception) {

        // Armazena os erros em uma variável
        var erros = exception.getFieldErrors();

        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());

    }

    // DTO contendo informações relevantes sobre o erro de validação
    private record DadosErroValidacao(String campo, String mensagem) {

        // Construtor recebe as informações do erro de validação, com o campo e a mensagem referente
        public DadosErroValidacao(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
