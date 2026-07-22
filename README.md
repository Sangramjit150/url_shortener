# 🔗 Linklytics - URL Shortener

Linklytics is a full-stack URL shortening application that allows users to create short URLs, manage their links, track click analytics, and securely access their accounts using JWT authentication.

The project consists of a React frontend and a Spring Boot backend connected to a database.

---

## 🚀 Features

### 🔐 Authentication

- User registration
- User login
- JWT-based authentication
- Secure protected routes
- Logout functionality

### 🔗 URL Shortening

- Create short URLs
- Redirect users using shortened URLs
- Copy shortened URLs to the clipboard
- Manage created URLs

### 📊 Analytics Dashboard

- Track total clicks
- View click analytics by date
- Visualize data using charts
- View all created short URLs

### 🎨 Frontend

- Responsive user interface
- React-based architecture
- Tailwind CSS styling
- Framer Motion animations
- React Hook Form validation
- Toast notifications

---

# 🛠️ Tech Stack

## Frontend

- React
- Vite
- Tailwind CSS
- React Router
- Axios
- React Hook Form
- TanStack React Query
- Framer Motion
- React Icons
- Recharts

## Backend

- Java
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- Hibernate
- REST APIs
- Maven

## Database

- MySQL

---

# 📁 Project Structure

## Frontend

```text
url-shortener-frontend/
│
├── public/
│   └── images/
│
├── src/
│   │
│   ├── api/
│   │   └── api.js
│   │
│   ├── components/
│   │   ├── Dashboard/
│   │   │   ├── DashBoardLayout.jsx
│   │   │   ├── CreateNewShorten.jsx
│   │   │   ├── ShortenItem.jsx
│   │   │   ├── ShortenUrlList.jsx
│   │   │   ├── ShortenPopUp.jsx
│   │   │   └── Graph.jsx
│   │   │
│   │   ├── LandingPage.jsx
│   │   ├── Navbar.jsx
│   │   ├── Footer.jsx
│   │   ├── LoginPage.jsx
│   │   ├── RegisterPage.jsx
│   │   ├── AboutPage.jsx
│   │   ├── TextField.jsx
│   │   └── ErrorPage.jsx
│   │
│   ├── contextApi/
│   │   └── ContextApi.jsx
│   │
│   ├── hooks/
│   │   └── useQuery.js
│   │
│   ├── DummyData/
│   │   └── Data.js
│   │
│   ├── App.jsx
│   ├── AppRouter.jsx
│   └── main.jsx
│
├── package.json
├── vite.config.js
└── README.md

url-shortener/
│
├── src/
│   │
│   ├── main/
│   │   │
│   │   ├── java/
│   │   │   └── com.embarkX.url_shortener/
│   │   │
│   │   │       ├── controllers/
│   │   │       │   ├── AuthController.java
│   │   │       │   ├── RedirectController.java
│   │   │       │   └── UrlMappingController.java
│   │   │       │
│   │   │       ├── dtos/
│   │   │       │   ├── ClickEventDTO.java
│   │   │       │   ├── LoginRequest.java
│   │   │       │   ├── RegisterRequest.java
│   │   │       │   └── UrlMappingDTO.java
│   │   │       │
│   │   │       ├── Jwt/
│   │   │       │   ├── JwtAuthenticationFilter.java
│   │   │       │   ├── JwtAuthenticationResponse.java
│   │   │       │   └── JwtUtils.java
│   │   │       │
│   │   │       ├── models/
│   │   │       │   ├── click_event.java
│   │   │       │   ├── url_mapping.java
│   │   │       │   └── User.java
│   │   │       │
│   │   │       ├── repositories/
│   │   │       │   ├── ClickEventRepository.java
│   │   │       │   ├── UrlMappingRepository.java
│   │   │       │   └── UserRepository.java
│   │   │       │
│   │   │       ├── security/
│   │   │       │   ├── WebConfig.java
│   │   │       │   └── WebSecurityConfiguration.java
│   │   │       │
│   │   │       ├── services/
│   │   │       │   ├── UrlMappingService.java
│   │   │       │   ├── UserService.java
│   │   │       │   ├── UserDetailsImpl.java
│   │   │       │   └── UserDetailsServiceImpl.java
│   │   │       │
│   │   │       └── UrlShortenerApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── pom.xml
└── README.md
