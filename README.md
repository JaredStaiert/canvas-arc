# Readme

# Features

## Oauth2 Authorization Code Flow

Oauth2 Authorization Code Flow implemented with Java Spring oauth2, Spring Security, and Auth0

Diagram:
```mermaid
---
config:
  layout: dagre
---
flowchart TD
    A["React Frontend"] -- 1 send login request --> B["Spring Boot Backend"]
    B -- 2 redirect to login page --> C["Auth0 Server"]
    C -- 3 validate credentials --> D[("Auth0 User Database")]
    D --> C
    C -- 4 send access token --> B
    B -- 5 create security context --> E["Spring Security Context"]
    E --> B
    B -- 6 send JSSESIONID cookie --> A
    A -- 7+ Access API with  cookie --> F["REST API"]
    F --> A
    F --- B
    A@{ shape: rounded}
    B@{ shape: rounded}
    C@{ shape: rounded}
    E@{ shape: subproc}
    F@{ shape: subproc}
    style A fill:#BBDEFB,color:#000000
    style B fill:#C8E6C9,color:#000000
    style C fill:#FFCDD2,color:#000000
    style D fill:#FFCDD2,color:#000000
    style E fill:#C8E6C9,color:#000000
    style F fill:#C8E6C9,color:#000000
```
Login page in action: (user here clicks logout and is returned to original endpoint)
![login](https://github.com/user-attachments/assets/a4fe1e81-9e61-4b07-a85c-dceb714c3091)

## Database Interaction

Complex and peformant interaction with PostgreSQL database via native SQL and ORM (Spring Data JPA)

## User Sessions
Security and users sessions handled via Spring Security

# In Development

- Further work on the user interface, including more and more complex user interactions and utilites.
- Expanded role-based user interactions; including ADMIN and USER roles.
- Containerization, via Docker, and eventually a live example hosted.
- CI pipeline

# ENV / REPO Notes
This is a monorepo containing the frontend, backend, and DB projects for ease of viewing. Development of each component took part largely in individual repositories. 

## Secret Files
The following files are not kept in the repo for security purposes and will need to be replaced:

- (self) Signed SSL cert needed in ```backend/src/main/resources``` directory. Update in application.yaml under server.ssl

- Config file _secrets.yaml_ in the ```backend/src/main/resources``` directory.
  - _secrets.yaml_ should contain following:
    - auth0-issuer: _Domain of authentication server_
    - auth0-secret: _Secret for auth server_
    - auth0-cid: _Client ID (specific application ID for auth0)_
    - key-sign: _Password for SSL cert_
