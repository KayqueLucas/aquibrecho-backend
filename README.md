# 🧥 Aqui Brechó - API (Backend)

![Status](https://img.shields.io/badge/status-em_desenvolvimento-yellow)
![Java](https://img.shields.io/badge/Java-17%2B-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x.x-brightgreen)

## 📖 Sobre o Projeto

Este é o repositório do backend (API) para o projeto **Aqui Brechó**.  
A plataforma foi desenhada para conectar clientes a brechós físicos, permitindo que usuários descubram novos locais com base na sua localização e em estilos de roupa específicos.

O objetivo principal é criar um catálogo centralizado que facilite a "garimpagem" para os clientes e aumente a visibilidade para os lojistas, fomentando a moda sustentável e o comércio local.

Este projeto está sendo construído como parte do meu portfólio de desenvolvimento, utilizando tecnologias robustas de mercado.

---

## ✨ Funcionalidades (MVP)

O escopo do MVP (Produto Mínimo Viável) inclui as seguintes funcionalidades:

### 👕 Para Lojistas:
- Cadastro de brechós (nome, endereço, horário de funcionamento, fotos).
- Associação do brechó a uma ou mais tags de estilo (ex: Vintage, Y2K, Retrô, Plus Size).

### 🧍 Para Clientes:
- Listagem de todos os brechós cadastrados em um mapa.
- Busca de brechós por proximidade (geolocalização).
- Filtragem de brechós por tags de estilo.
- Visualização dos detalhes de um brechó específico.

---

## 🛠️ Tecnologias Utilizadas

A stack principal deste backend é composta por:

- **Java 17+**
- **Spring Boot 3+**
  - **Spring Web:** Para a criação da API REST.
  - **Spring Data JPA:** Para persistência de dados de forma simplificada.
  - **Validation:** Para validar os dados de entrada.
- **PostgreSQL:** Banco de dados relacional.
- **PostGIS (Extensão do PostgreSQL):** Essencial para armazenar e consultar dados de geolocalização (latitude/longitude) de forma eficiente.
- **Hibernate Spatial:** Biblioteca para integrar o PostGIS com o Spring Data JPA.
- **Maven:** Gerenciador de dependências.
- **Lombok:** Para reduzir boilerplate code (getters, setters, etc).

---

## 🚀 Como Rodar o Projeto

### 🧩 Pré-requisitos

- JDK 17 ou superior  
- Maven 3.8+  
- PostgreSQL (recomendado versão 14+)  
- Algum cliente de banco de dados (ex: DBeaver, DataGrip, etc.)

---

### 1️⃣ Clonar o Repositório

```bash
git clone https://github.com/KayqueLucas/aquibrecho-api.git
cd aquibrecho-api
2️⃣ Configurar o Banco de Dados
Acesse seu cliente PostgreSQL (ex: DBeaver ou psql) e crie um novo banco:

sql
Copiar código
CREATE DATABASE aquibrecho_db;
Muito importante: conecte-se ao banco recém-criado e ative a extensão PostGIS:

sql
Copiar código
\c aquibrecho_db
CREATE EXTENSION postgis;
⚠️ Sem essa extensão, as funcionalidades de mapa não irão funcionar.

3️⃣ Configurar a Aplicação
Navegue até o diretório src/main/resources
Renomeie o arquivo application.properties.example (ou crie um novo) para application.properties.

Preencha com as suas credenciais do banco de dados:

properties
Copiar código
# Configuração do Banco de Dados PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/aquibrecho_db
spring.datasource.username=seu_usuario_postgres
spring.datasource.password=sua_senha_postgres

# Configuração do Hibernate e JPA
spring.jpa.hibernate.ddl-auto=update # 'update' para desenvolvimento, 'validate' para produção
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# DIALETO ESPACIAL (Necessário para o PostGIS)
spring.jpa.properties.hibernate.dialect.spatial=org.hibernate.spatial.dialect.postgis.PostgisDialect
4️⃣ Executar a Aplicação
Abra um terminal na raiz do projeto e execute o comando Maven:

bash
Copiar código
./mvnw spring-boot:run
A API estará disponível em:
👉 http://localhost:8080

🗺️ Endpoints da API (MVP)
Método	Endpoint	Descrição
POST	/brechos	Cadastra um novo brechó
GET	/brechos	Lista todos os brechós
GET	/brechos?estilo=vintage	Filtra brechós por estilo
GET	/brechos?lat=-22.90&lon=-43.17&raio=5	Filtra brechós por proximidade (raio em km)
GET	/brechos/{id}	Obtém os detalhes de um brechó específico
GET	/estilos	Lista todas as tags de estilo disponíveis

👨‍💻 Autor
Feito por Kayque Lucas

🔗 LinkedIn: https://www.linkedin.com/in/kayque-lucas-dev/
💻 GitHub: https://github.com/KayqueLucas

yaml
Copiar código

---
