###########################
#History API
###########################
# 1- OpenJDK JRE
# 2- Add folder
# 3- Copy JAR into image
# 4- Run java app
FROM gradle:7-jdk11
WORKDIR ./tmp/app
COPY . .
RUN gradle bootJar
ENTRYPOINT [ "java","-Dspring.data.mongodb.uri=mongodb://mongodb:27017/mediscreendb","-jar", "./build/libs/history-api-1.0.0.jar"]