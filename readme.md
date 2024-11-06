# Odontogenda API

API para o gerenciamento de clientes, consultas e dentistas em uma clínica odontológica.

## Introdução

A Odontogenda API é um sistema de gerenciamento para uma clínica odontológica, permitindo criar, atualizar, listar e remover informações sobre clientes, consultas e dentistas.

## Instalação

1. Clone o repositório.
2. Configure o ambiente de desenvolvimento.
3. Execute o servidor na porta 8080.

## Endereços-base da API

- **Local**: `http://localhost:8080`

## Endpoints

### Clientes

- **Criar Cliente**
    - **URL**: `/clientes`
    - **Método**: `POST`
    - **Body**:
      ```json
      {
        "nomeCompleto": "string",
        "dataNascimento": "YYYY-MM-DD",
        "numeroTelefone": "string",
        "email": "string@example.com",
        "endereco": {
          "numero": "string",
          "logradouro": "string",
          "cidade": "string",
          "bairro": "string",
          "pais": "string"
        },
        "usuario": "string",
        "senha": "stringpassword"
      }
      ```
    - **Resposta**: `201 Created`

- **Listar Clientes**
    - **URL**: `/clientes`
    - **Método**: `GET`
    - **Resposta**:
      ```json
      [
        {
          "id": "string",
          "nomeCompleto": "string",
          "dataNascimento": "YYYY-MM-DD",
          "numeroTelefone": "string",
          "email": "string@example.com",
          "endereco": { ... },
          "usuario": "string"
        }
      ]
      ```

- **Consultar Cliente pelo ID**
    - **URL**: `/clientes/{id}`
    - **Método**: `GET`
    - **Parâmetros**: `id` (string, obrigatório)
    - **Resposta**: `200 OK` ou `404 Not Found`

- **Atualizar Cliente**
    - **URL**: `/clientes/{id}`
    - **Método**: `PUT`
    - **Parâmetros**: `id` (string, obrigatório)
    - **Body**:
      ```json
      {
        "nomeCompleto": "string",
        "dataNascimento": "YYYY-MM-DD",
        "numeroTelefone": "string",
        "email": "string@example.com",
        "endereco": { ... },
        "usuario": "string",
        "senha": "stringpassword"
      }
      ```
    - **Resposta**: `202 Accepted`

- **Deletar Cliente**
    - **URL**: `/clientes/{id}`
    - **Método**: `DELETE`
    - **Parâmetros**: `id` (string, obrigatório)
    - **Resposta**: `204 No Content`

### Consultas

- **Marcar Consulta**
    - **URL**: `/consultas`
    - **Método**: `POST`
    - **Body**:
      ```json
      {
        "data": "YYYY-MM-DD",
        "hora": "HH:MM",
        "clienteId": "string",
        "dentistaId": "string"
      }
      ```
    - **Resposta**: `201 Created`

- **Desmarcar Consulta**
    - **URL**: `/consultas/{id}`
    - **Método**: `DELETE`
    - **Parâmetros**: `id` (string, obrigatório)
    - **Resposta**: `204 No Content`

### Dentistas

- **Criar Dentista**
    - **URL**: `/dentistas`
    - **Método**: `POST`
    - **Body**:
      ```json
      {
        "nomeCompleto": "string",
        "dataNascimento": "YYYY-MM-DD",
        "numeroTelefone": "string",
        "email": "string@example.com",
        "endereco": { ... },
        "consultas": []
      }
      ```
    - **Resposta**: `201 Created`

- **Listar Dentistas**
    - **URL**: `/dentistas`
    - **Método**: `GET`
    - **Resposta**:
      ```json
      [
        {
          "id": "string",
          "nomeCompleto": "string",
          "dataNascimento": "YYYY-MM-DD",
          "numeroTelefone": "string",
          "email": "string@example.com",
          "endereco": { ... },
          "consultas": []
        }
      ]
      ```

- **Consultar Dentista pelo ID**
    - **URL**: `/dentistas/{id}`
    - **Método**: `GET`
    - **Parâmetros**: `id` (string, obrigatório)
    - **Resposta**: `200 OK` ou `404 Not Found`

- **Atualizar Dentista**
    - **URL**: `/dentistas/{id}`
    - **Método**: `PUT`
    - **Parâmetros**: `id` (string, obrigatório)
    - **Body**:
      ```json
      {
        "nomeCompleto": "string",
        "dataNascimento": "YYYY-MM-DD",
        "numeroTelefone": "string",
        "email": "string@example.com",
        "endereco": { ... },
        "consultas": []
      }
      ```
    - **Resposta**: `202 Accepted`

- **Deletar Dentista**
    - **URL**: `/dentistas/{id}`
    - **Método**: `DELETE`
    - **Parâmetros**: `id` (string, obrigatório)
    - **Resposta**: `204 No Content`




