# Course Management JDBC

A modular Java backend project built with Spring Boot and PostgreSQL (JDBC) to manage courses, students, teachers, and enrollments. The project follows a layered architecture with clear separation of concerns: controllers, services, repositories, entities, mappers, and models.

---

## 🚀 Features

Student Management → Create, update, delete, and list students.

Teacher Management → Manage teacher records.

Course Management → CRUD operations for courses.

Enrollment Management → Enroll and unenroll students from courses.

RESTful API → Endpoints designed with Spring Boot controllers.

Database Integration → PostgreSQL with JDBC and JdbcTemplate.

Layered Architecture → Controller → Service → Repository → Entity → Mapper → Model.

---

## 📂 Project Structure

src/main/java/org/example/coursemanagementjdbc
```markdown
├── controller
│   ├── CourseController
│   ├── EnrollmentController
│   ├── StudentController
│   └── TeacherController
├── dao
│   ├── entity (CourseEntity, StudentEntity, TeacherEntity, EnrollmentEntity)
│   └── repository (CourseRepository, StudentRepository, TeacherRepository, EnrollmentRepository)
├── mapper (CourseMapper, StudentMapper, TeacherMapper, EnrollmentMapper)
├── model
│   ├── request (CourseRequest, StudentRequest, TeacherRequest, EnrollmentRequest)
│   └── response (CourseResponse, StudentResponse, TeacherResponse, EnrollmentResponse)
├── service (CourseService, StudentService, TeacherService, EnrollmentService)
└── CourseManagementJdbcApplication
```
---

## ⚙️ Configuration

Environment variables are defined in .env:

DB_URL=jdbc:postgresql://localhost:5435/course_db
DB_USERNAME=postgres
DB_PASSWORD=your_password

application.properties reads from .env:

server.port=5643
spring.application.name=course-management-jdbc
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

---

## 📡 API Endpoints

### Students
- `POST /v1/students` → Add new student  
- `GET /v1/students/{id}` → Get student by ID  
- `GET /v1/students` → List all students  
- `PUT /v1/students/{id}` → Update student information  
- `DELETE /v1/students/{id}` → Delete student  


### Teachers
- `POST /v1/teachers` → Add new teacher  
- `GET /v1/teachers/{id}` → Get teacher by ID  
- `GET /v1/teachers` → List all teachers  
- `PUT /v1/teachers/{id}` → Update teacher information  
- `DELETE /v1/teachers/{id}` → Delete teacher  

### Courses
- `POST /v1/courses` → Add new course  
- `GET /v1/courses/{id}` → Get course by ID  
- `GET /v1/courses` → List all courses  
- `PUT /v1/courses/{id}` → Update course information  
- `DELETE /v1/courses/{id}` → Delete course  

### Enrollments
- `POST /v1/enrollments` → Enroll student in course  
- `DELETE /v1/enrollments/{studentId}/{courseId}` → Unenroll student from course  
- `GET /v1/enrollments/{studentId}/{courseId}` → Check if student is enrolled in course  


---

## 🛠️ Technologies

- ☕ **Java SE**
- 🌱 **Spring Boot**
- 🐘 **PostgreSQL**
- 🔗 **JDBC / JdbcTemplate**
- 📦 **Gradle**


---

## 📖 How to Run

Clone the repository:

git clone https://github.com/nicat-hemzeyev/course-management-jdbc.git

Configure .env with your database credentials.

Run the application:

./gradlew bootRun

Access API at http://localhost:5643/v1/...

---

## 📌 Notes

Ensure PostgreSQL is running and database course_db is created.

enrolment_date column is defined as TIMESTAMP DEFAULT CURRENT_TIMESTAMP to auto-fill enrollment time.

.env file should be added to .gitignore to keep credentials secure.

--- 

## 👨‍💻 Author

Developed by Nijat — aspiring Java backend developer, focusing on Spring Boot, PostgreSQL, and modular project design.
