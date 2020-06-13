# Redesign of the website FCO at WildCodeSchool
This Project has been build in 8 weeks. At this point I started coding three month ago.  
We work in team with [Clement1987](https://github.com/Clement1987), [housseyn02](https://github.com/housseyn02) and  [et3rnity45](https://github.com/et3rnity45).  I can't show you the original repo, because it steel private ... By the way the Wild Code School gives us the right to show this project.
## Manual 
### Requirements

For building and running the application you need:

- [MySql](https://www.mysql.com/fr/)    
      - create database called `fcodb`    
      - a user `userfco`  
      - password : `userfco`  
        ( you can also modify user in `WCS-sept2019-java-fco_public/src/main/resources/application.properties`)
- [JDK 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
- [Maven 3](https://maven.apache.org)


### Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `Sept2019JavaOrleansFcoApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
