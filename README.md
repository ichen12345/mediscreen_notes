# Mediscreen Sprint 2 - Patient Notes

This project is a **Spring Boot** application for managing patient medical notes. It allows users to view patient details and add doctor notes from medical providers.

---

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup Instructions](#setup-instructions)

---

## Features

- View all patients
- Add and view doctor notes for each patient
- Dockerized deployment for easy setup and scalability

---

## Technologies Used

- **Java**
- **Spring Boot**
- **Thymeleaf**
- **Maven** 
- **Docker** 
- **MongoDB**

---

## Setup Instructions

To run the project locally, follow these steps:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/ichen12345/mediscreen_notes.git
2. Make sure you are on the **feature-sprint-3** branch and run `mvn clean install` to build the project
3. Run the application with docker using `docker compose up -d`
4. Verify that the application is running: Open your browser and navigate to http://localhost:8082/patHistory to view the list of patients.
