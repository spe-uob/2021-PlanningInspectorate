FROM postgres:latest
ENV POSTGRES_PASSWORD=abc123
ENV POSTGRES_USER=postgres
ENV POSTGRES_DB=postgres
ENV PG_HOST=planninginspectorate-database-20211209183103665
EXPOSE 5432
VOLUME  "/var/lib/postgresql/data"
