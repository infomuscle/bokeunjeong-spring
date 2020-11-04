FROM openjdk:15-jdk

LABEL maintainer="infomuscle10@gmail.com"

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=build/libs/portfolio-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} bortfolio.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/bortfolio.jar"]


# ./gradlew clean build

# docker build -t portfolio .

# docker run -p 9000:80 --name bortfolio --network mysql-network portfolio

# docker run -d -p 9090:3306 -e MYSQL_ROOT_PASSWORD=password --name mysql --network mysql-network mysql --character-set-server=utf8
# --lower_case_table_names=1

# docker run --name zookeeper zookeeper

# docker network inspect mysql-network
# docker network connect mysql-newtork bortfolio