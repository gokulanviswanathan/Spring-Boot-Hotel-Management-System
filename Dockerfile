##########################################################
#### DOCKER FILE TO RUN THIS SPRING BOOT JAVA PROJECT ####
##########################################################

FROM openjdk:8u131-jdk-alpine

MAINTAINER Gokulan Viswanathan "gokulan90@yahoo.com"

EXPOSE 8080

WORKDIR /usr/local/bin/

COPY ./target/spring-boot-hotel-mgmt-0.0.1-SNAPSHOT.jar spring-boot-hotel-mgmt-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "spring-boot-hotel-mgmt-0.0.1-SNAPSHOT.jar"]
