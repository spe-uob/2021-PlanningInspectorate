FROM maven:3.8.2-openjdk-11-slim as build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests=True

FROM openjdk:11.0-jdk-slim-buster
COPY --from=build /home/app/target/planningInspectorate-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
ENV PG_HOST=planning-inspectorate-postgre-toolchain-57dd747d57-t4jr9
ENV POSTGRES_PASSWORD=mysecretpassword
ENV POSTGRES_USER=planningInspectorateTool
ENV POSTGRES_DB=planningInspectorateDB
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]