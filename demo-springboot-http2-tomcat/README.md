# Getting Started

### Reference Documentation
please consider these:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/maven-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/reference/web/servlet.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Spring http/2](https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-http2.html)

### Testing the Service

```
$>  java -jar  -Dspring.profiles.active=broccoli  target/demo-sb-profile-0.0.1-SNAPSHOT.jar

$>  curl http://localhost:8080/status
broccoli message
```

#### default tcp protocol
```
$>  java -jar -Dspring.profiles.active=wombat target/demo-sb-http2-0.0.1-SNAPSHOT.jar  

$>  curl https://localhost:19211/weather?city=MN -v --insecure
*   Trying 127.0.0.1:19211...
* Connected to localhost (127.0.0.1) port 19211 (#0)
* ALPN: offers h2,http/1.1
* TLSv1.3 (OUT), TLS handshake, Client hello (1):
* TLSv1.3 (IN), TLS handshake, Server hello (2):
...
...
* Using Stream ID: 1 (easy handle 0x55a776524780)
> GET /weather?city=MN HTTP/2
> Host: localhost:19211
> user-agent: curl/7.88.1
> accept: */*
> 
* TLSv1.3 (IN), TLS handshake, Newsession Ticket (4):
< HTTP/2 200 
< content-type: text/plain;charset=UTF-8
< content-length: 45
< 
* Connection #0 to host localhost left intact
Requesting weather for city MN.  Temp = 13.55
```

#### using http1.0
```
$>  curl https://localhost:19211/weather?city=MN -v --insecure --http1.0
*   Trying 127.0.0.1:19211...
* Connected to localhost (127.0.0.1) port 19211 (#0)
* ALPN: offers http/1.0
* TLSv1.3 (OUT), TLS handshake, Client hello (1):
* TLSv1.3 (IN), TLS handshake, Server hello (2):
...
...
* using HTTP/1.x
> GET /weather?city=MN HTTP/1.0
> Host: localhost:19211
> User Agent: curl/7.88.1
> Accept: */*
> 
* TLSv1.3 (IN), TLS handshake, Newsession Ticket (4):
< HTTP/1.1 200 
< Content-Type: text/plain;charset=UTF-8
< Content-Length: 44
< Date: Sun, 13 Apr 2025 02:58:40 GMT
< Connection: close
< 
* Closing connection 0
* TLSv1.3 (OUT), TLS alert, close notify (256):
Requesting weather for city MN.  Temp = 1.95
```
