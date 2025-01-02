package bagsharu.voll.med.api.model.medico;
import bagsharu.voll.med.api.model.endereco.Endereco;
import jakarta.persistence.*;

@Table(name="medicos")
@Entity(name= "Medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String crm;

    @Embedded
    private Especialidade especialidade;

    @Enumerated(EnumType.STRING)
    private Endereco endereco;
}
