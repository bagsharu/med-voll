package bagsharu.voll.med.api.domain.pacientes;

import bagsharu.voll.med.api.domain.endereco.Endereco;

public record DadosDetaljadosPaciente(Long id, String nome, String email, String cpf, String telefone, Endereco endereco) {
    public DadosDetaljadosPaciente(Paciente paciente) {
        this(paciente.getId(),paciente.getNome(),paciente.getEmail(),paciente.getCpf(),paciente.getTelefone(),paciente.getEndereco());
    }
}
