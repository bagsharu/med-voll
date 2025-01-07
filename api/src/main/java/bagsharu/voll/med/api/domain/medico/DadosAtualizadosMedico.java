package bagsharu.voll.med.api.domain.medico;

import bagsharu.voll.med.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizadosMedico(@NotNull Long id, String nome, String telefone, DadosEndereco endereco) {
}
