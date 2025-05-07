CREATE TABLE aluno (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    matricula VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL,
    idade INTEGER,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE professor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    disciplina VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    registro VARCHAR(50) NOT NULL UNIQUE,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE pontos_aluno (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    aluno_id BIGINT NOT NULL,
    professor_id BIGINT NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    pontos INTEGER NOT NULL,
    data_registro DATETIME NOT NULL,
    observacao TEXT,
    FOREIGN KEY (aluno_id) REFERENCES aluno(id),
    FOREIGN KEY (professor_id) REFERENCES professor(id)
); 