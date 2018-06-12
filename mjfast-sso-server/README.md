# jwt-springboot-sso
* jwt+springboot实现的单点登录
# Single Sign On (SSO) Example with JSON Web Token (JWT), Spring Boot - Authentication Service

# What you'll need
- JDK 1.7+
- Maven 3+

# Stack
- Java
- Spring Boot
- FreeMarker

# Run
- Run jwt-sso-server: `mvn spring-boot:run`
- Run jwt-sso-client1: `mvn spring-boot:run -Dserver.port=8180`
- Run jwt-sso-client2: `mvn spring-boot:run -Dserver.port=8280`