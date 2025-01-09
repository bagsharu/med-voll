package bagsharu.voll.med.api.domain.pacientes;

import bagsharu.voll.med.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizadosPaciente(@NotNull Long id, String nome, String telefone, DadosEndereco endereco) {
}
