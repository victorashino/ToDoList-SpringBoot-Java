# 📌 To-Do List API

Este é um projeto simples de To-Do List desenvolvido com Spring Boot. A API permite criar, listar, atualizar e excluir tarefas.

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- Spring Data JPA
- MariaDB
- Docker
- Swagger

## 📦 Como Rodar o Projeto

### 1️⃣ Clonar o Repositório

```sh
git clone https://github.com/seu-usuario/todo-list-spring.git
cd todo-list-spring
```

### 2️⃣ Configurar o Banco de Dados

Crie um banco de dados no MariaDB e configure o `application.properties`:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/todolist
spring.datasource.username=root
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update
```

### 3️⃣ Rodar o Projeto

Com Gradle:

```sh
./gradlew bootRun
```

Com Docker (opcional):

```sh
docker-compose up -d
```

## 🛠 Endpoints da API

### Criar uma Tarefa
```http
POST /todos/
```
**Body:**
```json
{
  "name": "Comprar leite",
  "description": "Ir ao mercado comprar leite",
  "done": false,
  "priority": 2
}
```

### Listar Todas as Tarefas
```http
GET /todos/
```

### Atualizar uma Tarefa
```http
PUT /todos/
```
**Body:**
```json
{
  "name": "Comprar pão",
  "description": "Ir à padaria comprar pão",
  "done": true,
  "priority": 1
}
```

### Deletar uma Tarefa
```http
DELETE /todos/{id}
```

## 🧪 Testando a API

Você pode testar a API utilizando o [Postman](https://www.postman.com/) ou via terminal com `curl`:

```sh
curl -X GET http://localhost:8080/tasks
```

## 🌐 Documentação Interativa com Swagger
A documentação interativa da API pode ser acessada na seguinte URL após rodar o projeto:

http://localhost:8080/swagger-ui.html

Aqui, você poderá visualizar e testar todos os endpoints da API de forma intuitiva.

## 🐳 Rodando com Docker

Crie um `docker-compose.yml` para subir a aplicação e o banco:

```yaml
version: '3.8'

services:
  db:
    image: mariadb:latest
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: 1234
      MYSQL_DATABASE: todolist
    ports:
      - "3306:3306"

  app:
    build: .
    depends_on:
      - db
    environment:
      SPRING_DATASOURCE_URL: jdbc:mariadb://db:3306/todolist
      SPRING_DATASOURCE_USERNAME: root
      SPRING_DATASOURCE_PASSWORD: 1234
    ports:
      - "8080:8080"
```

Para rodar:

```sh
docker-compose up -d --build
```
