package bagsharu.voll.med.api.domain.medico;

public record DadosMedicosCadastrados(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public DadosMedicosCadastrados(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
