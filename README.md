

# VollMed

VollMed é uma aplicação desenvolvida em **Spring Boot** com integração ao banco de dados **MySQL** que implementa conceitos **REST** para administrar médicos e pacientes de uma clínica.

## Funcionalidades

A aplicação tem as funções **CRUD** para pacientes e médicos, através de requisições **HTTP** é possível **cadastrar**,**listar**, **atualizar** e **apagar** informações sobre médicos e pacientes.


## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação principal.
- **Spring Boot**: Framework para simplificar o desenvolvimento de aplicações web.
  - **Spring Data JPA**: Para integração com o banco de dados.
- **MySQL**: Banco de dados relacional utilizado para persistência.
- **Maven**: Gerenciamento de dependências e build.
- **Flyway**: Para controlar as versões do banco de dados.
- **Lombok**: Para simplificar o código e deixar mais elegante.
- **Bean Validation**: Anotações para validar entrada e saída de dados.

## Pré-requisitos

Antes de rodar o projeto, certifique-se de ter instalado:

- **Java 17** ou superior.
- **Maven**.
- **MySQL**.

### Configuração do Banco de Dados

Certifique-se de criar um banco de dados MySQL e configurar as credenciais no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost/vollmed_api
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASS}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

server.error.include-stacktrace=never
```
É necessário configurar as variáveis locais em seu sistema operacional:

- DB_HOST : Seu host do MySQL
- DB_USER : Seu usuário no banco de dados
- DB_PASS : Sua senha de acesso ao banco de dados

### Como rodar

1. Clone este repositório:

```bash
git git@github.com:bagsharu/med-voll.git
cd vollmed_api
```
2. Compile o projeto:

```bash
mvn clean install
```

3. Execute a aplicação:

```bash
mvn spring-boot:run
```

4. Navegue pelo menu no terminal e explore as funcionalidades!

### Estrutura do Projeto

- **Domanin**: Representa as entidades (pacientes e médicos).

- **Controller**: Controla as requisições.

- **Repository**: Interface para interagir com o banco de dados.

- **Infra**: Para tratamento de erros.

### Melhorias futuras

- Adicionar funções de validação do acesso para segurança.
- Interface de usuário.


### Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests com sugestões de melhorias.

