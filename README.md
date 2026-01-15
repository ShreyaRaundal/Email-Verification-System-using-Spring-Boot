

# Email Verification System – Spring Boot

This project implements a **secure email verification flow** for user registration using **Spring Boot**.
A user account is activated **only after verifying the email** via a token-based confirmation link.

---

## 🚀 Features

* User registration with validation
* Email verification using **unique token**
* Account activation after successful verification
* Token expiry handling
* Secure SMTP email sending
* REST APIs tested using Postman
* Simple UI support (HTML + JavaScript)

---

## 🛠 Tech Stack

* **Java 17**
* **Spring Boot**
* **Spring Data JPA (Hibernate)**
* **MySQL**
* **Gmail SMTP (Java Mail Sender)**
* **Maven**
* **Postman**

---

## 🔄 Application Flow

1. User registers with email
2. User is saved with `isEnabled = false`
3. Confirmation token is generated
4. Verification email is sent
5. User clicks verification link
6. Token is validated & checked for expiry
7. User account is enabled

---

## 📌 API Endpoints

### ▶ Register User

```
POST /register
```

**Request Body (JSON):**

```json
{
  "userName": "Shreya",
  "userEmail": "test@gmail.com",
  "userPassword": "12345"
}
```

**Response:**

```
Verify email by the link sent to your email address
```

---

### ▶ Confirm Email

```
GET /confirm-account?token=YOUR_TOKEN
```

**Response:**

```
Email verified successfully!
```

---

## 🗂 Project Structure

```
src/main/java/com/mfs/Emailverification
├── Controller
├── Entity
├── Repository
├── Service
└── EmailverificationApplication.java
```

---

## ⚙ Configuration

Update the following in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/demo_register
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD

spring.mail.username=YOUR_EMAIL
spring.mail.password=YOUR_APP_PASSWORD
```

> ⚠️ Use **Gmail App Password**, not your real Gmail password.

---

## 🧪 Testing

* APIs tested using **Postman**
* Email verification tested via browser link

---

## 🎯 Learning Outcomes

* Real-world authentication flow
* Token-based verification
* SMTP email integration
* Spring Boot layered architecture

---
