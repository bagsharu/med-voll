package bagsharu.voll.med.api.model.medico;

public record DadosMedicosCadastrados(String nome, String email, String crm, Especialidade especialidade) {

    public DadosMedicosCadastrados(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
