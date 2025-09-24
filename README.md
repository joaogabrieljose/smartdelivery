# 🚀 SmartDelivery

**SmartDelivery** é um sistema de gerenciamento de entregas desenvolvido em **Java** com **Spring Framework**, projetado para otimizar o fluxo de pedidos, clientes e entregadores, além de integrar serviços externos e mensageria.

## 🛠️ Tecnologias & Ferramentas
- **Java** + **Spring Framework**
- **Spring Web | Spring Security | Spring Data JPA**
- **PostgreSQL** como banco de dados relacional
- **OpenFeign** para comunicação entre serviços
- **RabbitMQ (CloudAMQP)** para mensageria
- **Spring Boot Starter AMQP**
- **Docker** para conteinerização
- Integração com API **ViaCep**

## 🔑 Funcionalidades Principais
- 📦 Cadastro e gerenciamento de **clientes**, **produtos** e **entregadores**  
- 📝 Criação e acompanhamento de **pedidos**  
- 🚚 **Gerenciamento de entregas** em tempo real  
- 🔐 **Autenticação Basic** com Spring Security  
- 🔔 Notificações assíncronas via **RabbitMQ**  

## ⚡ Desafios Superados
- Implementação de notificações confiáveis utilizando **CloudAMQP**  
- Integração de serviços externos (ViaCep) para validação automática de endereços  
- Arquitetura modular e escalável com **Docker**  

---
✨ Projeto desenvolvido para demonstrar boas práticas em **arquitetura backend**, **integração de serviços** e **comunicação assíncrona**.
