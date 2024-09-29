FROM openjdk:21-ea

RUN mkdir /target
VOLUME /tmp
ADD build/libs/chat-service-1.0.jar target/app2.jar
EXPOSE 8080
RUN bash -c 'touch target/app2.jar'
RUN chmod -R 777 'target/app2.jar'
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=production","target/app2.jar"]