
# 📚 Good Read Backend (Without Database)

A simple and clean **Spring Boot** based backend application to perform CRUD operations on a book collection, using an in-memory **HashMap**.  
This project is ideal for beginners to understand how REST APIs are built using Java and Spring Boot without involving a database.

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3.x
- Maven
- Postman (for API testing)

---

## ✨ Features

- **Get all books**  
- **Get a specific book by ID**
- **Add a new book**
- **Update an existing book**
- **Delete a book by ID**
- **Proper error handling** using `ResponseStatusException`

---

## 📂 Project Structure

```plaintext
practise.sanjo/
├── Book.java            # Model class representing a Book
├── BookRepo.java        # Interface for book operations
├── BookService.java     # Service layer with business logic
└── Controller.java      # REST Controller handling API requests
```

---

## 🚀 How to Run the Project

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Skywalker690/Good_Read_backend_without_database.git
   ```

2. **Open it in IntelliJ IDEA** (or any IDE like Eclipse).

3. **Build and Run** the Spring Boot application:
   - Run `Controller.java` (where the main Spring Boot Application is configured).

4. **Test the APIs** using Postman or your browser (for simple GET requests).

---

## 🧪 API Endpoints

| Method | Endpoint                | Description                     |
|:------:|:------------------------:|:-------------------------------:|
| GET    | `/books`                  | Get all books                   |
| GET    | `/books/{bookId}`          | Get a book by its ID             |
| POST   | `/books`                  | Add a new book                  |
| PUT    | `/books/{bookId}`          | Update an existing book         |
| DELETE | `/books/{bookId}`          | Delete a book by its ID          |

---

## 📅 Future Improvements

- Integrate H2 / MySQL database
- Add field validation (`@NotNull`, `@Size`)
- Add logging using SLF4J
- Add Swagger for API Documentation
- Write Unit and Integration Tests

---

## 🌟 Purpose

This project is made for educational purposes, helping beginners understand how to:
- Create RESTful APIs using Spring Boot
- Perform basic CRUD operations
- Handle exceptions properly
- Structure backend projects cleanly

---

# 🎉 Happy Coding!
