# Getting Started

### Reference Documentation
please consider these:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/maven-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/reference/web/servlet.html)
* [Spring Boot Profiles](https://docs.spring.io/spring-boot/reference/features/profiles.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)


### Testing the Service

#### default profile
```
$>  java  -jar  target/demo-sb-profile-0.0.1-SNAPSHOT.jar

$>  curl http://localhost:8080/status
lorem ipsum
```

#### test profile
```
$>  java  -jar  -Dspring.profiles.active=test  target/demo-sb-profile-0.0.1-SNAPSHOT.jar

$>  curl http://localhost:8080/status
lorem ipsum
```

#### broccoli profile
```
$>  java -jar  -Dspring.profiles.active=broccoli  target/demo-sb-profile-0.0.1-SNAPSHOT.jar

$>  curl http://localhost:8080/status
broccoli message
```

#### prod profile
```
$>  java -jar  -Dspring.profiles.active=prod  target/demo-sb-profile-0.0.1-SNAPSHOT.jar

$>  curl http://localhost:8080/status
this is that PROD message
```
