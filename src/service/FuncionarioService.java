package service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;


import model.Funcionario;
import util.FormatadorUtil;

public class FuncionarioService {

	public void imprimirFuncionarios(List<Funcionario> funcionarios) {
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Data de Nascimento: " + FormatadorUtil.formatarData(funcionario.getDataNascimento()));
			System.out.println("Salário: " + FormatadorUtil.formatarMoeda(funcionario.getSalario()));
			System.out.println("Função: " + funcionario.getFuncao());
			System.out.println();
		}
	}
	public void aplicarAumentoSalarial(List<Funcionario> funcionarios, BigDecimal percentual) {
		funcionarios.forEach(f -> f.setSalario((f.getSalario().multiply(percentual)).add(f.getSalario())));
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Data de Nascimento: " + FormatadorUtil.formatarData(funcionario.getDataNascimento()));
			System.out.println("Salário: " + FormatadorUtil.formatarMoeda(funcionario.getSalario()));
			System.out.println("Função: " + funcionario.getFuncao());
			System.out.println();
		}
	}	
	public Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
		Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();

		for (Funcionario funcionario : funcionarios) {

			if (!funcionariosPorFuncao.containsKey(funcionario.getFuncao())) {
				funcionariosPorFuncao.put(funcionario.getFuncao(), new ArrayList<>());
			}


			funcionariosPorFuncao.get(funcionario.getFuncao()).add(funcionario);
		}

		return funcionariosPorFuncao;
	}
	public void listarFuncionariosAniversariantes(List<Funcionario> funcionarios) {
		System.out.println("\nFuncionários que fazem aniversário em outubro e dezembro:");

		funcionarios.stream()
		.filter(f -> f.getDataNascimento().getMonthValue() == 10 || f.getDataNascimento().getMonthValue() == 12)
		.forEach(f -> {
			String dataFormatada = FormatadorUtil.formatarData(f.getDataNascimento());  
			System.out.println(" - " + f.getNome() + " (Nascimento: " + dataFormatada + ")");
		});
	}
	public Funcionario encontrarFuncionarioMaisVelho(List<Funcionario> funcionarios) {
		Funcionario maisVelho = null; 
		int idadeMaisVelho = 0; 

		for (Funcionario f : funcionarios) {
			int idade = Period.between(f.getDataNascimento(), LocalDate.now()).getYears(); 

			if (idade > idadeMaisVelho) { 
				maisVelho = f; 
				idadeMaisVelho = idade; 
			}
		}


		System.out.println("\nFuncionário mais velho:");
		System.out.println(" - Nome: " + maisVelho.getNome() + ", Idade: " + idadeMaisVelho + " anos");

		return maisVelho; 
	}
	public void listarFuncionariosPorOrdemAlfabetica(List<Funcionario> funcionarios) {

		funcionarios.sort(Comparator.comparing(Funcionario::getNome));


		System.out.println("\nLista de funcionários em ordem alfabética:");
		for (Funcionario f : funcionarios) {
			System.out.println(" - " + f.getNome());
		}
	}
	public void calcularTotalSalarios(List<Funcionario> funcionarios) {
		BigDecimal totalSalarios = BigDecimal.ZERO;


		for (Funcionario f : funcionarios) {
			totalSalarios = totalSalarios.add(f.getSalario());
		}


		System.out.println("\nTotal dos salários: R$ " + FormatadorUtil.formatarMoeda(totalSalarios));
	}
	public void calcularSalariosMinimos(List<Funcionario> funcionarios) {
		BigDecimal salarioMinimo = new BigDecimal("1212.00");

		System.out.println("\nQuantidade de salários mínimos por funcionário:");
		for (Funcionario f : funcionarios) {
			BigDecimal qtdSalariosMinimos = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
			System.out.println(" - " + f.getNome() + ": " + qtdSalariosMinimos + " salários mínimos");
		}
	}
}
