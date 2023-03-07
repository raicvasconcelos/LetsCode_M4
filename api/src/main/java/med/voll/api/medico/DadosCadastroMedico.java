package med.voll.api.medico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import med.voll.api.endereco.DadosEndereco;


@Data
public class DadosCadastroMedico {
    private String nome;
    private String email;
    private String crm;
    private Especialidade especialidade;
    private DadosEndereco endereco;

}
