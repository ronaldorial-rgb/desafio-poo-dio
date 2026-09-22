
# 🎯 Desafio: Aprendendo POO na Prática com Java

Este é meu fork do desafio **"Aprenda na Prática Programação Orientada a Objetos"**,
co-criado pela DIO (Digital Innovation One) e pela cami-la.

O objetivo do desafio é colocar em prática os 4 pilares da Orientação a Objetos:
**Abstração, Encapsulamento, Herança e Polimorfismo**, através de um sistema
que simula um Bootcamp com Cursos, Mentorias e Devs inscritos.

---

## 🚀 Minhas implementações

Apliquei os 4 pilares da seguinte forma:

- **Abstração** → a classe `Conteudo` representa o conceito genérico de
  "algo que um Dev pode aprender" dentro de um Bootcamp.
- **Herança** → `Curso` e `Mentoria` herdam de `Conteudo`, reaproveitando
  `titulo` e `descricao`, e cada uma adiciona seus próprios atributos
  (`cargaHoraria` no Curso, `data` na Mentoria).
- **Encapsulamento** → todos os atributos são privados, acessados apenas
  via getters e setters.
- **Polimorfismo** → o método `calcularXp()` é implementado de forma
  diferente em cada subclasse. Quando o `Dev` soma o XP de seus conteúdos
  concluídos, ele chama `calcularXp()` sem saber se é Curso ou Mentoria —
  cada um responde do seu próprio jeito.

### Estrutura das classes

| Classe | Responsabilidade |
|---|---|
| `Conteudo` | Classe abstrata, base de Curso e Mentoria |
| `Curso` | Conteúdo com carga horária, XP proporcional às horas |
| `Mentoria` | Conteúdo com data, XP fixo |
| `Bootcamp` | Agrupa conteúdos e devs inscritos |
| `Dev` | Se inscreve em bootcamps, progride nos conteúdos e acumula XP |

### ✨ Evoluções adicionadas

Como também estou cursando **Full Stack Java & QA Developer**, decidi
adicionar dois métodos extras na classe `Dev`, pensando em facilitar a
identificação de divergências durante os testes:

- **`calcularProgressoPercentual()`** — calcula quantos % dos conteúdos
  inscritos o Dev já concluiu.
- **`calcularNotaDesempenho(Bootcamp bootcamp)`** — calcula uma nota de
  0 a 10 com base no XP conquistado em relação ao XP total possível do
  bootcamp.

Essa abordagem torna a revisão mais completa, permitindo acompanhar de
forma prática tanto o progresso quanto o desempenho do Dev, sem precisar
recalcular tudo manualmente a cada verificação.

Também implementei `equals()`/`hashCode()` em `Dev` e `Bootcamp`, usando
identificadores estáveis (`UUID` no Dev; `nome`/`descricao`/datas no
Bootcamp) para evitar inconsistências quando esses objetos são usados
dentro de coleções `Set`.


## 🚀 Minhas implementações

Este é meu fork do desafio de POO da [DIO](https://web.digitalinnovation.one/),
co-criado por [cami-la](https://www.linkedin.com/in/cami-la/), onde apliquei
os 4 pilares da Orientação a Objetos (Abstração, Encapsulamento, Herança e
Polimorfismo).

O desafio pedia para modelar um sistema de Bootcamp, com as classes
`Bootcamp`, `Curso`, `Mentoria` e `Dev` relacionadas entre si, aplicando
os 4 pilares de forma prática.

### Evoluções adicionadas
Como também estou cursando Full Stack Java & QA Developer, adicionei
os métodos `calcularProgressoPercentual()` e `calcularNotaDesempenho()`
na classe `Dev`, para facilitar o acompanhamento do progresso e
desempenho do aluno durante os testes...

