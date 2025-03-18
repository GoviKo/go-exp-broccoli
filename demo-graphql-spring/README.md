# Getting Started

### Reference Documentation
please consider these:

* [Official GraphQL Spring Boot documentation](https://www.graphql-java.com/tutorials/getting-started-with-spring-boot/)
* [Spring Web](https://docs.spring.io/spring-boot/reference/web/servlet.html)
* [Spring Boot WebServers](https://docs.spring.io/spring-boot/how-to/webserver.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Spring Boot GraphQL Reference Guide](https://spring.io/guides/gs/graphql-server/)

### Testing the Service

#### broccoli profile
```
$>  java "-Dspring.profiles.active=broccoli"  -jar  target/demo-graphql-spring-0.0.1-SNAPSHOT.jar
...
...
 INFO 7405 --- [           main] o.s.b.a.g.GraphQlAutoConfiguration       : GraphQL schema inspection:
    Unmapped fields: {}
    Unmapped registrations: {}
    Unmapped arguments: {}
    Skipped types: []
INFO 7405 --- [main] s.b.a.g.s.GraphQlWebMvcAutoConfiguration : GraphQL endpoint HTTP POST /graphql
INFO 7405 --- [main] io.undertow                              : starting server: Undertow - 2.3.18.Final
...
...

INFO 7405 --- [main] i.goviko.graphql.spring.BookGraphQLApp   : Started BookGraphQLApp in 9.345 seconds (process running for 10.804)
```

#### a graphiql query:
```
query bookDetails {
  bookById(id: "book-2") {
    id
    name
    pageCount
    author {
      firstName
      lastName
    }
  }
}
```

#### response:
```
{
  "data": {
    "bookById": {
      "id": "book-2",
      "name": "Hitchhiker's Guide to the Galaxy",
      "pageCount": 220,
      "author": {
        "firstName": "Douglas",
        "lastName": "Adams"
      }
    }
  }
}
```
