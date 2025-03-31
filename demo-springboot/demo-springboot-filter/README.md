# Getting Started

### Reference Documentation
please consider these:

* [Spring Web](https://docs.spring.io/spring-boot/reference/web/servlet.html)
* [Spring Boot WebServers](https://docs.spring.io/spring-boot/how-to/webserver.html)

### Running the Service

#### wombat profile
```
$>  java  -Dserver.port=8071  -Dspring.profiles.active=wombat  -jar target/demo-sb-filter-0.0.1-SNAPSHOT.jar
...
...
2025-03-16T10:11:02.588-04:00  INFO 8035 --- [ main] io.undertow.servlet                      : Initializing Spring embedded WebApplicationContext
2025-03-16T10:11:02.593-04:00  INFO 11790 --- [ main] o.s.b.w.e.undertow.UndertowWebServer     : Undertow started on port 8071 (http) with context path '/'
2025-03-16T10:11:02.619-04:00  INFO 11790 --- [ main] i.g.filter.filterdemo.DemoFilterApp      : Started DemoFilterApp in 3.569 seconds (process running for 4.216)
...
...
```

```
$>  curl  http://localhost:8071/books
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8071 (#0)
> GET /status HTTP/1.1
> Host: localhost:8071
> User-Agent: curl/7.88.1
> Accept: */*
> 
< HTTP/1.1 405 Method Not Allowed
< Allow: POST
< Connection: keep-alive
< x-timestamp: 2025-03-16T10:03:35.129227023Z
< Transfer-Encoding: chunked
< Content-Type: application/json
< X-BOOK-APP: bookish-header
$>
```

```
$>  curl  http://localhost:8071/books
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8071 (#0)
> POST /status HTTP/1.1
> Host: localhost:8071
> User-Agent: curl/7.88.1
> Accept: */*

< HTTP/1.1 200 OK
< Connection: keep-alive
< x-timestamp: 2025-03-16T10:04:14.339296744Z
< Content-Type: text/plain;charset=UTF-8
< Content-Length: 24
< X-BOOK-APP: bookish-header
< Date: Sun, 16 Mar 2025 10:04:14 GMT
< 
* Connection #0 to host localhost left intact
Ordered Book with id = 1
```
