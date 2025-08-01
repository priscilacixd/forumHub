create table usuarios (

    id bigint NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    login VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    perfil VARCHAR(100) NOT NULL,
    ativo TINYINT(1) DEFAULT 1,

    primary key(id)
);

CREATE TABLE cursos (

    id bigint NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    ativo TINYINT(1) DEFAULT 1,

    primary key(id)
);

CREATE TABLE respostas (

     id bigint NOT NULL AUTO_INCREMENT,
     mensagem TEXT NOT NULL,
     solucao TINYINT(1) DEFAULT 0,
     data_criacao DATETIME NOT NULL,
     ativo TINYINT(1) DEFAULT 1,
     autor_id bigint NOT NULL,
     topico_id bigint NOT NULL,

     primary key (id),

     constraint fk_respostas_autor_id foreign key (autor_id) references usuarios(id)

);

create table topicos (

    id bigint NOT NULL auto_increment,
    titulo VARCHAR(200) NOT NULL,
    mensagem TEXT NOT NULL,
    data_criacao DATETIME NOT NULL,
    status VARCHAR(100) DEFAULT 'SEM_RESPOSTA',
    ativo TINYINT(1) DEFAULT 1,
    curso_id BIGINT NOT NULL,
    resposta_id BIGINT,
    autor_id BIGINT NOT NULL,

    primary key (id),

    constraint fk_topicos_curso_id foreign key (curso_id) references cursos(id),
    constraint fk_topicos_resposta_id foreign key (resposta_id) references respostas(id),
    constraint fk_topicos_autor_id foreign key (autor_id) references usuarios(id)

);

ALTER TABLE respostas ADD CONSTRAINT fk_respostas_topico_id FOREIGN KEY(topico_id) REFERENCES topicos(id);

