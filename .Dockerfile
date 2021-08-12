FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY /target/expensereportdemo.jar expensereportdemo.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/expensereportdemo.jar"]
