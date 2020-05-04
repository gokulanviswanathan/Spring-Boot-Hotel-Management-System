# Very Basic Hotel Management System API based on Spring Boot (Docker enabled)

## Objective

This project provides very basic learning experience to Spring Boot framework

## Runs on

- Windows or Linux machine with Docker installed
- Java 1.8
- Spring Boot framework 1.5 (will be deprecated soon)
- MySQL 8.0.12

## Deployment Strategies

Supports,

1. Normal Maven build and run
2. Containerized build and run (via Dockerfile)
3. Containerized build and run (via docker-compose.yml)

## Instructions for containerized build and run

### Build and deploy through Dockerfile 

1. Navigate to terminal or command prompt
2. Pull two Docker images using Docker pull command (commands mentioned below in collapsible section)
3. Create a common network of bridge type
4. Run MySQL database as a container and expose to external port 3306 with MYSQL_PASSWORD as root
5. Verify MySQL database container
6. Run HMS application as a container
7. Verify HMS application container
8. In web browser, enter the following address to get a sample JSON response http://machinename:8080/hotel/getHotels

<details>
  <summary>Docker Commands</summary>

Below the handy commands to bring this application up in Linux distribution environment using Docker

```
// Docker login
docker login
```

```
// Pull HMS application image from DockerHub
docker pull gokulan90/spring-boot-hms:initial
```

```
// Pull MySQL 8.0.12 image from DockerHub
docker pull gokulan90/hms-mysql:initial
```

```
// Create an isolated bridge network
docker network create --driver bridge hms-network
```

```
// Run MySQL container 
docker container run --detach --name mysqldb -p3306:3306 --network hms-network -e MYSQL_ROOT_PASSWORD=root gokulan90/hms-mysql:initial
```

```
// List all the containers 
docker ps -a 
```

```
// Run HMS application container
docker container run --detach --name hms -p8080:8080 --network hms-network gokulan90/spring-boot-hms:initial
```

```
// Access contianer BASH 
docker exec -it <docker_container_id or container_name> bin/bash
```

```
// Access MySQL CLI 
mysql -uroot -proot
```

```
// Access container SH
docker exec -it <docker_container_id or container_name> sh
```

```
// Update apt-get library
apt-get update
```

```
// Install ping utility
apt-get install -y inetutils-ping
```

```
// Ping MySQL database container from HMS container
ping mysqldb
```

```
// Ping HMS application container from MySQL container
ping hms
```
</details>

### Build and deploy through docker-compose.yml

1. Navigate to terminal or command prompt
2. For ther first time deployment, install docker-compose tool (commands mentioned below in collapsible section)
3. Copy and place [docker-compose.yml](https://github.com/gokulanviswanathan/Spring-Boot-Hotel-Management-System/blob/master/docker-compose.yml) in a directory
4. Run it by using command --> docker-compose up -d

<details>
  <summary>Installing docker-compose tool in Linux environment</summary>

1. Type the commands in terminal (mentioned below).
2. Verify the installation by following command --> docker-compose version

```
sudo curl -L "https://github.com/docker/compose/releases/download/1.25.5/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
```
 </details>
 
### Sample Respose

<details>
  <summary>JSON Response</summary>
  
```
{
  "content": [
    {
      "id": "abc123",
      "name": "ABCXYZ",
      "city": "PQRS",
      "state": "XYZ"
    }
  ],
  "last": true,
  "totalPages": 1,
  "totalElements": 1,
  "first": true,
  "sort": null,
  "numberOfElements": 1,
  "size": 20,
  "number": 0
}
```

</details>

## Container images

1. HMS application image - [Click here to see this image in DockerHub](https://hub.docker.com/repository/registry-1.docker.io/gokulan90/spring-boot-hms/tags?page=1)
2. Customized 'MySQL 8.0.12' image from DockerHub - [Click here to see this image in DockerHub](https://hub.docker.com/repository/registry-1.docker.io/gokulan90/hms-mysql/tags?page=1)

## Caution

In [application.properties](https://github.com/gokulanviswanathan/Spring-Boot-Hotel-Management-System/blob/master/src/main/resources/application.properties), please maintain Datasource URL as such for running this application in containerized environment

## Contact

Having queries in setting up this project? - No worries. Please contact project maintainer [Gokulan Viswanathan](mailto:gokulan90@yahoo.com?subject=[GitHub]%20Source%20Spring%20Boot%20HMS)
