# Very Basic Hotel Management System API based on Spring Boot

## Objective

This project provides very basic learning experience to Spirng Boot framework

## Runs on

- Windows or Linux machine with Docker installed
- Java 1.8
- Spring Boot framework 1.5 (will be deprecated soon)
- MySQL 8.0.12

## Deployment Strategies

Supports,

1. Normal Maven build and run
2. Containerized build and run (Docker)

## Instructions for containerized build and run

### Steps 

1. Pull HMS application image from DockerHub - [Click here to see this image in DockerHub](https://hub.docker.com/repository/registry-1.docker.io/gokulan90/spring-boot-hms/tags?page=1)
2. Pull MySQL 8.0.12 image from DockerHub - [Click here to see this image in DockerHub](https://hub.docker.com/layers/mysql/library/mysql/8.0.12/images/sha256-ee1e8adfcefbc1dadf8bc01350b6b6ba9c6925d45e02371edf56e13b780f0e5a?context=explore)
3. Create a common network of bridge type
4. Run MySQL database as a container and expose to external port 3306 with MYSQL_PASSWORD as root
5. Verify MySQL database container
6. Login to MySQL container bash using 'docker exec ..' command
7. Login to MySQL CLI and execute the SQL queries mentioned in [Initial Queries.txt](https://github.com/gokulanviswanathan/Spring-Boot-Hotel-Management-System/blob/master/Initial_DB_Queries.txt)
8. Run HMS application as a container
9. Verify HMS application container

### Userful Docker commands

Below the handy commands to bring this application up in Linux distribution environment using Docker

> docker pull gokulan90/spring-boot-hms:initial

> docker pull mysql:8.0.12

> docker network create --driver bridge --name hms-network

> docker container run --detach --name mysqldb -p3306:3306 --network hms-network -e MYSQL_PASSWORD=root mysql:8.0.12

> docker ps -a 

> docker container run --name hms -p8080:8080 --network hms-network gokulan90/spring-boot-hms

> docker exec -it <docker_container_id> bin/bash

> docker exec -it <docker_container_id> sh

> apt-get update

> apt-get install -y inetutils-ping

> ping mysqldb

> ping hms

## PRO TIP

In [application.proerties](https://github.com/gokulanviswanathan/Spring-Boot-Hotel-Management-System/blob/master/src/main/resources/application.properties), please maintain Datasource URL as such for running this application in containerized environment
