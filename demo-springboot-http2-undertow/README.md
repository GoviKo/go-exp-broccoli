# Getting Started

### Reference Documentation
please consider these:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/maven-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/reference/web/servlet.html)
* [Spring Boot WebServers](https://docs.spring.io/spring-boot/how-to/webserver.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Spring http/2](https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-http2.html)

### Testing the Service

#### default tcp protocol
```
$>  java -jar -Dspring.profiles.active=wombat target/demo-sb-http2-undertow-0.0.1-SNAPSHOT.jar

$>  curl https://localhost:19211/weather?city=MN -v --insecure
*   Trying 127.0.0.1:19211...
* Connected to localhost (127.0.0.1) port 19211 (#0)
* ALPN: offers h2,http/1.1
* TLSv1.3 (OUT), TLS handshake, Client hello (1):
* TLSv1.3 (IN), TLS handshake, Server hello (2):
* TLSv1.3 (IN), TLS handshake, Encrypted Extensions (8):
* TLSv1.3 (IN), TLS handshake, Certificate (11):
* TLSv1.3 (IN), TLS handshake, CERT verify (15):
* TLSv1.3 (IN), TLS handshake, Finished (20):
* TLSv1.3 (OUT), TLS change cipher, Change cipher spec (1):
* TLSv1.3 (OUT), TLS handshake, Finished (20):

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
Requesting weather for city MN.  Temp = 39.39
```

#### using http1.0
```
$>  curl https://localhost:19211/weather?city=MN -v --insecure --http1.0
*   Trying 127.0.0.1:19211...
* Connected to localhost (127.0.0.1) port 19211 (#0)
* ALPN: offers http/1.0
* TLSv1.3 (OUT), TLS handshake, Client hello (1):
* TLSv1.3 (IN), TLS alert, no application protocol (632):
* OpenSSL/3.0.15: error:0A000460:SSL routines::tlsv1 alert no application protocol
* Closing connection 0
curl: (35) OpenSSL/3.0.15: error:0A000460:SSL routines::tlsv1 alert no application protocol
```
