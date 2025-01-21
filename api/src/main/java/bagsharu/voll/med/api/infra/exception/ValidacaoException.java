package bagsharu.voll.med.api.infra.exception;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String idDoPacienteNãoEncontrado) {

        super(idDoPacienteNãoEncontrado);
    }
}
