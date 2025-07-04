#  JobConnect – Job Board Management API

A backend RESTful API built with Spring Boot that enables job seekers and companies to register, post jobs, and manage applications through a structured role-based architecture.

## 🚀 Features

- ✅ Register and manage **Users** with role-based mapping (`APPLICANT`, `COMPANY`)
- 👤 Applicants can apply to jobs and manage their application history
- 🏢 Companies can post new jobs and manage job listings
- 📄 Job listings can be filtered by **location** or **job type**
- 🗂️ Role-based entity relationships: `User ↔ Applicant/Company`, `Company ↔ Job`, `Job ↔ Application`

## 🛠️ Tech Stack

- **Backend:** Java, Spring Boot, Spring Data JPA, REST APIs
- **Database:** MySQL
- **Tools:** Maven, Postman, Eclipse

## 🧱 Project Structure

```

src/
├── controller        # REST endpoints
├── service           # Business logic with mapping
├── dto               # Data Transfer Objects
├── entity            # JPA Entities (User, Applicant, Company, Job, Application)
├── dao               # Repositories (interfaces for DB operations)
└── exception         # Global exception handling

````

## 📦 Entities

- **User**: Basic login credentials with `role` (APPLICANT or COMPANY)
- **Applicant**: Linked to User, holds personal info and resume URL
- **Company**: Linked to User, holds company name and location
- **Job**: Posted by Company with type, location, and description
- **Application**: Represents job applications from Applicants

## 📬 API Endpoints

### 🔐 User
- `POST /users/register` – Register a new user  
- `POST /users/login` – Authenticate a user  
- `GET /users/{id}` – Get user by ID  
- `DELETE /users/{id}` – Delete a user  

### 👤 Applicant
- `POST /applicants/register` – Register applicant linked to user  
- `GET /applicants/{id}` – Get applicant by ID  
- `DELETE /applicants/{id}` – Delete applicant  

### 🏢 Company
- `POST /companies/register` – Register company linked to user  
- `GET /companies/{id}` – Get company by ID  
- `DELETE /companies/{id}` – Delete company  

### 📄 Job
- `POST /jobs/post` – Post a new job  
- `GET /jobs/{id}` – Get job by ID  
- `GET /jobs/location/{location}` – Get jobs by location  
- `GET /jobs/type/{jobType}` – Get jobs by job type  
- `DELETE /jobs/{id}` – Delete job  

### 📑 Application
- `POST /applications/apply` – Apply to a job  
- `GET /applications/applicant/{id}` – Get applications by applicant  
- `GET /applications/job/{id}` – Get applications by job  
- `DELETE /applications/{id}` – Delete application  

## ✅ How to Run

Follow these steps to run the project locally:

### 1. Clone the Repository

```
git clone https://github.com/yourusername/jobconnect.git
cd jobconnect
````

### 2. Set Up MySQL

* Install MySQL if not already installed.
* Create a database named `jobconnect_db` (or any name you prefer).

```
CREATE DATABASE jobconnect_db;
```

### 3. Configure Database in `application.properties`

Update the following section in `src/main/resources/application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/jobconnect_db
spring.datasource.username=yourUsername
spring.datasource.password=yourPassword
```

### 4. Run the Spring Boot Application

```
mvn spring-boot:run
```

### 5. Test the APIs

Use [Postman](https://www.postman.com/) or any API testing tool to test the endpoints.

---

## ✍️ Author

**Shubham Raj Verma**  
*Java Full Stack Developer*


