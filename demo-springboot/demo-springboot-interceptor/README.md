# Getting Started

### Reference Documentation
please consider these:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/maven-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/reference/web/servlet.html)
* [Spring Boot WebServers](https://docs.spring.io/spring-boot/how-to/webserver.html)

### Running the Service

#### wombat profile
```
$>  java  -Dserver.port=9091  -Dspring.profiles.active=wombat  -jar target/demo-sb-interceptor-0.0.1-SNAPSHOT.jar
...
...
2025-03-16T10:11:02.588-04:00  INFO 11790 --- [           main] o.e.jetty.server.AbstractConnector       : Started ServerConnector@36356a72{HTTP/1.1, (http/1.1)}{0.0.0.0:9091}
2025-03-16T10:11:02.593-04:00  INFO 11790 --- [           main] o.s.b.web.embedded.jetty.JettyWebServer  : Jetty started on port 9091 (http/1.1) with context path '/'
2025-03-16T10:11:02.619-04:00  INFO 11790 --- [           main] i.g.i.i.DemoInterceptorApp               : Started DemoInterceptorApp in 6.105 seconds (process running for 7.767
...
...
```

```
## Unauthorized - No key
$>  $>  curl  -i  http://localhost:9091/message
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /status HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.88.1
> Accept: */*
> 
< HTTP/1.1 401 Unauthorized
$>
```

```
## Forbidden - Incorrect key
$>  $>  curl  -i  -H 'X-API-KEY: a'  http://localhost:9091/message
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /status HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.88.1
> Accept: */*
> X-API-KEY: a
> 
< HTTP/1.1 403 Forbidden
$>
```

```
## Ok - valid key
$>  $>  curl  -i  -H 'X-API-KEY: ************' http://localhost:9091/message
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /status HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.88.1
> Accept: */*
> X-API-KEY: ************
> 
< HTTP/1.1 200 OK
lorem ipsum
$>
```

```
2025-03-16T10:11:07.566-04:00  INFO 11790 --- [ qtp15912555-28] i.g.i.i.LoggingInterceptor               : [preHandle][ServletApiRequest@189049d1{ServletContextRequest@6bf2bf5e{EventsRequest@1ea30301{GET@6d041c1e http://localhost:9091/message HTTP/1.1}}}][GET] /message
2025-03-16T10:11:07.674-04:00  INFO 11790 --- [ qtp15912555-28] i.g.i.i.LoggingInterceptor               : [postHandle][ServletApiRequest@189049d1{ServletContextRequest@6bf2bf5e{EventsRequest@1ea30301{GET@6d041c1e http://localhost:9091/message HTTP/1.1}}}]  200
2025-03-16T10:11:07.675-04:00  INFO 11790 --- [ qtp15912555-28] i.g.i.i.MetricsInterceptor               : Request to /message took 107.904649 millis

```

