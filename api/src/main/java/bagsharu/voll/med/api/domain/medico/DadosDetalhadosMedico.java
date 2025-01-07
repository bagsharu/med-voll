package bagsharu.voll.med.api.domain.medico;

import bagsharu.voll.med.api.domain.endereco.Endereco;

public record DadosDetalhadosMedico(Long id, String nome, String email, String crm, String telefone, Especialidade especialidade, Endereco endereco) {
    public DadosDetalhadosMedico (Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());

    }
}
