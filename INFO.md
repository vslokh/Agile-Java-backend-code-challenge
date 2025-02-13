## Project URLs for Quick Reference:

- Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- API Base URL: `http://localhost:8080/api/users/`

---

## API Endpoints

### 1. Get All Users
- Method: `GET`
- URL: `/api/users/`
- Description: Fetches all users from the in-memory data store.

#### Positive Response:
```json
[
  {
    "username": "john123",
    "name": "John Doe",
    "email": "john@example.com",
    "gender": "Male",
    "picture": "http://example.com/pic1.jpg"
  }
]
```

#### Negative Response (When no users exist):
```json
[]
```

---

### 2. Get User by Username
- Method: `GET`
- URL: `/api/users/{username}/`
- Description: Retrieves user details based on the provided username.

#### Positive Request Example:
- URL: `/api/users/john123/`

#### Positive Response:
```json
{
  "username": "john123",
  "name": "John Doe",
  "email": "john@example.com",
  "gender": "Male",
  "picture": "http://example.com/pic1.jpg"
}
```

#### Negative Response (User Not Found):
```json
{
  "error": "Not Found"
}
```

---

### 3. Create a New User
- Method: `POST`
- URL: `/api/users/`
- Headers: `Content-Type: application/json`
- Description: Creates a new user in the system.

#### Request Body:
```json
{
  "username": "jane456",
  "name": "Jane Smith",
  "email": "jane@example.com",
  "gender": "Female",
  "picture": "http://example.com/jane.jpg"
}
```

#### Positive Response:
```json
{
  "username": "jane456",
  "name": "Jane Smith",
  "email": "jane@example.com",
  "gender": "Female",
  "picture": "http://example.com/jane.jpg"
}
```

#### Negative Response (Duplicate Username):
```json
{
  "error": "User already exists"
}
```

---

### 4. Update an Existing User
- Method: `PUT`
- URL: `/api/users/{username}/`
- Headers: `Content-Type: application/json`
- Description: Updates the details of an existing user.

#### Request Body:
```json
{
  "name": "Jane Updated",
  "email": "jane.updated@example.com",
  "gender": "Female",
  "picture": "http://example.com/jane_updated.jpg"
}
```

#### Positive Response:
```json
{
  "username": "jane456",
  "name": "Jane Updated",
  "email": "jane.updated@example.com",
  "gender": "Female",
  "picture": "http://example.com/jane_updated.jpg"
}
```

#### Negative Response (User Not Found):
```json
{
  "error": "User not found"
}
```

---

### 5. Delete a User
- Method: `DELETE`
- URL: `/api/users/{username}/`
- Description: Deletes the user associated with the provided username.

#### Positive Response (User Deleted):
- Status Code: `204 No Content`

#### Negative Response (User Not Found):
```json
{
  "error": "User not found"
}
```

---

## Design Principles Mapping

### SOLID Principles Applied:

1. **Single Responsibility Principle (SRP)**
    - The `UserService` class handles only business logic related to users.
    - The `UserController` class is responsible for managing API endpoints and request handling.
    - Separate `commands` and `queries` are created for better separation of responsibilities (CQRS pattern).

2. **Open-Closed Principle (OCP)**
    - The design allows for easy extension of new features without modifying existing classes.
    - New functionalities like additional user attributes or different persistence mechanisms can be added without modifying `UserService`.

3. **Liskov Substitution Principle (LSP)**
    - The `User` model follows standard Java object principles and can be substituted in different implementations.
    - Any new type of user (e.g., `AdminUser`) can be implemented without breaking the existing logic.

4. **Interface Segregation Principle (ISP)**
    - `UserService` is focused on user operations, ensuring that no unnecessary methods are forced upon the service.
    - CQRS pattern ensures command and query responsibilities are properly divided.

5. **Dependency Inversion Principle (DIP)**
    - `UserController` depends on `UserService`, which follows an abstraction principle.
    - Future changes in user persistence (e.g., moving to a database) can be done without modifying the controller.

---
