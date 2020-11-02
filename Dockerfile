FROM openjdk:11-jdk

LABEL maintainer="infomuscle10@gmail.com"

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=out/artifacts/portfolio_jar/portfolio.jar

ADD ${JAR_FILE} portfolio.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/portfolio.jar"]