# API Controle Aluno Presente

API REST para gestão de alunos, professores, turmas e pontos em um ambiente escolar. Desenvolvido em Java 17 com Spring Boot, autenticação JWT, persistência com JPA e Flyway para migração de banco de dados.

## Funcionalidades

- Cadastro, consulta, atualização e remoção de alunos e professores
- Gerenciamento de turmas e associação de professores
- Registro e consulta de pontos dos alunos
- Autenticação e autorização via JWT

## Entidades Principais

- **Aluno**: nome, matrícula, email, idade, username, senha
- **Professor**: nome, disciplina, email, registro, username, senha
- **Turma**: nome, descrição, professor responsável
- **PontosAluno**: pontos atribuídos a alunos por professores

## Endpoints Principais

### Autenticação

- `POST /api/auth/login`: autenticação de usuário (aluno ou professor), retorna token JWT

### Alunos

- `POST /api/alunos`: cria aluno
- `GET /api/alunos`: lista todos os alunos
- `GET /api/alunos/{id}`: busca aluno por ID
- `PUT /api/alunos/{id}`: atualiza aluno
- `DELETE /api/alunos/{id}`: remove aluno

### Professores

- `POST /api/professores`: cria professor
- `GET /api/professores`: lista todos os professores
- `GET /api/professores/{id}`: busca professor por ID
- `PUT /api/professores/{id}`: atualiza professor
- `DELETE /api/professores/{id}`: remove professor
- `GET /api/professores/{professorId}/turmas`: lista turmas do professor

### Pontos dos Alunos

- `POST /api/pontos`: registra pontos para aluno (apenas professor)
- `GET /api/pontos/aluno/{alunoId}`: lista pontos de um aluno
- `GET /api/pontos/professor/{professorId}`: lista pontos lançados por um professor

## Requisitos

- Java 17+
- Maven
- Docker (opcional)

## Configuração

As configurações estão em `src/main/resources/application.properties`. Por padrão, utiliza banco H2 em memória para desenvolvimento. Para produção, configure as variáveis do MariaDB.

## Executando Localmente

```
./mvnw clean package
java -jar target/escola-api-1.0.0.jar
```

A API estará disponível em `http://localhost:9090`.

## Executando com Docker

```
docker build -t escola-api .
docker run -p 9090:9090 escola-api
```

## Migração de Banco

O projeto utiliza Flyway para versionamento do banco de dados. Scripts de migração estão em `src/main/resources/db/migration`.

## Autenticação

A autenticação é feita via JWT. Após login, inclua o token no header `Authorization: Bearer <token>` para acessar endpoints protegidos.

// TODO: Atualizar este README conforme novas funcionalidades forem implementadas. 