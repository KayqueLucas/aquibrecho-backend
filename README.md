# Aqui Brechó - API (Backend)

![Status](https://img.shields.io/badge/status-em_desenvolvimento-yellow)
![Java](https://img.shields.io/badge/Java-17%2B-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x.x-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-PostGIS-blue)

## 📖 Sobre o Projeto

Este é o repositório exclusivo do **Backend (API REST)** para o projeto **Aqui Brechó**. 

A plataforma foi idealizada para conectar clientes a brechós físicos, facilitando a "garimpagem" através de um sistema de busca baseado em **geolocalização** (proximidade do usuário) e filtros de **estilos de roupa** (ex: Vintage, Y2K, Retrô). O objetivo é dar visibilidade aos pequenos lojistas locais e fomentar o consumo consciente e a moda sustentável.

## ⚙️ O que já foi implementado (Status Atual)

A fundação estrutural, banco de dados e as primeiras rotas da API já estão operacionais:
* **Setup do Projeto:** Configuração inicial com Spring Boot e Maven.
* **Modelagem de Dados (JPA/Hibernate):** Criação das entidades `Brecho` e `Estilo` com relacionamento N:N.
* **Banco de Dados Espacial:** Integração com PostgreSQL e a extensão **PostGIS** para armazenamento de coordenadas geográficas (Latitude/Longitude) utilizando a classe `Point` do JTS Topology Suite.
* **Repositório Customizado:** Implementação de buscas nativas otimizadas usando `ST_DistanceSphere` para encontrar brechós dentro de um raio específico em quilômetros.
* **Segurança de Credenciais:** Configuração da biblioteca `spring-dotenv` para isolar dados sensíveis do banco de dados em um arquivo `.env`.
* **Segurança (Dev):** Desabilitação temporária da auto-configuração do Spring Security para viabilizar o desenvolvimento e teste ágil das rotas.
* **Padrão DTO:** Implementação de `Records` e DTOs (`BrechoRequestDTO`, `BrechoResponseDTO`, `BrechoSimplesResponseDTO`) para encapsular os dados de entrada e saída.
* **Endpoints RESTful (`/api/brechos`):**
  * `POST /`: Cadastro de novos brechós, com validação de dados (`@Valid`) e tratamento de relacionamentos nulos.
  * `GET /buscar-proximos`: Busca de brechós baseada em geolocalização (latitude, longitude e raio em km).
  * `GET /`: Listagem geral de todos os brechós retornando dados essenciais (nome, endereço e estilos).

## 🗺️ Próximos Passos (Roadmap)
- [ ] Integração com API externa de Geocoding (ex: ViaCEP / Google Maps) para buscar latitude e longitude automaticamente a partir do CEP cadastrado.
- [ ] Implementação de upload de imagens (Amazon S3).
- [ ] Refatoração da segurança (Autenticação JWT).
- [ ] Tratamento global de exceções (`@ControllerAdvice`).

## 🛠️ Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3** (Web, Data JPA, Validation)
* **PostgreSQL + PostGIS** (Banco de dados relacional com suporte espacial)
* **Hibernate Spatial** (Mapeamento objeto-relacional para dados geográficos)
* **Lombok** (Redução de boilerplate)
* **Spring Dotenv** (Gerenciamento de variáveis de ambiente)
* **Git & GitHub** (Versionamento de código)

## 🚀 Como Executar o Projeto Localmente

### Pré-requisitos
* JDK 17+
* Maven
* PostgreSQL (com a extensão PostGIS instalada)

### Passo a Passo

1. **Clone o repositório:**
    ```bash
    git clone [https://github.com/KayqueLucas/aquibrecho-backend.git](https://github.com/KayqueLucas/aquibrecho-backend.git)
    cd aquibrecho-backend
    ```

2. **Configure o Banco de Dados:**
    Crie um banco de dados no PostgreSQL e ative o PostGIS:
    ```sql
    CREATE DATABASE aquibrecho_db;
    \c aquibrecho_db
    CREATE EXTENSION postgis;
    ```

3. **Configure as Variáveis de Ambiente:**
    Crie um arquivo chamado `.env` na raiz do projeto (mesmo nível do `pom.xml`).
    Copie o conteúdo do arquivo `.env.example` para o seu novo `.env`.
    Preencha com as suas credenciais locais do PostgreSQL:
    ```env
    DB_URL=jdbc:postgresql://localhost:5432/aquibrecho_db
    DB_USER=seu_usuario_postgres
    DB_PASSWORD=sua_senha_postgres
    ```

4. **Execute a aplicação:**
    ```bash
    ./mvnw spring-boot:run
    ```
    A API estará rodando em `http://localhost:8081`.

## 👨‍💻 Autor

**Kayque Lucas Silva Neves**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/kayque-lucas-dev/)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/KayqueLucas)
