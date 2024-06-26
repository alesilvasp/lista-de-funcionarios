package funcionario;

import java.math.BigDecimal;

import pessoa.Pessoa;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public BigDecimal getSalario() {
        return salario;
    }

    public String getFuncao() {
        return funcao;
    }
}
