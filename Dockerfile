FROM amazoncorretto:19
MAINTAINER AMZ
COPY target/amz-0.0.1-SNAPSHOT.jar amz-app.jar
EXPOSE 8080 
ENTRYPOINT ["java","-jar","/amz-app.jar"]

CMD ["/bin/sh"]
