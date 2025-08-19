# 🧠 AtendoPro – Sistema de Gerenciamento de Atendimentos Terapêuticos

Projeto **monorepo** contendo **backend (Spring Boot)** e **frontend (Angular)** para gerenciamento de atendimentos terapêuticos.

---

## 📂 Estrutura do Projeto

atendopro/
│── atendopro-api/ # Backend - Java 17 + Spring Boot
│── atendopro-app/ # Frontend - Angular 17
│── docker-compose.yml # Subida de containers (ex: PostgreSQL)
│── .env # Variáveis de ambiente
│── .gitignore
│── README.md

yaml
Copiar
Editar

---

## 🚀 Tecnologias

### Backend (`atendopro-api`)
- Java 21
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- Docker
- JWT (autenticação)

### Frontend (`atendopro-app`)
- Angular 20+
- TypeScript
- TailwindCSS (opcional)
- JWT (autenticação via API)

---

## ⚙️ Como Rodar Localmente

### 1️⃣ Clonar o repositório
```sh
git clone https://github.com/seu-usuario/atendopro.git
cd atendopro
