package bagsharu.voll.med.api.model.medico;

import bagsharu.voll.med.api.model.endereco.DadosEndereco;

public record DadosCadastroMedico(String nome, String email, String crm, bagsharu.voll.med.api.model.endereco.medico.Especialidade especialidade, DadosEndereco endereco) {
}
