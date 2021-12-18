###########################
#Patient API
###########################
#1. Initializes a new build stage and sets the base image for subsequent instructions
#2. Set the working directory for all subsequent instructions
#3. Copy files from the host system into the image
#4. Create the jar file
#5. Configure how the conainer will run
FROM gradle:7-jdk11
WORKDIR ./tmp/app
COPY . .
RUN gradle bootJar
ENTRYPOINT [ "java","-jar", "./build/libs/patient-api-1.0.0.jar"]