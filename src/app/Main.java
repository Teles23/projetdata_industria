package app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.Funcionario;
import service.FuncionarioService;

public class Main {
	public static void main(String[] args) {

		//    	3.1
		List<Funcionario> funcionarios = new ArrayList<>();
		FuncionarioService funcionarioService = new FuncionarioService();

		funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
		funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
		funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
		funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
		funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
		funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
		funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
		funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
		funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
		funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
		
		//      3.2 - Remover o funcionário “João” da lista.
		Iterator<Funcionario> iterator = funcionarios.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getNome().equalsIgnoreCase("João")) {
				iterator.remove();
			}
		}
		//      3.3 - Imprimir Funcionarios
		funcionarioService.imprimirFuncionarios(funcionarios);
		
		//      3.4 Aumentar 10% ao salário
		funcionarioService.aplicarAumentoSalarial(funcionarios, new BigDecimal("0.10"));
		//      3.5 - Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”
		Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarioService.agruparPorFuncao(funcionarios);
		//      3.6 - Imprimir os funcionários, agrupados por função.  
		for (String funcao : funcionariosPorFuncao.keySet()) {
			System.out.println("Função: " + funcao);
			List<Funcionario> funcionariosDaFuncao = funcionariosPorFuncao.get(funcao);
			for (Funcionario f : funcionariosDaFuncao) {
				System.out.println("  - " + f.getNome());
			}
		}
		//          3.8 - Funcionários que fazem aniversário nos meses 10 e 12
		funcionarioService.listarFuncionariosAniversariantes(funcionarios);

		//          3.9 - Funcionário com maior idade
		funcionarioService.encontrarFuncionarioMaisVelho(funcionarios);

		//          3.10 - Lista de funcionários por ordem alfabética
		funcionarioService.listarFuncionariosPorOrdemAlfabetica(funcionarios);

		//          3.11 - Total dos salários dos funcionários
		funcionarioService.calcularTotalSalarios(funcionarios);

		//          3.12 - Quantidade de salários mínimos por funcionário (considerando R$1212,00)
		funcionarioService.calcularSalariosMinimos(funcionarios);
	}


}
