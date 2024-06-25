# API de Gerenciamento de Produtos

Esta API permite o gerenciamento de produtos, categorias e marcas, sendo possível filtrar os produtos de diversas formas.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.3.1
- Maven
- H2 Database

## Requisitos

- JDK 17

# Documentação da API

A documentação da API é gerada automaticamente com o Swagger. Após iniciar a aplicação, acesse a interface Swagger em http://localhost:8080/swagger-ui/index.html.

# Funcionalidades

## Marcas
- `Cadastrar marcas`
- `Listar marcas`

## Categorias
- `Cadastrar categorias`
- `Listar categorias`

## Produtos
- `Cadastrar produtos`
- `Listar produtos ativos` - E outros filtros
- `Listar todos os produtos (ativos e inativos)` - E outros filtros
- `Listar produtos de uma determinada marca` - E outros filtros
- `Listar produtos de uma determinada categoria` - E outros filtros
- `Ativar produto`
- `Desativar produto`

# Licença

Este projeto está licenciado sob a [MIT License](./LICENSE).
