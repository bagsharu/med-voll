package bagsharu.voll.med.api.model.medico;

import bagsharu.voll.med.api.model.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizadosMedico(@NotNull Long id, String nome, String telefone, DadosEndereco endereco) {
}
