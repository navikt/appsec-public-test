FROM docker.io/library/busybox:1.37.0

RUN mkdir -p /www && printf 'Hello world!\n' > /www/index.html
USER 65532:65532
EXPOSE 8080
CMD ["httpd", "-f", "-p", "8080", "-h", "/www"]
