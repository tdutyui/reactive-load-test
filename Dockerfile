FROM alpine/java:21-jdk
COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew build --no-daemon
ENTRYPOINT ["java","-jar","/build/libs/reactive-load-test.jar"]