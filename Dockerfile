FROM postgres:latest
ENV POSTGRES_PASSWORD=abc123
ENV POSTGRES_USER=postgres
ENV POSTGRES_DB=postgres
EXPOSE 5432
VOLUME  "/var/lib/postgresql/data"
