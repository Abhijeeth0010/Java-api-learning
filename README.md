# Java API Learning

A hands-on, level-by-level journey to learn **Java + Spring Boot + REST APIs**, built as small working tasks. Each level adds one new concept on top of the previous one.

This repository contains the **Spring Boot project (`api-basics`)**, where I build my own APIs from scratch.

## Tech Stack

- Java
- Spring Boot (Spring Web)
- Maven
- Eclipse IDE (Spring Tools)
- Postman (API testing)
- Git & GitHub

## Learning Roadmap

| Level | Topic | Status |
|---|---|---|
| 1 | Consume an API: GET request with Java `HttpClient` | Done |
| 2 | Convert JSON into Java objects with Jackson | Done |
| 3 | Send data: POST request with a JSON body | Done |
| 4 | Error handling: status codes and `try/catch` | Done |
| 5 | Build my own API: first Spring Boot endpoints | Done |
| 6 | Full CRUD API with an in-memory list | Done |
| 6b | Service layer and Dependency Injection | Next |
| 6c | Validation and global exception handling | Planned |
| 6d | DTOs | Planned |
| 7 | Real database (H2, then MySQL) | Planned |
| Final | One complete project combining everything | Planned |

Levels 1 to 4 are plain Java programs that call a public API ([JSONPlaceholder](https://jsonplaceholder.typicode.com)). They live in a separate Eclipse project and are not part of this repository.

## What's in This Project

### Endpoints

**Basics**

| Method | URL | Description |
|---|---|---|
| GET | `/hello` | Returns a fixed greeting |
| GET | `/hello/{name}` | Greets the name given in the path (path variable) |
| GET | `/greet?name=...` | Greets the name given as a query parameter |

**Task API (CRUD, data stored in memory)**

| Method | URL | Description |
|---|---|---|
| GET | `/tasks` | Get all tasks |
| GET | `/tasks/{id}` | Get one task |
| POST | `/tasks` | Create a task |
| PUT | `/tasks/{id}` | Update a task |
| DELETE | `/tasks/{id}` | Delete a task |

### Example request body (POST / PUT)

```json
{
  "title": "Gym",
  "status": false
}
```

> Note: tasks are kept in an in-memory list, so **all data is lost when the app restarts**. A real database is planned for Level 7.

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/YOUR-USERNAME/java-api-learning.git
   ```
2. Import into Eclipse: `File > Import > Maven > Existing Maven Projects`.
3. Run `ApiBasicsApplication.java` as a **Java Application**.
   Or from the terminal, in the project folder:
   ```bash
   ./mvnw spring-boot:run
   ```
4. The server starts on `http://localhost:8080`.
5. Test the endpoints with Postman or a browser. Use `http`, not `https`, on localhost.

## Project Structure

```
src/main/java/com/learning/apibasics/
├── ApiBasicsApplication.java   # App entry point
├── HelloController.java        # Basic GET endpoints
├── Task.java                   # Model (data shape)
└── TaskController.java         # CRUD endpoints for tasks
```

## Concepts Covered So Far

- How APIs work: client, server, request, response, endpoint, status codes
- Java `HttpClient`, building requests with the Builder pattern
- JSON serialization and deserialization with Jackson
- Error handling with `try/catch` and HTTP status codes
- MVC and layered architecture (Controller, Service, Repository)
- Spring Boot basics: annotations, embedded Tomcat, `@RestController`
- `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`
- `@PathVariable`, `@RequestParam`, `@RequestBody`
- `ResponseEntity` for controlling status codes
- Using Git and GitHub for version control
