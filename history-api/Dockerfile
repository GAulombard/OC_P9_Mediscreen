###########################
#History API
###########################
# 1- OpenJDK JRE
# 2- Add folder
# 3- Copy JAR into image
# 4- Run java app
FROM openjdk:11
RUN mkdir /tmp/app
COPY ./build/libs/history-api-1.0.0.jar /tmp/app
CMD java -Dspring.data.mongodb.uri=mongodb://mongodb:27017/mediscreendb -jar /tmp/app/history-api-1.0.0.jar