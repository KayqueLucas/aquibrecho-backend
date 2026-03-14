# Aqui Brechó - API (Backend)

![Status](https://img.shields.io/badge/status-em_desenvolvimento-yellow)
![Java](https://img.shields.io/badge/Java-17%2B-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x.x-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-PostGIS-blue)

## 📖 Sobre o Projeto

Este é o repositório exclusivo do **Backend (API REST)** para o projeto **Aqui Brechó**. 

A plataforma foi idealizada para conectar clientes a brechós físicos, facilitando a "garimpagem" através de um sistema de busca baseado em **geolocalização** (proximidade do usuário) e filtros de **estilos de roupa** (ex: Vintage, Y2K, Retrô). O objetivo é dar visibilidade aos pequenos lojistas locais e fomentar o consumo consciente e a moda sustentável.

## ⚙️ O que já foi implementado (Status Atual)

Até o momento, a fundação estrutural e de segurança da API foi estabelecida:
* **Setup do Projeto:** Configuração inicial com Spring Boot e Maven.
* **Modelagem de Dados (JPA/Hibernate):** Criação das entidades `Brecho` e `Estilo` com relacionamento N:N.
* **Banco de Dados Espacial:** Integração com PostgreSQL e a extensão **PostGIS** para armazenamento de coordenadas geográficas (Latitude/Longitude) utilizando a classe `Point` do JTS Topology Suite.
* **Repositório Customizado:** Implementação de buscas nativas otimizadas usando `ST_DistanceSphere` para encontrar brechós dentro de um raio específico em quilômetros.
* **Segurança de Credenciais:** Configuração da biblioteca `spring-dotenv` para isolar dados sensíveis do banco de dados em um arquivo `.env` (ignorado pelo Git), mantendo o repositório seguro.

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
    git clone https://github.com/KayqueLucas/aquibrecho-backend.git
    cd aquibrecho-backend

2. **Configure o Banco de Dados:**
    Crie um banco de dados no PostgreSQL e ative o PostGIS:

    CREATE DATABASE aquibrecho_db;
    \c aquibrecho_db
    CREATE EXTENSION postgis;

3. **Configure as Variáveis de Ambiente:**
    Crie um arquivo chamado `.env` na raiz do projeto (mesmo nível do `pom.xml`).
    Copie o conteúdo do arquivo `.env.example` para o seu novo `.env`.
    Preencha com as suas credenciais locais do PostgreSQL:

    DB_URL=jdbc:postgresql://localhost:5432/aquibrecho_db
    DB_USER=seu_usuario_postgres
    DB_PASSWORD=sua_senha_postgres

4. **Execute a aplicação:**
    ./mvnw spring-boot:run

    A API estará rodando em `http://localhost:8080`.

## 👨‍💻 Autor

**Kayque Lucas**


[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/kayque-lucas-dev/)

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/KayqueLucas)
