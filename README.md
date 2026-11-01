# 🍔 Sistema de Restaurante

Aplicação desenvolvida em **Java** para gerenciamento de pedidos de um restaurante, com cardápio personalizável, controle de pedidos e operações de caixa.

O projeto foi desenvolvido durante o bootcamp **ElasTech Java + IA**, com foco na prática de **Programação Orientada a Objetos, princípios SOLID, padrões de projeto, coleções e testes automatizados**, simulando funcionalidades de um sistema de gerenciamento de restaurante.

## ✨ Funcionalidades

- Criação de pedidos com identificação automática.
- Associação de pedidos aos clientes.
- Adição, alteração e cancelamento de pedidos.
- Cardápio com X-Burger, X-Salada e X-Bacon.
- Personalização de lanches por remoção de ingredientes.
- Adição de cheddar e bacon extra.
- Cálculo do valor dos pedidos e do total de vendas do dia.
- Identificação de combinações diferentes de lanches.
- Contagem de lanches-base vendidos.
- Validação de nomes e tratamento de entradas inválidas.
- Registro de gorjetas e despesas.
- Consulta de entradas, saídas e saldo do caixa.
- Prevenção de transações duplicadas para o mesmo pedido.

## 🍟 Cardápio

| Lanche | Preço |
|---|---:|
| X-Burger | R$ 16,00 |
| X-Salada | R$ 18,00 |
| X-Bacon | R$ 22,00 |

### Adicionais

| Adicional | Preço |
|---|---:|
| Cheddar | R$ 4,00 |
| Bacon extra | R$ 6,00 |

## 🛠️ Tecnologias

- Java 22
- Maven
- JUnit 5
- Mockito
- Lombok
- Git e GitHub

As versões e configurações das dependências estão definidas no `pom.xml`.

## 🏗️ Arquitetura e organização

O projeto utiliza separação de responsabilidades para organizar a aplicação e facilitar sua manutenção.

| Pacote | Responsabilidade |
|---|---|
| `app` | Inicialização, interação com o usuário e coordenação dos casos de uso. |
| `cardapio` | Lanches, itens do cardápio, Factory e Decorators. |
| `pedido` | Representação e gerenciamento dos pedidos. |
| `financeiro` | Caixa e transações financeiras. |

### Principais classes

- **Main:** inicia a aplicação e controla o fluxo principal.
- **MenuConsole:** realiza a leitura de dados e exibe mensagens no console.
- **RestauranteFacade:** coordena as operações do sistema.
- **LancheFactory:** cria os lanches padrão.
- **ComCheddar e ComBaconExtra:** adicionam complementos utilizando o padrão Decorator.
- **GerenciadorPedidos:** cria, busca, lista, cancela e resume pedidos.
- **Caixa:** registra entradas, gorjetas, despesas e saldo.
- **Transacao:** representa uma entrada financeira vinculada a um pedido.

## 🧠 Conceitos e padrões aplicados

### Programação Orientada a Objetos

Uso de classes, encapsulamento e separação de responsabilidades para representar os elementos do sistema.

### Factory

A `LancheFactory` centraliza a criação dos lanches padrão e permite criar novas instâncias para cada pedido.

### Decorator

Os decorators `ComCheddar` e `ComBaconExtra` acrescentam descrição e preço aos itens do cardápio sem modificar diretamente o lanche-base.

### Collections Framework

Utilização de `ArrayList`, `HashMap`, `HashSet` e `Set` para armazenar e organizar pedidos, itens, transações e combinações de lanches.

### Testes automatizados

Utilização de JUnit 5 e Mockito para apoiar a validação das funcionalidades e regras de negócio.

## 🚀 Como executar

### Pré-requisitos

- JDK 22
- Maven
- IntelliJ IDEA ou outra IDE compatível com Java

### Executar pela IDE

1. Clone o repositório.
2. Abra no IntelliJ IDEA a pasta que contém o `pom.xml`.
3. Aguarde o Maven carregar as dependências.
4. Execute a classe `app.Main`.

### Executar os testes

Na pasta do projeto, execute:

```bash
mvn test
```

### Gerar o pacote

Para compilar o projeto, executar os testes e gerar o JAR:

```bash
mvn package
```

O JAR será gerado em `target/meu-projeto-1.0-SNAPSHOT.jar`, e as dependências serão copiadas para `target/libs`.

> **Nota:** o JAR gerado não inclui automaticamente as dependências. Para executar a aplicação empacotada, utilize a IDE ou configure o classpath com as bibliotecas de `target/libs`.

## 🎥 Demonstração

**Vídeo de apresentação:** [Acessar demonstração](https://github.com/JuniaBS/SistemaRestaurante/blob/feature/gerenciador-pedidos/COLE_AQUI_O_LINK_DO_VIDEO)

O vídeo apresentará a execução da aplicação, a organização do código, um padrão de projeto utilizado e a execução de testes automatizados.

## 👩‍💻 Sobre o projeto

Projeto acadêmico desenvolvido durante o bootcamp ElasTech Java + IA para consolidar conhecimentos em Java e praticar conceitos relevantes para o desenvolvimento back-end, incluindo orientação a objetos, padrões de projeto, coleções, organização de responsabilidades e testes automatizados.
