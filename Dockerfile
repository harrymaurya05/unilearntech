FROM openjdk:8
ADD target/unilearntech.jar unilearntech.jar
ENTRYPOINT ["java","-jar","/unilearntech.jar"]