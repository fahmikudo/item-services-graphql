FROM eclipse-temurin:8u372-b07-jdk-alpine
ADD target/item-services-0.0.1-SNAPSHOT.jar item-services-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["./wait-for-it.sh", "mysqldb:3306", "--" ,"java", "-jar", "item-services-0.0.1-SNAPSHOT.jar"]