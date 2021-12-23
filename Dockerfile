# Here we are calling base image which is a tomcat server compatible with JDK 8
FROM tomcat:8.0-jre8

LABEL maintainer="Viral Bhavsar"

# Copy the .war file to the tomcat webapps directory

ADD target/FrontControllerDemo.war /usr/local/tomcat/webapps

# Expose port 8080 - This tells Docker container listen at specified port at runtime
EXPOSE 8080

# starting the tomcat server
CMD ["catalina.sh", "run"]