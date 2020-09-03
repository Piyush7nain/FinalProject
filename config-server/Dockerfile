FROM openjdk:latest
EXPOSE 8090
ADD target/config-server.jar config-server.jar
ENTRYPOINT [ "sh", "-c", "java -jar /config-server.jar" ]