# 📦 Desenvolvimento de APIs com Java Spring Boot

Este projeto tem como objetivo aplicar os conhecimentos de desenvolvimento de APIs RESTful utilizando **Java com Spring Boot**, com foco em integração com banco de dados, boas práticas de modelagem e construção de serviços robustos.

## 📚 Descrição do Projeto

O sistema simula uma aplicação de gestão com três entidades principais:

- **Usuários**
- **Clientes**
- **Livro Caixa**

Além disso, há um serviço contábil que consolida os lançamentos financeiros por cliente, com cálculo de saldo baseado em créditos e débitos.

### Funcionalidades Implementadas

#### 🔐 Usuários
- Criar, editar, excluir e buscar usuários
- Filtro por nome e e-mail
- Serviço de login com verificação de senha e status

#### 👥 Clientes
- CRUD completo
- Filtros por nome, CPF/CNPJ, cidade e UF

#### 📒 Livro Caixa
- CRUD completo
- Filtro por ID do cliente

#### 📊 Serviço Contábil
- Lista de lançamentos por cliente
- Filtros por ID do cliente e intervalo de datas
- Cálculo de saldo acumulado com base no tipo de lançamento (Crédito/Débito)

## 📁 Estrutura do Banco de Dados

O projeto define a estrutura de tabelas para:
- `USUARIO`
- `CLIENTES`
- `LIVRO_CAIXA`

Cada tabela possui campos obrigatórios, tipos de dados e restrições como chaves primárias, estrangeiras e únicas.

## 📄 Documentação

Para mais detalhes sobre os requisitos, estrutura de dados e exemplos de retorno dos serviços, consulte o arquivo PDF disponível:

[📥 Download do Documento](assets/DesenvolvimentoAPIsJava.pdf)
