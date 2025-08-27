# 🚀 Spring Boot MongoDB Migration with Mongock

This repository contains a **production-ready Spring Boot application** that demonstrates how to manage **database schema and data migrations** in **MongoDB** using **Mongock**.

It follows a **code-first migration strategy**, where migrations are written in Java and executed automatically at application startup.  
This ensures your **application code** and **database state** always stay in sync, preventing deployment issues. ✅

---
## Results Screenshot -
![image alt](https://github.com/2002pratham/Mongock_Project/blob/master/Screenshot%202025-08-28%20015323.png?raw=true)
![image alt](https://github.com/2002pratham/Mongock_Project/blob/master/Screenshot%202025-08-28%20015413.png?raw=true)
![image alt](https://github.com/2002pratham/Mongock_Project/blob/master/Screenshot%202025-08-28%20015506.png?raw=true)

## ✨ Features

- 🔹 **Database Initialization**: Inserts initial user data into MongoDB on first run.  
- 🔹 **Schema & Data Updates**: Handles multi-stage migrations seamlessly.  
- 🔹 **Safe Transactions**: Each migration is atomic and transactional (where supported).  
- 🔹 **Rollback Support**: Explicit rollback logic for safe recovery.  
- 🔹 **Dependency Management**: Uses a Maven BOM for version compatibility.  
- 🔹 **Auditing & History**: Mongock tracks all migrations in a dedicated collection.  

---

## 🛠️ Technologies Used

- ☕ **Java 21**  
- 🌱 **Spring Boot 3.5.5**  
- 🍃 **Spring Data MongoDB**  
- 🛠️ **Mongock 5.5.1**  
- 📦 **Maven**  
- ✨ **Lombok**  

---

## 📂 Project Structure

<details>
<summary>Click to expand</summary>

src
- └── main
- ├── java
- │ └── com
- │ └── example
- │ └── demo
- │ ├── changelog
- │ │ ├── Changelogs.java // Migration for initial data insertion
- │ │ └── UpdateUserNamesChangeLog.java // Migration for updating data
- │ └── MongockLearningApplication.java // Main Spring Boot application
- └── resources
- └── application.properties // Application and Mongock configuration


</details>

### **Getting Started**

#### **1. Prerequisites**

* Java Development Kit (JDK) 21
* Apache Maven
* A running MongoDB instance (either local or cloud-based)

#### **2. Configuration**

Update your `src/main/resources/application.properties` file with your MongoDB connection details.

```properties
spring.application.name=mongock-learning
spring.data.mongodb.uri=put your own uri
spring.data.mongodb.database=DemoDataBase

# Mongock configuration
mongock.migration-scan-package=com.example.demo.changelog
```

### 3. Building and Running

First, ensure all dependencies are resolved by running:

```bash
mvn clean install
```
Then, you can run the application directly from your IDE or via the command line:

```bash

mvn spring-boot:run
```
On startup, Mongock will automatically connect to the database, apply the pending migrations, and then start the application.
## ⚙️ How it Works

1. When the application starts, the **`@EnableMongock`** annotation triggers the Mongock runner.  
2. Mongock connects to the specified **MongoDB database**.  
3. It acquires a **distributed lock** to prevent concurrent migration attempts.  
4. It scans the `com.example.demo.changelog` package for all classes annotated with **`@ChangeUnit`**.  
5. For each new change unit, it creates a record in the **`mongockChangeLog`** collection and executes the **`@Execution`** method.  
6. If any part of the execution fails, Mongock will:  
   - attempt the **`@RollbackExecution`** method (if provided)  
   - throw a **MongockException**.  
7. Once all migrations are successfully completed, the **lock is released**, and the application proceeds with its normal startup.  

✅ This process ensures that your **database is in a consistent and correct state** before your application begins serving requests.



