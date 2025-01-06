package bagsharu.voll.med.api.model.medico;

import bagsharu.voll.med.api.model.endereco.DadosEndereco;

public record DadosAtualizadosMedico(Long id, String nome, String telefone, DadosEndereco endereco) {
}
