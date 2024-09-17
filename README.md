## ✨ Tecnologias

Esse projeto foi desenvolvido com as seguintes tecnologias:

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Web](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [H2](http://www.h2database.com/html/main.html)

## 💻 Projeto

Sistema simples que simula transações financeiras entre empresas e clientes.

### Objetivo Principal:

Desenvolver um sistema que simula transações financeiras entre empresas e clientes, com foco em:

- - Gerenciamento de usuários: Cadastro e controle de acesso para dois tipos de usuários: Empresas e Clientes.
- - Validação de dados:  CPF (Cliente) e CNPJ (Empresa) devem ser validados.
- - Transações financeiras: Depósitos e saques realizados por clientes em contas de empresas, com incidência de taxas de administração.
- - Saldo das empresas: O sistema deve calcular e manter o saldo atualizado das empresas, considerando depósitos, saques e taxas.
- - Notificações:  Envio de notificações (callbacks) para as empresas e clientes sobre as transações realizadas.
- - Simulação de falhas: Utilização de um serviço externo (webhook.site) para simular falhas no envio de notificações, demonstrando a capacidade de lidar com cenários de erro.

[View on Eraser![](https://app.eraser.io/workspace/T1TTfv0HJhg3OmzbxtSU/preview?elements=HbxPYs8SXC_HvN1B6F6BIQ&type=embed)](https://app.eraser.io/workspace/T1TTfv0HJhg3OmzbxtSU?elements=HbxPYs8SXC_HvN1B6F6BIQ)
## 🚀 Como executar
A classe principal, SpringAPIdev, inicializa a aplicação Spring Boot e cria um bean RestTemplate para efetuar pedidos HTTP.\

A classe ClientController trata dos pedidos HTTP relacionados com os clientes, como a criação de um novo cliente, a recuperação de todos os clientes e a atualização ou eliminação de um cliente específico. Utiliza a classe ClientService para efetuar estas operações.\

A classe CompanyController trata os pedidos HTTP relacionados com empresas, como a criação de uma nova empresa, a recuperação de todas as empresas e a atualização ou eliminação de uma empresa específica. Utiliza a classe CompanyService para efetuar estas operações.\

As classes ClientService e CompanyService contêm a lógica comercial para efetuar operações em clientes e empresas, respetivamente. Utilizam as classes ClientRepository e CompanyRepository, que são repositórios JPA do Spring Data, para interagir com a base de dados, e utilizam as classes ClientRepository e CompanyRepository, que são repositórios JPA do Spring Data, para interagir com a base de dados.\

As classes Client e Company são as entidades JPA que mapeiam para as tabelas da base de dados.\

As classes DepositRequest e WithdrawRequest são objectos simples de transferência de dados utilizados para efetuar pedidos HTTP para depositar ou levantar fundos.\\

RESTful API usando Spring Boot e JPA.\
usando Insomnia
---
GET http://localhost:8080/api/clients
---
GET http://localhost:8080/api/companys
---
POST http://localhost:8080/api/companys\
{
    "cnpj": 98345678000199,
		"name": "empresa 1",
    "amount": 100.0,
    "interest": 0.02
}
---
POST http://localhost:8080/api/clients\
{
  "cpf": 12345678912,
  "name": "TESTE CLIENTE 1",
  "amount": 15000.0,
  "company": {
		"id": 1
	}
}
---
POST http://localhost:8080/api/clients/deposit/\
{
    "clientId": 1,
    "companyId": 1,
    "amount": 9000.0
}
---
POST http://localhost:8080/api/clients/withdraw/\
{
    "clientId": 1,
    "companyId": 1,
    "amount": 9000.0
}
---