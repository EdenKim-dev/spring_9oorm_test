# Stage 1: Build the application
FROM krmp-d2hub-idock.9rum.cc/goorm/gradle:7.3.1-jdk17 as build

WORKDIR /home/gradle/project

COPY . .

RUN echo "systemProp.http.proxyHost=krmp-proxy.9rum.cc\nsystemProp.http.proxyPort=3128\nsystemProp.https.proxyHost=krmp-proxy.9rum.cc\nsystemProp.https.proxyPort=3128" > /root/.gradle/gradle.properties

RUN gradle build -x test

# Stage 2: Run the application
FROM krmp-d2hub-idock.9rum.cc/goorm/eclipse-temurin:17-jre

WORKDIR /opt/techcampus

COPY --from=build /home/gradle/project/build/libs/kakao-0.0.1-SNAPSHOT.jar .

USER nobody

EXPOSE 3000

CMD ["java", "-Dhttp.proxyHost=krmp-proxy.9rum.cc", "-Dhttp.proxyPort=3128", "-Dhttp.proxySet=true", "-Dhttps.proxyHost=krmp-proxy.9rum.cc", "-Dhttps.proxyPort=3128", "-Dhttps.proxySet=true", "-jar", "kakao-0.0.1-SNAPSHOT.jar"]
