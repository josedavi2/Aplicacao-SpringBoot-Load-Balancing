# Sistema de Restaurante com Load Balancing

Este projeto demonstra uma arquitetura de alta disponibilidade usando Spring Boot, Nginx, Redis e MySQL.

## Como Rodar
Certifique-se de ter o Docker instalado e execute
```bash
docker-compose up -d --build --scale sistema-restaurante=3