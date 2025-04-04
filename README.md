# Contact List Application

## Description

This is a simple contact list application built using **Spring MVC**, **Spring Data JDBC**, and **Thymeleaf**. The application allows users to create, read, update, and delete (CRUD) contacts. The database is managed using **PostgreSQL** in a **Docker container**.

## Features

- Display all contacts in a table.
- Add new contacts via a form (ID is generated automatically).
- Edit existing contacts using the same form.
- Delete specific contacts using a button in the list.
- Database operations are performed using `JdbcTemplate`.

## Technologies Used

- **Spring Boot**
- **Spring MVC**
- **Spring Data JDBC**
- **Thymeleaf**
- **PostgreSQL** (via Docker)
- **Lombok**
- **Maven**
- **Git/GitHub**

## Project Structure

```
Spring-MVC-Spring-Data-JDBC/
│── src/
│   ├── main/
│   │   ├── java/com/example/Contacts/
│   │   │   ├── controller/     # MVC Controllers
│   │   │   ├── model/          # Entity models
│   │   │   ├── repository/     # Data access layer
│   │   │   ├── service/        # Business logic
│   │   │   ├── listener/       # Event listeners
│   │   │   ├── config/         # Configuration files
│   │   ├── resources/
│   │   │   ├── templates/      # Thymeleaf templates
│   │   │   ├── static/         # Static resources (CSS, JS)
│   │   │   ├── application.yml # Spring configuration
│   ├── test/                   # Unit tests
│── Dockerfile                  # Docker configuration
│── docker-compose.yml           # PostgreSQL setup
│── README.md                    # Project documentation
│── pom.xml                       # Maven dependencies
```

## Setup & Installation

### Prerequisites

Ensure you have the following installed:

- **JDK 17+**
- **Maven**
- **Docker & Docker Compose**
- **PostgreSQL client (optional)**

### Clone the Repository

```bash
git clone https://github.com/Esinkevi/Spring-MVC-Spring-Data-JDBC.git
cd Spring-MVC-Spring-Data-JDBC
```

### Start PostgreSQL with Docker

```bash
docker-compose up -d
```

### Configure the Database

Check `application.yml` for database settings:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/contacts
    username: postgres
    password: postgres
    hikari:
      schema: contacts_schema
  app:
    create-test-data: true  # Set to false to disable test data creation
```

### Run the Application

```bash
mvn spring-boot:run
```

### Access the Application

Once the application is running, open your browser and go to:

```
http://localhost:8080/contacts
```

## API Endpoints

| Метод | URL | Описание |
|--------|----------------|--------------------------------|
| `GET` | `/` | Выводит список всех контактов и форму добавления нового контакта |
| `POST` | `/save` | Сохраняет новый или редактируемый контакт |
| `GET` | `/delete/{id}` | Удаляет контакт по `id` |
| `GET` | `/edit/{id}` | Открывает форму редактирования контакта |

## Notes

- The database schema is automatically created if it does not exist.
- **Test data** can be enabled/disabled using `app.create-test-data` in `application.yml`.
- Make sure PostgreSQL is running before starting the application.
# Spring MVC & Spring Data JDBC - Contacts List


