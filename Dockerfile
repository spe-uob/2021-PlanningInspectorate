FROM postgres:latest
ENV POSTGRES_PASSWORD=abc123
ENV POSTGRES_USER=postgres
ENV POSTGRES_DB=postgres
ENV PG_HOST=kube-toolchain-planninginspectorate-20211209163109424
EXPOSE 5432
VOLUME  "/var/lib/postgresql/data"
