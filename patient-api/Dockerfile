###########################
#Patient API
###########################
# 1- OpenJDK JRE
# 2- Add folder
# 3- Copy JAR into image
# 4- Run java app
FROM gradle:7-jdk11
WORKDIR ./tmp/app
COPY . .
RUN gradle bootJar
ENTRYPOINT [ "java","-jar", "./build/libs/patient-api-1.0.0.jar"]