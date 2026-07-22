# 🔗 Linklytics - URL Shortener

Linklytics is a full-stack URL shortening application that allows users to create, manage, and track shortened URLs.

Users can generate short and memorable links, copy them easily, and monitor click analytics through a dashboard.

---

## ✨ Features

- 🔐 User Registration and Login
- 🔑 JWT-based Authentication
- 🔗 Create Short URLs
- 📋 Copy Short URLs to Clipboard
- 📊 Track URL Click Analytics
- 📈 View Click Statistics through Graphs
- 🗂️ Manage Created Short URLs
- 🧭 Protected Dashboard
- ⚡ Responsive User Interface
- 🎨 Modern UI with Tailwind CSS
- 🔔 Toast Notifications
- 🚨 Custom Error Page

---

## 🛠️ Tech Stack

### Frontend

- React.js
- React Router DOM
- Tailwind CSS v4
- React Query / TanStack Query
- Axios
- React Hook Form
- Framer Motion
- React Icons
- React Hot Toast
- Recharts

### Backend

- Java
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- Hibernate
- MySQL

---

## 📂 Project Structure

```text
src/
├── api/
│   └── api.js
│
├── components/
│   ├── AboutPage.jsx
│   ├── Card.jsx
│   ├── ErrorPage.jsx
│   ├── Footer.jsx
│   ├── LandingPage.jsx
│   ├── LoginPage.jsx
│   ├── Navbar.jsx
│   ├── RegisterPage.jsx
│   ├── TextField.jsx
│   │
│   └── DashBoard/
│       ├── DashBoardLayout.jsx
│       ├── CreateNewShorten.jsx
│       ├── Graph.jsx
│       ├── ShortenItem.jsx
│       ├── ShortenPopUp.jsx
│       └── ShortenUrlList.jsx
│
├── contextApi/
│   └── ContextApi.jsx
│
├── hooks/
│   └── useQuery.js
│
├── App.jsx
└── main.jsx
