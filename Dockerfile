FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./reserva-0.0.1-SNAPSHOT.jar reserva.jar
ENTRYPOINT ["java","-jar","/reserva.jar"]