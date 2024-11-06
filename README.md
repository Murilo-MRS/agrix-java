# 🌿 Projeto Agrix :seedling:

## 📃 Descrição
Este projeto é uma aplicação Spring Boot para gerenciar plantações e fertilizantes. Ele fornece uma API RESTful para criar e gerenciar esses recursos.

## 🔎 Rotas
### PersonController
- **POST `/persons`**: Cria uma nova pessoa.
    - **Request Body**:
    ```json
    {
      "name": "John Doe",
      "username": "johndoe",
      "password": "123456"
    }
    ```
    - **Response**:
    ```json
    {
      "id": 1,
      "name": "John Doe",
      "username": "johndoe"
    }
    ```

### AutheticationController
- **POST `/auth/login`**: Autentica um usuário e retorna um token JWT.
    - **Request Body**:
    ```json
    {
      "username": "exampleUser",
      "password": "examplePass"
    }
    ```
    - **Response**:
    ```json
       {
         "token": "eyJhbGdciOiJIUzI1NiJ9.eyJzdWIiOiJleGFtcGxlVXNlciIsImV4cCI6MTYzNzYwNzQwM30.72ZjZj"
       }
    ```
  
### CropController
- **GET `/crops/{id}`**: Retorna uma plantação pelo ID.
- **Response**:
  ```json
  {
    "id": 1,
    "name": "Corn",
    "plantedArea": 100.5,
    "farmId": 1,
    "plantedDate": "2023-01-01",
    "harvestDate": "2023-06-01"
  }
  ```
- **GET `/crops`**: Retorna todas as plantações.
    - **Response**:
    ```json
    [
      {
        "id": 1,
        "name": "Corn",
        "plantedArea": 100.5,
        "farmId": 1,
        "plantedDate": "2023-01-01",
        "harvestDate": "2023-06-01"
      },
      {
        "id": 2,
        "name": "Soy",
        "plantedArea": 200.5,
        "farmId": 2,
        "plantedDate": "2023-01-01",
        "harvestDate": "2023-06-01"
      },
      {
        "id": 3,
        "name": "Wheat",
        "plantedArea": 200.0,
        "farmId": 2,
        "plantedDate": "2023-02-01",
        "harvestDate": "2023-07-01"
      }
    ]
    ```
- **GET `/crops/search`**: Retorna plantações por data de colheita.
    - **Request Params**: `start`, `end`
    - **Response**:
    ```json
    [
      {
        "id": 2,
        "name": "Soy",
        "plantedArea": 200.5,
        "farmId": 2,
        "plantedDate": "2023-01-01",
        "harvestDate": "2023-06-01"
      },
      {
        "id": 3,
        "name": "Wheat",
        "plantedArea": 200.0,
        "farmId": 2,
        "plantedDate": "2023-02-01",
        "harvestDate": "2023-07-01"
      }
    ]
    ```

- **GET `/crops/{id}/fertilizers`**: Retorna fertilizantes associados a uma plantação pelo ID.
    - **Response**:
    ```json
    [
      {
         "id": 1,
         "name": "Nitrogen",
         "brand": "AgriBest",
         "composition": "NPK 20-20-20"
      },
      {
        "id": 2,
        "name": "Phosphorus",
        "brand": "AgriBest",
        "composition": "NPK 20-20-20"
      },
      {
        "id": 3,
        "name": "Potassium",
        "brand": "AgriBest",
        "composition": "NPK 20-20-20"
      }
    ]
    ```
- **POST `/crops/{id}/fertilizers/{fertilizerId}`**: Adiciona um fertilizante a uma plantação.
    - **Response**: "Fertilizante e plantação associados com sucesso!"

### FarmController
- **GET `/farms`**: Retorna todas as fazendas.
    - **Response**:
    ```json
    [
      {
        "id": 1,
        "name": "Green Farm",
        "size": 500.0
      },
      {
        "id": 2,
        "name": "Blue Farm",
        "size": 1000.0
      }
    ]
    ```

- **GET `/farms/{id}`**: Retorna uma fazenda pelo ID.
    - **Response**:
    ```json
    {
      "id": 1,
      "name": "Green Farm",
      "size": 500.0
    }
    ```
- **GET `/farms/{farmId}/crops`**: Retorna plantações de uma fazenda pelo ID da fazenda.
    - **Response**:
    ```json
    [
      {
        "id": 1,
        "name": "Corn",
        "plantedArea": 100.5,
        "farmId": 1,
        "plantedDate": "2023-01-01",
        "harvestDate": "2023-06-01"
      }
    ]
    ```
- **POST `/farms`**: Cria uma nova fazenda.
    - **Request Body**:
    ```json
    {
      "name": "Green Farm",
      "size": 500.0
    }
    ```    
    - **Response**:
    ```json
    {
      "id": 1,
      "name": "Green Farm",
      "size": 500.0
    }
    ```

- **POST `/farms/{farmId}/crops`**: Adiciona uma plantação a uma fazenda.
    - **Request Body**:
    ```json
    {
      "name": "Corn",
      "plantedArea": 100.5,
      "plantedDate": "2023-01-01",
      "harvestDate": "2023-06-01"
    }
    ```
    - **Response**: `CropDto`
    ```json
    {
      "id": 1,
      "name": "Corn",
      "plantedArea": 100.5,
      "farmId": 1,
      "plantedDate": "2023-01-01",
      "harvestDate": "2023-06-01"
    }
    ```

### FertilizerController
- **GET `/fertilizers`**: Retorna todos os fertilizantes.
    - **Response**:
    ```json
    [
      {
        "id": 1,
        "name": "Nitrogen",
        "brand": "AgriBest",
        "composition": "NPK 20-20-20"
      },
      {
        "id": 2,
        "name": "Phosphorus",
        "brand": "AgriBest",
        "composition": "NPK 20-20-20"
      },
      {
        "id": 3,
        "name": "Potassium",
        "brand": "AgriBest",
        "composition": "NPK 20-20-20"
      }
    ]
    ```
- **GET `/fertilizers/{id}`**: Retorna um fertilizante pelo ID.
    - **Response**:
    ```json
    {
      "id": 1,
      "name": "Nitrogen",
      "brand": "AgriBest",
      "composition": "NPK 20-20-20"
    }
    ```
- **POST `/fertilizers`**: Cria um novo fertilizante.
    - **Request Body**:
    ```json
    {
      "name": "Nitrogen",
      "brand": "AgriBest",
      "composition": "NPK 20-20-20"
    }
    ```
    - **Response**:
    ```json
    {
      "id": 1,
      "name": "Nitrogen",
      "brand": "AgriBest",
      "composition": "NPK 20-20-20"
    }
    ```

## ⚙️ Como rodar o projeto

### 🔧 Pré-requisitos
- **Java**: Versão 17
- **Maven**: Versão 3.8.1 ou superior
- **Docker**: Versão 20.10.0 ou superior
- **Docker Compose**: Versão 1.27.0 ou superior

### Usando Maven
1. Clone o repositório:
   ```sh
   git clone <URL_DO_REPOSITORIO>
    ```
2. Navegue até o diretório do projeto:
   ```sh
    cd <DIRETORIO_DO_PROJETO>
    ```
3. Compile e rode o projeto usando Maven:
    ```sh
    mvn spring-boot:run
    ```
### Usando Docker
1. Clone o repositório:
    ```sh
    git clone <URL_DO_REPOSITORIO>
    ```
2. Navegue até o diretório do projeto:
    ```sh
    cd <DIRETORIO_DO_PROJETO>
    ```
3. Construa a imagem Docker:
    ```sh
    docker build -t agrix-ebytr-staff .
    ```
4. Rode o contêiner Docker:
    ```sh
    docker run -p 8080:8080 agrix-ebytr-staff
    ```
### Usando Docker Compose

1. Clone o repositório:
    ```sh
    git clone <URL_DO_REPOSITORIO>
    ```
2. Navegue até o diretório do projeto:
    ```sh
    cd <DIRETORIO_DO_PROJETO>
    ```
3. Rode o Docker Compose:
    ```sh
    docker-compose up -d
    ```

## 📦 Dependências utilizadas
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- MySQL Connector/J
- Spring Boot DevTools
- Spring Boot Starter Actuator
- Java JWT
- Spring Boot Starter Security
- Spring Security Test
- Spring Boot Starter
- Spring Boot Starter Test
- H2 Database
- JUnit Jupiter

## 👤 Autor

- [@Murilo-MRS](https://github.com/Murilo-MRS)