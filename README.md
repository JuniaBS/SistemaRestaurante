# 🍔 Sistema de Restaurante

Aplicação desenvolvida em **Java** para gerenciar as operações de um restaurante, com foco na criação de pedidos, organização do cardápio, personalização de lanches e cálculo do total de vendas.

O projeto foi desenvolvido para colocar em prática conceitos de **Programação Orientada a Objetos, estruturas de dados, princípios de organização de código e testes automatizados**, simulando situações comuns de um sistema de gerenciamento de pedidos.

## 🚀 Tecnologias

- **Java** — desenvolvimento da aplicação.
- **Maven** — gerenciamento de dependências e configuração do projeto.
- **JUnit 5** — testes automatizados.
- **Git e GitHub** — versionamento e gerenciamento do código-fonte.

## 📌 Funcionalidades

O sistema contempla as seguintes funcionalidades, conforme o escopo do projeto:

- Cadastro e validação de lanches.
- Criação de pedidos com identificação automática.
- Associação de pedidos aos clientes.
- Adição de itens e cálculo do valor total de cada pedido.
- Consulta e gerenciamento dos pedidos.
- Cálculo do total de vendas do dia.
- Personalização de lanches por meio da retirada de ingredientes.
- Adição de complementos, como cheddar e bacon extra.
- Alteração e cancelamento de pedidos.
- Identificação das diferentes combinações de lanches vendidos.
- Tratamento de entradas inválidas.
- Testes automatizados das regras de negócio.

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

## 🧩 Organização e arquitetura

O projeto utiliza a separação de responsabilidades para manter o código organizado e facilitar sua manutenção.

| Pacote | Responsabilidade |
|---|---|
| `app` | Inicialização, menu de console e coordenação das operações. |
| `cardapio` | Representação dos lanches, itens do cardápio e adicionais. |
| `pedido` | Criação, consulta e gerenciamento dos pedidos. |
| `financeiro` | Recursos complementares relacionados ao caixa e às transações. |
| `util` | Métodos auxiliares e validações, quando necessários. |

### Conceitos aplicados

**Programação Orientada a Objetos (POO)**

Utilização de classes, encapsulamento e separação de responsabilidades para representar os elementos do sistema.

**Collections Framework**

Utilização de estruturas de dados como `ArrayList`, `HashMap` e `HashSet` para armazenar, consultar e organizar informações.

**Factory**

Centralização da criação dos lanches padrão, reduzindo o acoplamento entre a criação dos objetos e as demais partes do sistema.

**Decorator**

Composição de adicionais sobre os itens do cardápio, permitindo acrescentar descrições e valores sem modificar diretamente a classe original do lanche.

**Testes automatizados**

Utilização do JUnit 5 para verificar validações e regras de negócio.

## 💻 Como executar

### Pré-requisitos

- JDK compatível com a versão configurada no projeto.
- Maven.
- IntelliJ IDEA ou outra IDE compatível com Java.

### Executando pela IDE

1. Clone o repositório.
2. Abra a pasta que contém o arquivo `pom.xml` no IntelliJ IDEA.
3. Aguarde o Maven carregar as dependências.
4. Localize a classe `Main`, no pacote `app`.
5. Execute o método `main()` para iniciar a aplicação.

### Executando os testes

No terminal, dentro da pasta do projeto, execute:

```bash
mvn test
```

O comando compila o projeto e executa os testes configurados no Maven.

## 🎥 Demonstração

**Vídeo de apresentação:** [Acessar demonstração](COLE_AQUI_O_LINK_DO_VIDEO)

A demonstração apresenta a execução da aplicação, a organização do código, a explicação de um padrão de projeto e a execução de um teste automatizado.

## 👩‍💻 Sobre o projeto

Projeto acadêmico desenvolvido para consolidar conhecimentos em Java e praticar conceitos importantes para o desenvolvimento de aplicações back-end, incluindo orientação a objetos, coleções, organização de responsabilidades e testes automatizados.