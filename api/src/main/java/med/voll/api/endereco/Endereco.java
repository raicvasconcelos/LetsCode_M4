package med.voll.api.endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.getLogradouro();
        this.bairro = dados.getBairro();
        this.cep = dados.getCep();
        this.uf = dados.getUf();
        this.cidade = dados.getCidade();
        this.numero =dados.getNumero();
        this.complemento = dados.getComplemento();
    }
}
