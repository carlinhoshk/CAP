#!/bin/bash

# Para todos os containers e remove
docker-compose down -v

# Remove containers antigos se existirem
docker rm -f escola_db 2>/dev/null || true

# Remove volumes antigos
docker volume rm cap_mysql_data 2>/dev/null || true

# Remove networks antigas
docker network rm escola-network 2>/dev/null || true

# Inicia o container novamente
docker-compose up -d

# Aguarda o MySQL estar pronto
echo "Aguardando MySQL iniciar..."
while ! docker exec escola_db mysqladmin ping -h"localhost" -P"3306" -u"user" -p"password" --silent; do
    sleep 1
done

echo "MySQL está pronto!"

# Execute a aplicação Spring Boot
mvn spring-boot:run 