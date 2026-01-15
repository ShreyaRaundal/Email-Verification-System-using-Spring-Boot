

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
<img width="1366" height="659" alt="image" src="https://github.com/user-attachments/assets/2d3353a7-1ecc-4331-b08c-3e611118ee7f" />
<img width="1366" height="756" alt="image" src="https://github.com/user-attachments/assets/6ae648ff-548d-4baa-a3b4-5f126e210607" />
<img width="1359" height="727" alt="image" src="https://github.com/user-attachments/assets/b11ceec6-5832-4c1d-a79b-920dfa445818" />
<img width="1366" height="727" alt="image" src="https://github.com/user-attachments/assets/c4652c87-dcdf-497a-b49e-163133835d89" />
<img width="1366" height="716" alt="image" src="https://github.com/user-attachments/assets/58a136a4-14e6-41a6-848f-1db48ce61986" />
<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/3f8e22f3-462e-4279-ad0e-7d44060d5547" />
<img width="1357" height="725" alt="image" src="https://github.com/user-attachments/assets/3836f86d-9227-47e1-a626-5b0f1d6f2257" />
<img width="1364" height="732" alt="image" src="https://github.com/user-attachments/assets/56fbfff7-a00a-4e86-aada-22f5b6a55bbc" />
<img width="1364" height="738" alt="image" src="https://github.com/user-attachments/assets/84aa1505-f7e7-4757-ae73-add74dd9682c" />











