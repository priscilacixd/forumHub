# ForumHub - API Rest de Fórum Avançada

![Java](https://img.shields.io/badge/Java-✓-blue)
![Spring](https://img.shields.io/badge/Spring-✓-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-✓-orange)
![Docker](https://img.shields.io/badge/Docker-✓-lightblue)
![Swagger](https://img.shields.io/badge/Swagger-✓-brightgreen)

API completa para um sistema de fórum com autenticação JWT, tópicos, respostas e cursos.

## 🛠 Stack Completa

| Categoria       | Tecnologias                                                                        |
|-----------------|------------------------------------------------------------------------------------|
| **Backend**     | Java 17, Spring Boot 3.5, Spring Security, JWT, Spring Data JPA, Hibernate, Lombok |
| **Banco**       | MySQL 8.0, Flyway (migrações), HikariCP (connection pooling)                       |
| **Documentação**| SpringDoc OpenAPI 3, Swagger UI                                                    |
| **Infra**       | Docker, Docker Compose, Maven            

## 🔍 Recursos Implementados
- Registro e login com JWT
- Roles de usuário
- Password hashing com BCrypt
- Refresh tokens

##  Funcionalidades Principais
- CRUD completo de tópicos, respostas e cursos
- Paginação e ordenação
- Filtros avançados
- Moderação de conteúdo

## 📋 Pré-requisitos

- Docker 20.10+ ([Download Docker](https://www.docker.com/get-started))
- Docker Compose 2.5+
- Java 17+
- Maven 3.8+

## 🛠️ Configuração do Ambiente

### 1. Clone o repositório

```bash
git clone https://github.com/priscilacixd/forumHub.git
cd forumHub
```
### 2. Configure as variáveis de ambiente

Crie um arquivo .env na raiz do projeto:

```bash
DB_ROOT=senha_root
DB_NAME=nome_bd
DB_USER=usuario_bd
DB_PASSWORD=senha_bd
JWT_SECRET=sua_chave_secreta
```

3. Inicie os containers com Docker
   
```bash
docker-compose up --build
```

## 📚 Documentação da API

Acesse a documentação interativa no navegador após iniciar a aplicação:

```text
http://localhost:8080/swagger-ui.html
```

A documentação inclui:

- Lista completa de endpoints
- Modelos de requisição/resposta
- Teste direto dos endpoints na interface
  
## 📝 Licença
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## 👩‍💻 Autora
Priscila Carla - @priscilacixd
