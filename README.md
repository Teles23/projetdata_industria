# Desafio Prático - Programação Java

Este repositório contém a solução para um desafio prático de programação em Java. O objetivo foi simular um sistema de gerenciamento de funcionários em uma indústria, com base nas especificações fornecidas.

## Requisitos

A seguir estão os requisitos solicitados para o desenvolvimento da aplicação:

### 1. Classe `Pessoa`

A classe `Pessoa` contém os seguintes atributos:
- **nome** (String): Nome da pessoa.
- **dataNascimento** (LocalDate): Data de nascimento da pessoa.

### 2. Classe `Funcionario`

A classe `Funcionario` estende a classe `Pessoa` e adiciona os seguintes atributos:
- **salario** (BigDecimal): Salário do funcionário.
- **funcao** (String): Função do funcionário na empresa.

### 3. Funcionalidades Implementadas

A classe **Principal** implementa as seguintes funcionalidades:

#### 3.1 Inserir Funcionários

Foram inseridos os seguintes funcionários, com os dados apresentados na tabela:

- Maria, João, Caio, Miguel, Alice, Heitor, Arthur, Laura, Heloísa, Helena.

#### 3.2 Remover o Funcionário “João”

Foi implementada a remoção do funcionário **João** da lista de funcionários.

#### 3.3 Imprimir Funcionários

A lista de funcionários é impressa com as seguintes informações:
- **Nome** do funcionário.
- **Data de nascimento** no formato `dd/MM/yyyy`.
- **Salário** formatado com separadores de milhar (ponto) e vírgula para decimais.

#### 3.4 Aumento de 10% no Salário

Foi aplicado um aumento de **10%** no salário de todos os funcionários e a lista foi atualizada com os novos valores.

#### 3.5 Agrupar Funcionários por Função

Os funcionários foram agrupados por **função** em um `Map<String, List<Funcionario>>`, onde a chave é a função e o valor é a lista de funcionários que exercem a função.

#### 3.6 Imprimir Funcionários Agrupados por Função

Os funcionários foram impressos de acordo com o agrupamento feito por função.

#### 3.8 Imprimir Funcionários com Aniversário nos Meses 10 e 12

Foram filtrados e impressos os funcionários que fazem aniversário nos meses de **outubro** e **dezembro**.

#### 3.9 Imprimir Funcionário com Maior Idade

Foi calculado e impresso o funcionário com a **maior idade**, exibindo seu nome e idade.

#### 3.10 Imprimir Funcionários em Ordem Alfabética

A lista de funcionários foi ordenada **alfabeticamente** pelo nome.

#### 3.11 Imprimir o Total dos Salários

O total de todos os **salários** dos funcionários foi calculado e impresso.

#### 3.12 Quantos Salários Mínimos Cada Funcionário Ganha

Foi calculado e impresso quantos **salários mínimos** (R$1212,00) cada funcionário recebe.

