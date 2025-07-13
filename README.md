🚲 BikeTrax
BikeTrax is a Java-based console application that manages customers and their bikes details using Core Java, OOP principles, and Hibernate ORM. It supports adding, updating, fetching, and deleting customer and bike details, with proper entity relationships and enum usage for type safety.

## 📌 Features

- 🏍️ Add and manage bikes (brand, model, type, registration, etc.)
- 👥 Link multiple bikes to a single customer (One-to-Many mapping)
- 🧑‍💼 Customer creation and lookup
- 🗃️ Persist data using Hibernate and JPA annotations
- 📦 Maven project structure for dependency management and build

---

## 🧱 Tech Stack

- **Language**: Java (Core + Hibernate)
- **ORM**: Hibernate (JPA annotations)
- **Build Tool**: Maven
- **Database**:MySQL
- **IDE**: Eclipse 

---
## 🗂️ Project Structure
com.biketrax
│
├── config # Hibernate configuration files
├── dto #  (BikeDto, CustomerDto)
├── entity# Entity classes(Bike,Coustomer)
├── enums # Enums for brand, model, type, etc.
├── exception # 
├── service 
├── service.imp # Implementation of business logic
├── util # Input and validation utilities
├── config # Hibernate configuration files
└── Run.java # Application entry point

## Dependencies (in pom.xml)
- **hibernate-core
- **mysql-connector-java 
- **javax.persistence
- **junit (optional for testing)

## Pritam Mandal ##
GitHub: PRITAMMANDAL9
