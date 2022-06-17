FROM mysql:latest

MAINTAINER colley.fyi


ENV MYSQL_DATABASE=colley-db-mysql \
    MYSQL_ROOT_PASSWORD=fundiff24!

ADD CollegeAppDB_addCollege.sql /docker-entrypoint-initdb.d
ADD CollegeAppDB_applicantProfiles.sql /docker-entrypoint-initdb.d
ADD CollegeAppDB_colleges.sql /docker-entrypoint-initdb.d

EXPOSE 3306