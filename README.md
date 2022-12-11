# Getting started with Java and Spring-boot

![](https://github.com/flavours/documentation/workflows/CI/badge.svg)

<p align="center">
  <img src="https://utils.flavours.dev/presskit/spring_boot_flavour_glossy.svg" width="100">
</p>

A [Flavours](https://www.flavours.dev) project template for Java/Spring Boot


## Quick start

### Clone the repository

```
git clone git@github.com:malekabbes/SpringBootProjectGestion-Achat.git
```

### Build the project

```
cd SpringBootProjectGestion-Achat
docker-compose build
```

The project includes a ``web`` service, running the Java code, and a ``db`` service, running a Postgres database.
See the ``docker-compose.yml`` file for details.

### Run the project

```
docker-compose up
````

Containers for both services will be launched. The project can be reached at http://localhost:8000.

Hot-reloading is enabled (i.e. changes to the Java code in the project will cause the application to restart so that they 
can be used.)


## How to

### Run the local project on a different port

The container runs a Tomcat server listening on port 8080. The ``docker-compose.yml`` file is set up to
expose this port to the Docker host at port 8000, but you are free to change it as you wish - edit the ``ports`` directive:

```
services:
  web:
    [...]
    ports: 
      - 8000:8080
```

### How to prepare a new release of the getting-started project###
To create a new release of the getting started project, you have to updated the default welcome screen with the latest version.

```
docker run --rm --volume "`pwd`:/data" --user `id -u`:`id -g` pandoc/core:2.9.2 -s --css https://utils.flavours.dev/baseproject/1.0/style.css -o /data/src/main/resources/templates/index.html /data/README.md
```

Please also update the changelog accordingly and tag a new release in github.


### External how-to guides

* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)


## Reference

This project template uses:

* Java 11
* [FlywayDB](https://flywaydb.org/) for database migrations
* [Gradle](https://gradle.org/) to build and, in dev-mode, run the application with hot reload
* [Spring JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/) for database access
* [Spring Web](https://spring.io/guides/gs/serving-web-content/) to serve HTTP requests
* [Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html) for HTML-templating


### External reference

* [Official Gradle documentation](https://docs.gradle.org)
* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/gradle-plugin/reference/html/)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#using-boot-devtools)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#boot-features-spring-mvc-template-engines)
* [JDBC API](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#boot-features-sql)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#howto-execute-flyway-database-migrations-on-startup)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#boot-features-security)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
