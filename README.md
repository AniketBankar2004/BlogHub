# 📖 BlogHub  

BlogHub is a simple **CRUD (Create, Read, Update, Delete)** web application that allows users to create, view, update, and delete blog posts.  
It uses **Java Spring Boot** for the backend and a lightweight frontend built with **HTML, CSS, and JavaScript**.

---

## 🚀 Features  

- ✅ **Create** – Add new blog posts with title and content  
- ✅ **Read** – View all available blog posts  
- ✅ **Update** – Edit existing blog posts  
- ✅ **Delete** – Remove blog posts from the system  

---

## 🛠️ Tech Stack  

**Frontend:**  
- HTML  
- CSS  
- JavaScript  

**Backend:**  
- Java Spring Boot  
- Spring Web  
- Spring Data MongoDB 
- MongoDB  

---

## 📂 Project Structure  

```plaintext
BlogHub/
├── backend/
│   ├── src/main/java/com/example/aniket/bloghub/
│   │   ├── controllers/      # REST Controllers
│   │   ├── models/           # Blog entity/model
│   │   ├── repositories/     # Spring Data repositories
│   │   └── services/         # Business logic
│   └── resources/
│       └── application.properties  # DB configurations
│
├── frontend/
│   ├── index.html
│   ├── style.css
│   └── script.js
│
└── README.md
