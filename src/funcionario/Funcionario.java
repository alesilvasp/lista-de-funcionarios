package funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;

import pessoa.Pessoa;

public class Funcionario extends Pessoa {

    public BigDecimal salario;
    public String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }


}
