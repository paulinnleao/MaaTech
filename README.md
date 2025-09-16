# MaaTech System

Bem-vindo ao MaaTech, um sistema completo que combina backend em Spring Boot e frontend em React/Vite. Este projeto tem como objetivo central facilitar a recomendação e gerenciamento de produtos para usuários, incluindo funcionalidades de login, registro, busca de produtos e criação de listas personalizadas de itens.

> ⚠️ **Atenção:** o frontend ainda não está funcional. Apenas o esboço inicial foi implementado e está em desenvolvimento.

---

## Funcionalidades do Sistema

### Backend (Spring Boot)
- **Autenticação e registro de usuários**
    - Login via `/auth/login` usando JWT
    - Registro de novos usuários via `/auth/register`
- **Gerenciamento de usuários**
    - Buscar usuário por ID ou email
    - Criar, atualizar e deletar usuários
- **Gerenciamento de itens (produtos)**
    - CRUD completo de produtos (`/items`)
    - Cada produto possui nome, descrição, modelo, marca, categoria, preço médio, rating, entre outros
- **Listas de itens de usuários**
    - Criar e gerenciar listas personalizadas de produtos para cada usuário
    - Adicionar ou remover itens de listas existentes
- **Integração com API externa**
    - Serviço de recomendação de produtos utilizando `GeminiApiClient`

### Frontend (React + Vite)
- Estrutura inicial do frontend
- Esboço das páginas de login, registro e busca de produtos
- Rodando em Vite (`localhost:5173`)
- ❌ Funcionalidade ainda não implementada

---

## Tecnologias utilizadas

### Backend
- Java 21
- Spring Boot 3
- Spring Security (JWT)
- Spring Data JPA
- PostgreSQL
- FlywayDB (versionamento de banco)
- MapStruct (mapeamento DTO ↔ Entidade)
- Lombok (redução de boilerplate)
- SpringDoc / Swagger (documentação da API)

### Frontend
- React 18
- Vite
- Yarn como gerenciador de pacotes

### Contêineres e Deploy
- Docker e Docker Compose
- Postgres 15 como banco de dados
- Backend e frontend containerizados

---

## Estrutura de Pastas

maatech/
├─ frontend/
│  ├─ src/
│  ├─ Dockerfile
│  ├─ package.json
│  └─ yarn.lock
├─ src/
│  └─ main/
│     └─ java/
│        └─ com/
│           └─ maatech/
│              └─ ...
├─ Dockerfile
├─ pom.xml
├─ docker-compose.yml
└─ README.md

---

## Como rodar localmente

### Pré-requisitos
- Docker
- Docker Compose
- Java 21 (opcional se usar apenas Docker)
- Node 20 (opcional se usar apenas Docker)

### Passos

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/maatech.git
cd maatech

2. Inicie os contêineres:
docker-compose up --build

Isso irá:
- Criar um container PostgreSQL na porta 5432
- Criar o backend Spring Boot na porta 8080
- Criar o frontend React/Vite na porta 5173 (em desenvolvimento, não funcional)

3. Acesse a documentação da API Swagger:
http://localhost:8080/swagger-ui/index.html
```

---

### Endpoints principais

#### Autenticação

| Método | Endpoint           | Descrição                         |
|--------|------------------|-----------------------------------|
| POST   | `/auth/login`     | Login de usuário                  |
| POST   | `/auth/register`  | Registro de novo usuário          |

#### Usuários

| Método | Endpoint             | Descrição                         |
|--------|--------------------|-----------------------------------|
| GET    | `/users/{idUser}`    | Buscar usuário por ID             |
| GET    | `/users/email/{email}` | Buscar usuário por email          |
| GET    | `/users`            | Listar todos os usuários          |
| POST   | `/users`            | Criar novo usuário                |
| PUT    | `/users`            | Atualizar usuário                 |
| DELETE | `/users/{idUser}`    | Deletar usuário por ID            |

#### Itens

| Método | Endpoint              | Descrição                         |
|--------|---------------------|-----------------------------------|
| GET    | `/items/{idItem}`     | Buscar item por ID                |
| GET    | `/items`             | Listar todos os itens             |
| POST   | `/items/{idItem}`     | Criar novo item                   |
| PUT    | `/items/{idItem}`     | Atualizar item existente          |
| DELETE | `/items/{idItem}`     | Deletar item por ID               |

#### Listas de Itens dos Usuários

| Método | Endpoint                      | Descrição                                |
|--------|-------------------------------|------------------------------------------|
| GET    | `/list-of-items/{idUser}`     | Buscar lista de itens de um usuário      |
| GET    | `/list-of-items`              | Listar todas as listas de itens          |
| POST   | `/list-of-items/{idUser}`     | Adicionar novo item à lista do usuário   |
| DELETE | `/list-of-items/{idUser}/{idItem}` | Remover item da lista de um usuário |

---

#### Observações importantes
- O frontend ainda não está funcional e não deve ser usado para testes de interface.
- A aplicação backend está completamente funcional e pode ser testada via Swagger ou via Postman.
- As credenciais padrão do banco de dados (docker-compose) são:
    - **DB:** MaaTech
    - **Usuário:** postgres
    - **Senha:** he282W0AYkmUNXiD

---

### Desenvolvedor

- **Nome:** Paulo Henrique Leão de Oliveira
- **E-mail:** phleaoliveira@gmail.com.br
