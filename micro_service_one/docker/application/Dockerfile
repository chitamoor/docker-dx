FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER Rajeev Chitamoor <rajeev@chitamoor.com>
ADD target/microservice-one.jar app.jar
EXPOSE 8080 8009
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]
