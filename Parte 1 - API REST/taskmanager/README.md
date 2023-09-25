# Visão geral

O projeto é uma aplicação back-end com objetivo de demonstrar a produtividade de construir APIs utilizando os frameworks [Spring Boot](https://projects.spring.io/spring-boot) e [Spring Data](http://projects.spring.io/spring-data) em conjunto.

## Tecnologias

- [Spring Boot](https://projects.spring.io/spring-boot) é uma ferramenta que simplifica a configuração e execução de aplicações Java stand-alone,  com conceitos de dependências “starters”, auto configuração e servlet container embutidos é proporcionado uma grande produtividade desde o start-up da aplicação até sua ida a produção.
 
- [Spring Data](http://projects.spring.io/spring-data/) é um framework que abstrai o acesso ao modelo de dados, independente a tecnologia de base de dados.
 
# Setup da aplicação (local)

## Pré-requisito

Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:
```
Java 17
PostgreSQL
H2-database
Maven 
```

## Preparando ambiente PostgreSQL

É necessário a criação da base de dados relacional no Postgres

```
CREATE DATABASE "taskmanager";
```

Adicione usuário e senha no arquivo application-dev.properties

```
spring.datasource.url=jdbc:postgresql://localhost:5432/taskmanager
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA_AQUI

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## Preparando ambiente H2-Database

É necessário que a propriedade spring.profiles.active esteja em "test"

```
spring.profiles.active=test
```

Ao executar a aplicação pela primeira vez o banco H2 será polvoado com informações iniciais

## Instalação da aplicação

Primeiramente, faça o clone do repositório:
```
https://github.com/r0nny-dev/TesteJava
```
Feito isso, acesse o projeto:
```
cd TesteJava/Parte 1 - API REST/taskmanager
```
É preciso compilar o código e baixar as dependências do projeto:
```
mvn clean package
```
Finalizado esse passo, vamos iniciar a aplicação:
```
mvn spring-boot:run
```
Pronto. A aplicação está disponível em http://localhost:8080
```
Tomcat started on port(s): 8080 (http)
```

# APIs

O projeto disponibiliza algumas APIs em 3 contextos diferentes: Pessoas, Tarefas e Departamentos, onde utilizam o padrão Rest de comunicação, produzindo e consumindo arquivos no formato JSON.

Segue abaixo as APIs disponíveis no projeto:

#### Pessoa

 - /pessoas (GET)
 - /pessoas/gastos (GET)
 - /pessoas/{id} (DELETE)
 - /pessoas (POST)
     - Espera um json body com os atributos listados na requisição, exemplo:
    ```
    {
      "name":"Pessoa Nome",
      "idDepartamento": 3
    }
    ```
 - /pessoas/{id} (PUT)
     - Espera um json body com os atributos listados na requisição, exemplo:
    ```
    {
      "name":"Pessoa Nome",
      "idDepartamento": 3
    }
    ```

#### Departamento

 - /departamentos (GET)
 
 #### Tarefa
 
  - /tarefas/pendentes (GET)
  - /tarefas/finalizar/{id} (PUT)
  - /tarefas/alocar/{id} (PUT)
     - Espera um json body com os atributos listados na requisição, exemplo:
    ```
    {
      "name":"Pessoa Nome",
      "idDepartamento": 3
    }
    ```
- /tarefas (POST)
     - Espera um json body com os atributos listados na requisição, exemplo:
    ```
    {
      "titulo":"titulo tarefa",
      "descricao": "descricao tarefa",
      "prazo": "2022-01-15",
      "duracao": 6,
      "finalizado": false,
	  "idPessoaAlocada": 1
	  "idDepartamento": 3 
    }