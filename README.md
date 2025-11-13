# 💻 API RESTful — E-commerce BRASILEIRAS

Este repositório contém o motor do novo sistema de vendas online da empresa **BRASILEIRAS**.  
A API é responsável por gerenciar produtos, clientes, fornecedores e operações financeiras.

---

## 👤 Autora

**Andreza da Silva Dantas**  
Estudante de Análise e Desenvolvimento de Sistemas | Foco em QA & Backend  
Tecnologias: Java | Spring Boot | Maven | H2 | Postman  

---

# 🛠️ Tecnologias Utilizadas

| Tecnologia      | Função                                   |
|-----------------|-------------------------------------------|
| **Java**        | Linguagem principal                       |
| **Spring Boot** | Estruturação da API                       |
| **Maven**       | Gerenciador de dependências               |
| **H2 Database** | Banco de dados em memória                 |

---

# 🗂️ Arquitetura da Aplicação

| Pacote        | Responsabilidade                     |
|---------------|---------------------------------------|
| `model`       | Modelos de dados                      |
| `repository`  | Acesso ao banco de dados              |
| `controller`  | Endpoints REST                        |

---

# 🧵 Histórico de Comandos Essenciais

| Etapa            | Comando                | Função                              |
|------------------|------------------------|--------------------------------------|
| Montar programa  | `mvn clean install`    | Baixa dependências e compila         |
| Iniciar API      | `mvn spring-boot:run`  | Inicia o servidor (porta 8080)       |
| Enviar ao GitHub | `git push -u origin main` | Envia o projeto ao repositório     |

---

# 📌 Testando a API com Postman

### Configuração para requisições **POST**
- Body → **raw**  
- Formato → **JSON**

---

# 🧩 Testes por Módulo (Detalhado)

---

## 📦 1. Fornecedores — `FornecedorController`

Este módulo gerencia quem fornece os produtos para a BRASILEIRAS.

| Ação      | Método | URL                                   | Body (JSON)                                                                 | Resultado Esperado |
|-----------|--------|---------------------------------------|------------------------------------------------------------------------------|--------------------|
| Cadastrar | POST   | `http://localhost:8080/api/fornecedores` | `{"razaoSocial":"Tech Suprimentos Ltda","cnpj":"11.111.111/0001-01","telefone":"9999-0000"}` | Retorna o objeto cadastrado com campo `id` preenchido |
| Consultar | GET    | `http://localhost:8080/api/fornecedores` | N/A                                                                          | Retorna lista de fornecedores (200 OK) |

---

## 🛒 2. Produtos — `ProdutoController`

Gerencia catálogo, preços e estoque.

| Ação            | Método | URL                             | Body (JSON)                                                                                                                                  | Resultado Esperado |
|-----------------|--------|---------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------|--------------------|
| Cadastrar/Estoque | POST | `http://localhost:8080/api/produtos` | `{"codigoProduto":"ELEC001","descricao":"Smart TV 50 polegadas","valorCompra":2500.00,"valorVenda":3500.00,"estoque":50}`                      | Produto registrado; retorna objeto com `id` (RF17) |
| Consultar Catálogo | GET | `http://localhost:8080/api/produtos` | N/A                                                                                                                                           | Retorna lista de produtos (simula visualização do catálogo — RF01) |

---

## 👤 3. Clientes — `ClienteController`

Gerencia cadastro e consulta de clientes (RF05).

| Ação           | Método | URL                            | Body (JSON)                                                                                                      | Resultado Esperado |
|----------------|--------|--------------------------------|-------------------------------------------------------------------------------------------------------------------|--------------------|
| Cadastrar Usuário | POST | `http://localhost:8080/api/clientes` | `{"nome":"Maria Teste","cpf":"123.456.789-00","email":"maria@email.com","telefone":"98888-7777"}` | Cria novo cliente; retorna objeto com `id` (RF05) |
| Consultar Usuários | GET | `http://localhost:8080/api/clientes` | N/A                                                                                                               | Retorna lista de clientes |

---

## 💰 4. Financeiro — `FinanceiroController`

Simula lançamentos de contas a pagar e regras financeiras (RF15).

| Ação       | Método | URL                                               | Body (JSON)                                                                                          | Resultado Esperado (Regra RF15) |
|------------|--------|---------------------------------------------------|-------------------------------------------------------------------------------------------------------|----------------------------------|
| Simular CP | POST   | `http://localhost:8080/api/financeiro/contas-a-pagar` | `{"valor":50000.00,"dataEmissao":"2025-11-13","descricao":"NF-45678"}`                                | Retorna o lançamento com `dataVencimento` = `dataEmissao + 30 dias` → **2025-12-13** |

---

# 📎 Observações e Dicas

- Certifique-se de que a porta **8080** esteja livre antes de executar a aplicação.  
- Ao usar o H2 em memória, os dados são temporários — reiniciar a aplicação limpa o banco.  
- Para testes automatizados, considere criar um profile de testes com banco H2 persistente ou usar testcontainers.


