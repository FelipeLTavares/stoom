# API de Gerenciamento de Produtos

Esta API permite o gerenciamento de produtos, categorias e marcas, sendo possível filtrar os produtos de diversas formas.
Esse projeto surgiu de um teste técnico que tem como requisitos básicos:

1. Deve ser desenvolvida uma API de CRUD de produtos
2. Os produtos devem ser enriquecidos com as informações que você julgar relevante para o funcionamento em uma loja, algumas são obrigatórias:
    - Categorias
    - Marca
    - Preços
3. Deve existir um endpoint na API para a busca de produtos que será utilizada na loja
4. Deve existir um endpoint que lista os produtos de uma determinada Marca
5. Deve existir um endpoint que lista os produtos de uma determinada Categoria
6. Produtos podem ser inativados para não aparecerem na busca ou nas listagens sem a necessidade de serem deletados para poderem ser reativados posteriormente
7. Marcas e categorias também podem ser inativados para não aparecerem na loja

Além desses requisitos, adicionei rotas de criação e listagem de novas marcas e categorias. Para fins de exemplo, são criados inicialmente duas marcas e duas categorias de exemplo, com ids 1 e 2 (para ambas entidades).

## Tecnologias Utilizadas

- Java 21
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
