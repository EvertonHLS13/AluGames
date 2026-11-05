# AluGames

Aplicação backend de console em **Kotlin** que consome uma API REST de jogos,
desserializa o JSON e gerencia o cadastro de gamers e a lista de jogos buscados.

## Funcionalidades

- Consumo de API externa com `HttpClient` para buscar jogos por ID
- Desserialização de JSON com Gson
- Modelagem com classes e data classes (`Jogo`, `Gamer`, `InfoJogo`)
- Tratamento de erros com `runCatching`
- Cadastro de gamer com validação de dados (regex) e encapsulamento
- Lista de jogos buscados, com busca repetida até o usuário sair
- Extension functions (ex.: cálculo de idade a partir da data de nascimento)

## Tecnologias

| Tecnologia | Uso |
|---|---|
| Kotlin | Linguagem principal |
| Maven | Dependências e build |
| Gson | Conversão de JSON para objetos |
| IntelliJ IDEA | IDE |

## Estrutura

```
src/main/kotlin/br/com/alura/alugames/
├── main/        # ponto de entrada (Main.kt)
├── model/       # Gamer, Jogo, Infojogo, InfoApiShark
├── service/     # ConsumoApi (chamadas HTTP)
└── utilitario/  # extension functions
```

## Como executar

Pré-requisitos: JDK 17+ e Maven.

```bash
git clone https://github.com/EvertonHLS13/AluGames.git
cd AluGames
mvn compile
```

Depois abra o projeto no IntelliJ IDEA e execute `Main.kt`.

## Autor

Everton Holanda: [GitHub](https://github.com/EvertonHLS13)
