# stomp

This is a simple showcase of communicating via WebSockets and STOMP
(Simple Text Orientated Messaging Protocol).

## server

The server part has been written in Java and makes use of an in-memory message broker provided by Spring Boot.

```
mvn spring-boot:run
```

Afterwards the server is available under http://localhost:8080.

## client

The client part has been written in Typescript as an Angular Browser App. It connects to the message broker and displays
new messages in real time. 

```
npm run serve
```

Afterwards the client is available under http://localhost:4200.
