## Project URLs for Quick Reference:

- Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- API Base URL: `http://localhost:8080/api/users/`

---

## API Endpoints (Sorted)

### 1. Get All Users
- Method: `GET`
- URL: `/api/users/`

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

#### Positive Request:
- Example URL: `/api/users/john123/`

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

#### Positive Response (User Deleted):
- Status Code: `204 No Content`

#### Negative Response (User Not Found):
```json
{
  "error": "User not found"
}
```

---
