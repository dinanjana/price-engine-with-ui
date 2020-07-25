#Pull base image
FROM openjdk:11

# Add build
COPY build/libs/price-engine-0.0.1-SNAPSHOT.jar /app/

# Add docker image labels
LABEL sysco.paastry.meta.team.release.version="TEST" sysco.paastry.meta.team.release.revision="TEST_IR1"

#Expose port
EXPOSE 8082

ENTRYPOINT ["java","-jar", "app/sla-api-0.0.1-SNAPSHOT.jar"]