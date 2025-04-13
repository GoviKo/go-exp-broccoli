# Getting Started

### Reference Documentation
please consider these:

* [Spring AOP] (https://docs.spring.io/spring-framework/reference/core/aop.html)
* [Spring Web](https://docs.spring.io/spring-boot/reference/web/servlet.html)
* [Spring Boot WebServers](https://docs.spring.io/spring-boot/how-to/webserver.html)
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/maven-plugin/reference/html/)


### Running the Service

#### wombat profile
```
$>  java  -Dserver.port=9861  -Dspring.profiles.active=wombat  -Dspring.threads.virtual.enabled=true  -jar target/demo-sb-aspect-0.0.1-SNAPSHOT.jar
...
...
2025-03-31T04:17:37.598-04:00  INFO 26405 --- [           main] o.e.jetty.server.AbstractConnector       : Started ServerConnector@15b2dedc{HTTP/1.1, (http/1.1)}{0.0.0.0:9861}
2025-03-31T04:17:37.608-04:00  INFO 26405 --- [           main] o.s.b.web.embedded.jetty.JettyWebServer  : Jetty started on port 9861 (http/1.1) with context path '/'
2025-03-31T04:17:37.637-04:00  INFO 26405 --- [           main] i.g.aspect.aspectdemo.AspectDemoApp      : Started AspectDemoApp in 9.267 seconds (process running for 10.811)
...
...
```

```
$>  curl http://localhost:9861/lorem
35 jetty-0 lorem ipsum$>  
```

```
...
...
2025-03-31T04:17:37.637-04:00  INFO 26405 --- [           main] i.g.aspect.aspectdemo.AspectDemoApp      : Started AspectDemoApp in 9.267 seconds (process running for 10.811)
2025-03-31T04:19:11.580-04:00  INFO 26405 --- [        jetty-0] i.g.aspect.aspectdemo.LoggingAspect      : A method in the service package is about to be executed.
2025-03-31T04:19:11.584-04:00  INFO 26405 --- [        jetty-0] i.g.aspect.aspectdemo.LoggingAspect      : Entering method: message
2025-03-31T04:19:11.585-04:00  INFO 26405 --- [        jetty-0] i.g.aspect.aspectdemo.LoggingAspect      : Exiting method: message
2025-03-31T04:19:11.586-04:00  INFO 26405 --- [        jetty-0] i.g.aspect.aspectdemo.LoggingAspect      : Execution time of message  :  7.121083 ms
2025-03-31T04:19:11.586-04:00  INFO 26405 --- [        jetty-0] i.g.aspect.aspectdemo.LoggingAspect      : Execution time of lorem  :  7.910842 ms
```
