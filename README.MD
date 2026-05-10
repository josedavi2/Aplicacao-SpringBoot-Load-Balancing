🍽️ Sistema de Restaurante Distribuído

Este projeto implementa uma API de gerenciamento de pedidos utilizando uma arquitetura de Alta Disponibilidade e Escalabilidade Horizontal. O objetivo principal é demonstrar o uso de um Load Balancer para distribuir carga entre múltiplas instâncias de um serviço Spring Boot.
🏗️ Arquitetura do Sistema

A solução foi desenhada para suportar alta demanda, utilizando os seguintes componentes:

    Nginx: Atua como Load Balancer (Proxy Reverso), distribuindo as requisições entre as réplicas do servidor.

    Spring Boot (Java 21): API REST escalonada em 3 instâncias independentes.

    Redis: Camada de cache para otimizar a performance de consultas frequentes.

    MySQL: Banco de dados relacional para persistência de pedidos e cardápio.

🚀 Como Executar

Toda a infraestrutura é orquestrada via Docker, facilitando a reprodutibilidade do ambiente:
Bash

# Clone o repositório
git clone https://github.com/josedavi2/distributed-restaurant-system.git

# Entre na pasta
cd distributed-restaurant-system

# Suba o ambiente com 3 instâncias da API
docker-compose up -d --build --scale sistema-restaurante=3

O sistema estará disponível em: http://localhost:80
📊 Resultados de Performance (JMeter)

Para validar a arquitetura, realizamos testes de carga simulando múltiplos usuários simultâneos.
Cenário de Teste:

    Endpoint: /api/restaurants/fast e /api/restaurants/slow

    Ferramenta: Apache JMeter

    Métrica Alvo: Tempo de resposta e vazão (throughput).

Análise de Carga:


🛠️ Tecnologias Utilizadas

    Linguagem: Java 21

    Framework: Spring Boot 3.x

    Infra: Docker & Docker Compose

    Load Balancer: Nginx

    Cache: Redis

    Banco de Dados: MySQL
