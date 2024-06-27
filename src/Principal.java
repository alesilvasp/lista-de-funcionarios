import java.util.*;
import java.util.Locale;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import funcionario.Funcionario;

public class Principal {
        public static void main(String[] args) {

                // 1. Criando as instâncias dos funcionários e guardando em um ArrayList
                var bancoDeDados = new ArrayList<Funcionario>();
                Funcionario func1 = new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"),
                                "Operador");
                Funcionario func2 = new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"),
                                "Operador");
                Funcionario func3 = new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"),
                                "Coordenador");
                Funcionario func4 = new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"),
                                "Diretor");
                Funcionario func5 = new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"),
                                "Recepcionista");
                Funcionario func6 = new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"),
                                "Operador");
                Funcionario func7 = new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"),
                                "Contador");
                Funcionario func8 = new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"),
                                "Gerente");
                Funcionario func9 = new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"),
                                "Eletricista");
                Funcionario func10 = new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"),
                                "Gerente");

                bancoDeDados.addAll(
                                Arrays.asList(func1, func2, func3, func4, func5, func6, func7, func8, func9, func10));

                // 2. Removendo o funcionário com o nome João
                bancoDeDados.removeIf(func -> func.nome.equals("João"));

                // 3. Imprimir informacão dos funcionários (data formatada e valor BRL)
                DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                NumberFormat valor = NumberFormat.getCurrencyInstance(Locale.of("pt", "Br"));

                for (int i = 0; i < bancoDeDados.size(); i++) {
                        Funcionario funcAtual = bancoDeDados.get(i);
                        System.out.printf("Nome: %s, Data de Nascimento: %s, Salário: %s, Função: %s%n",
                                        funcAtual.nome, formatadorData.format(funcAtual.dataNascimento),
                                        valor.format(funcAtual.salario), funcAtual.funcao);
                }

                // 4. Atualizar lista de funcionários com aumento de 10%
                bancoDeDados.forEach(func -> func.setSalario(func.salario.multiply(new BigDecimal("1.10"))));

                // 5. Agrupar funcionários por funcão utilizando o MAP e imprimir
                Map<String, List<Funcionario>> equipes = bancoDeDados.stream()
                                .collect(Collectors.groupingBy(Funcionario::getFuncao));

                equipes.forEach((funcao, funcionarios) -> {
                        System.out.println(funcao);
                        funcionarios.forEach(func -> System.out.println(func.nome));
                });

                // 6. Imprimir funcionários que fazem aniversário mes 10 e 12
                Stream<Funcionario> funcionariosFiltrados = bancoDeDados.stream()
                                .filter(func -> func.dataNascimento.getMonthValue() == 10
                                                || func.dataNascimento.getMonthValue() == 12);

                funcionariosFiltrados.forEach((funcionario) -> {
                        System.out.printf("Funcionário: %s - Data de Nascimento: %s%n", funcionario.nome,
                                        funcionario.dataNascimento);

                });

                // 7. Imprimir funcionários maiores de idade e mostrar nome e idade

                // 8. Imprimir lista de funcionários por ordem alfabética
                Stream<Funcionario> funcionariosOrdenados = bancoDeDados.stream().sorted(Comparator.comparing(Funcionario::getNome));
                funcionariosOrdenados.forEach(funcionario -> System.out.println(funcionario.nome));

                
        }
}
