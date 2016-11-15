FROM postgres:9.4
MAINTAINER Rajeev Chitamoor <rajeev@chitamoor.com>

RUN echo "host    all             all             0.0.0.0/0            trust" >> /var/lib/postgresql/data/pg_hba.conf

RUN echo "listen_addresses='*'" >> /var/lib/postgresql/data/postgresql.conf

COPY docker/database/seed.sql /docker-entrypoint-initdb.d/seed.sql

CMD ["postgres"]
