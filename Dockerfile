FROM gcr.io/distroless/java21-debian12@sha256:769c6ae82b1aaeeecc263f7fe3662668ab2841d3f62ed8d54c5221555c53d754

COPY app/build/libs/app.jar /app/app.jar
WORKDIR /app
CMD [ "app.jar" ]