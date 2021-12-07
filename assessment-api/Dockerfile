###########################
#Assessment API
###########################
# 1- OpenJDK JRE
# 2- Add folder
# 3- Copy JAR into image
# 4- Run java app
FROM openjdk:11
RUN mkdir /tmp/app
COPY ./build/libs/assessment-api-1.0.0.jar /tmp/app
CMD java -jar /tmp/app/assessment-api-1.0.0.jar