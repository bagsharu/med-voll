package bagsharu.voll.med.api.domain.pacientes;

import bagsharu.voll.med.api.domain.endereco.DadosEndereco;
import bagsharu.voll.med.api.domain.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPaciente(@NotBlank String nome,
                                    @NotBlank @Email String email,
                                    @NotBlank String telefone,
                                    @NotBlank String cpf,
                                    @NotNull @Valid DadosEndereco endereco) {
}
