FROM postgres:latest
ENV POSTGRES_PASSWORD=postgres
ENV POSTGRES_USER=postgres
ENV POSTGRES_DB=postgres
ENV PG_HOST=localhost
VOLUME  "/var/lib/postgresql/data"

FROM maven:3.8.2-openjdk-11-slim as build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests=True

FROM openjdk:11.0-jdk-slim-buster
COPY --from=build /home/app/target/planningInspectorate-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8080 5432
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]