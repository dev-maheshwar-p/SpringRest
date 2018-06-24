#FROM tomcat:7.0.75-jre8-alpine
#MAINTAINER xyz
#RUN ["rm", "-fr", "/usr/local/tomcat/webapps/ROOT"]
#COPY ./target/SpringWS.war /usr/local/tomcat/webapps/ROOT.war
#CMD ["catalina.sh", "run"]

#FROM docker.prod.walmart.com/logistics/tomcat:7


#FROM tomcat:7.0.75-jre8-alpine
#MAINTAINER Patrick Dolan, patrick.dolan@walmart.com
#USER root

## get webapp
#COPY ./target/*.war /usr/local/tomcat/webapps/ROOT.war
#RUN mv /usr/local/tomcat/webapps/ROOT /usr/local/tomcat/webapps/tc && chown -R tomcat:tomcat /usr/local/tomcat && chown tomcat:tomcat /usr/local/tomcat/webapps/ROOT.war && chown -R tomcat:tomcat /usr/local/tomcat/logs

#USER tomcat 

#app will be EXPOSE'd on port 8080


#FROM tomcat:9-jre8-alpine
#COPY ./target/springws.war /usr/local/tomcat/webapps/springws.war

#RUN apt-get update
#RUN apt-get install -y maven

#WORKDIR /code
#ADD pom.xml /code/pom.xml
#RUN ["mvn", "dependency:resolve"]

#ADD src /code/src
#RUN ["mvn", "package"]
#CMD ["usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-war", "target/techpoint.war"]


#FROM tomcat:8.5.11-jre8
#COPY ./target/springws.war /usr/local/tomcat/webapps/ROOT.war



# fetch basic image
FROM maven:3.3.9-jdk-8

# application placed into /opt/app
RUN mkdir -p /opt/app
WORKDIR /opt/app

# selectively add the POM file and
# install dependencies
COPY pom.xml /opt/app/
RUN mvn install

# rest of the project
COPY src /opt/app/src
RUN mvn package

# local application port
EXPOSE 8080

# execute it
CMD ["mvn", "tomcat7:run"]