#Pull base image
FROM openjdk:8 AS BUILD_IMAGE

# Create app directory
RUN mkdir -p /usr/src/price-engine
WORKDIR /usr/src/price-engine

COPY gradle/wrapper ./gradle/wrapper/
COPY gradlew ./
COPY build.gradle ./
COPY src ./src/
# download dependencies
RUN chmod +x gradlew
RUN ./gradlew clean build

FROM openjdk:8-jre
WORKDIR /usr/
COPY --from=BUILD_IMAGE /usr/src/price-engine/build/libs/price-engine-0.0.1-SNAPSHOT.jar .

EXPOSE 9090
CMD ["java","-jar","price-engine-0.0.1-SNAPSHOT.jar"]