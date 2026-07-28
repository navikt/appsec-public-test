FROM europe-north1-docker.pkg.dev/cgr-nav/pull-through/nav.no/jre:openjdk-25@sha256:a53b3e296a0926b3d5fef1bc8d938bf39184e4263c3df8a09ec48f6a47f24f9b

COPY app/build/libs/app.jar /app/app.jar
WORKDIR /app
CMD [ "app.jar" ]
