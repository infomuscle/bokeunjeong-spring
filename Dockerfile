FROM openjdk:11

LABEL maintainer="infomuscle10@gmail.com"

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=build/libs/bokeunjeong-spring-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} bokeunjeong-spring.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/bokeunjeong-spring.jar"]


# 배포

# ./gradlew clean build
# docker build -t infomuscle10/bokeunjeong-spring .
# Docker Push
# AWS 접속
# docker pull infomuscle10/bokeunjeong-spring
# docker-compose up -d


### prod?
# docker run -p 8080:8080 --name bokeunjeong-spring -e "SPRING_PROFILES_ACTIVE=prod" -v /var/lib/docker/volumes/bokeunjeong-spring/_data:/tmp --network aws-network infomuscle10/bokeunjeong-spring

# -------- #

# ./gradlew clean build

# docker build -t infomuscle10/bokeunjeong-spring .

# docker run -p 80:8080 --name bokeunjeong-spring --network local-network infomuscle10/bokeunjeong-spring

# docker run -d -p 9090:3306 -e MYSQL_ROOT_PASSWORD=password --name mysql --network mysql-network mysql --character-set-server=utf8
# --lower_case_table_names=1

# docker run -p 2181:2181 --network mysql-network --name zookeeper zookeeper

# docker run -p 9092:9092 -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 -e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 -e KAFKA_ADVERTISED_HOST_NAME=kafka -e KAFKA_ADVERTISED_PORT=9092 -e KAFKA_CREATE_TOPICS=test:1:1 --network mysql-network --name kafka kafka
# -e KAFKA_BROKER_ID=1

# cd /opt/kafka/bin/
# kafka-topics.sh --describe --topic test --zookeeper zookeeper:2181

# docker network inspect mysql-network
# docker network connect mysql-newtork bokeunjeong-spring
