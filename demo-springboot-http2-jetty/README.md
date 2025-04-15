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

### NB
[HTTP/2 With Jetty](https://docs.spring.io/spring-boot/how-to/webserver.html#howto.webserver.configure-http2.jetty)

"""
  For HTTP/2 support, Jetty requires the additional org.eclipse.jetty.http2:jetty-http2-server dependency. To use h2c no other dependencies are required. To use h2, you also need to choose one of the following dependencies, depending on your deployment:

    org.eclipse.jetty:jetty-alpn-java-server to use the JDK built-in support

    org.eclipse.jetty:jetty-alpn-conscrypt-server and the Conscrypt library
"""

for self signed certificate, Jetty throws http error 400 Invalid SNI



### Testing the Service

#### default tcp protocol
```
$>  java -jar -Dspring.profiles.active=wombat target/demo-sb-http2-jetty-0.0.1-SNAPSHOT.jar

$>  curl https://localhost:19211/weather?city=MN -v --insecure
*    Trying 127.0.0.1:19211...
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
* SSL connection using TLSv1.3 / TLS_AES_256_GCM_SHA384
* ALPN: server accepted h2
...
...
*  Using Stream ID: 1 (easy handle 0x56212bbe2780)
> GET /weather?city=MN HTTP/2
> Host: localhost:19211
> user-agent: curl/7.88.1
> accept: */*
> 
* TLSv1.3 (IN), TLS handshake, Newsession Ticket (4):
< HTTP/2 200 
< content-type: text/plain;charset=utf-8
< content-length: 44
< 
* Connection #0 to host localhost left intact
Requesting weather for city MN.  Temp = 7.72
```

#### using http1.0
```
$>  curl https://localhost:19211/weather?city=MN -v --insecure --http1.0
*   Trying 127.0.0.1:19211...
* Connected to localhost (127.0.0.1) port 19211 (#0)
* ALPN: offers http/1.0
* TLSv1.3 (OUT), TLS handshake, Client hello (1):
* TLSv1.3 (IN), TLS handshake, Server hello (2):
* OpenSSL SSL_connect: SSL_ERROR_SYSCALL in connection to localhost:19211 
* Closing connection 0
curl: (35) OpenSSL SSL_connect: SSL_ERROR_SYSCALL in connection to localhost:19211 
```
