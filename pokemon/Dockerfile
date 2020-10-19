FROM java:8
VOLUME /tmp
EXPOSE 8080
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.4.0/wait /wait
ADD target/pokemon-0.0.1-SNAPSHOT.jar pokemon-0.0.1-SNAPSHOT.jar
RUN pwd && ls
RUN chmod +x /wait
CMD /wait && java -jar pokemon-0.0.1-SNAPSHOT.jar