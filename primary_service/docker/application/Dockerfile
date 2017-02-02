FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER Rajeev Chitamoor <rajeev@chitamoor.com>
ADD target/primary_service.jar app.jar

VOLUME /log/
RUN sh -c 'touch /app.jar'
RUN sh -c 'touch /log/application.log'
RUN sh -c 'touch /log/application.json'

EXPOSE 8080 8009
ENTRYPOINT ["java","-jar","/app.jar"]
