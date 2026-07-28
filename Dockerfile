FROM europe-north1-docker.pkg.dev/cgr-nav/pull-through/nav.no/jre:openjdk-26@sha256:f499a136b8edc9dc7cdd755e856a68c1a715a79adba4724fcd7faedfaaf3c552

COPY app/build/libs/app.jar /app/app.jar
WORKDIR /app
CMD [ "app.jar" ]
