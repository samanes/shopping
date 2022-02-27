FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=*.jar
COPY target/*.jar shopping.jar
ENTRYPOINT ["java", "-jar", "shopping.jar"]