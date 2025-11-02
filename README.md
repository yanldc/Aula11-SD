# API Universidade - Sistema de Gestão Acadêmica

API REST para gerenciamento de entidades acadêmicas (Alunos, Professores, Funcionários e Departamentos).

## 🚀 Como executar

```bash
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

## 📋 Entidades

### Aluno

- ID (UUID)
- Nome completo
- Data de nascimento
- CPF/Matrícula nacional
- Matrícula (código interno)
- Email institucional
- Telefone

### Professor

- ID (UUID)
- Nome completo
- CPF/Registro funcional
- Email institucional
- Telefone
- Titulação (Mestre, Doutor, Pós-Doc)
- Área de atuação
- Regime de trabalho (20h, 40h, DE)

### Funcionário

- ID (UUID)
- Nome completo
- CPF/Registro funcional
- Email institucional
- Telefone
- Cargo
- Tipo de vínculo (CLT, estatutário, terceirizado, bolsista)

### Departamento

- ID (UUID)
- Nome
- Sigla
- Centro/Unidade acadêmica
- Chefe do departamento (FK para Professor ou Funcionário)
- Email de contato
- Telefone/Ramal
- Localização

## 🛠️ Endpoints

### Alunos

- `GET /api/alunos` - Listar todos
- `GET /api/alunos/{id}` - Buscar por ID
- `POST /api/alunos` - Criar novo
- `PUT /api/alunos/{id}` - Atualizar
- `DELETE /api/alunos/{id}` - Deletar

### Professores

- `GET /api/professores` - Listar todos
- `GET /api/professores/{id}` - Buscar por ID
- `POST /api/professores` - Criar novo
- `PUT /api/professores/{id}` - Atualizar
- `DELETE /api/professores/{id}` - Deletar

### Funcionários

- `GET /api/funcionarios` - Listar todos
- `GET /api/funcionarios/{id}` - Buscar por ID
- `POST /api/funcionarios` - Criar novo
- `PUT /api/funcionarios/{id}` - Atualizar
- `DELETE /api/funcionarios/{id}` - Deletar

### Departamentos

- `GET /api/departamentos` - Listar todos
- `GET /api/departamentos/{id}` - Buscar por ID
- `POST /api/departamentos` - Criar novo
- `PUT /api/departamentos/{id}` - Atualizar
- `DELETE /api/departamentos/{id}` - Deletar

## 📝 Exemplo de uso (POST)

### Criar Aluno

```json
{
  "nomeCompleto": "João Silva",
  "dataNascimento": "2000-05-15",
  "cpfMatriculaNacional": "123.456.789-00",
  "matricula": "2024001",
  "emailInstitucional": "joao.silva@universidade.edu.br",
  "telefone": "(11) 99999-9999"
}
```

### Criar Professor

```json
{
  "nomeCompleto": "Dr. Maria Santos",
  "cpfRegistroFuncional": "987.654.321-00",
  "emailInstitucional": "maria.santos@universidade.edu.br",
  "telefone": "(11) 88888-8888",
  "titulacao": "Doutor",
  "areaDeAtuacao": "Ciência da Computação",
  "regimeTrabalho": "DE"
}
```

## 🔧 Tecnologias

- Java 11
- Spring Boot 2.7.18
- Spring Data JPA
- H2 Database (em memória)
- Maven
- Lombok

## 💾 Banco de Dados

- **H2 Database** (em memória)
- **Console H2:** `http://localhost:8080/h2-console`
- **URL JDBC:** `jdbc:h2:mem:testdb`
- **Usuário:** `sa`
- **Senha:** (vazio)

Os dados são persistidos durante a execução da aplicação e são perdidos ao reiniciar.
