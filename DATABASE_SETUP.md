# Database configuration - SpongeStack API

This application supports MYSQL databases using Spring Boot profile.

## Mysql Config

### Prerequisites
1. Mysql installed and running
2. Database `spongestack` created 
3. User with proper permissions

### Create Database
```sql
CREATE DATABASE spongestack CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER 'spongestack'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON spongestack.* TO 'spongestack'@'localhost';
FLUSH PRIVILEGES;
```

### Customize configuration
Edit `src/main/resources/application-mysql.properties`:
- Change `spring.datasource.username` y `spring.datasource.password`
- Adjust `spring.datasource.url` if your MYSQL isn't at localhost:3306

## Usage
```bash
mvn spring-boot:run


## Important notes

- **MySQL**: Data persists between restarts.
- **MySQL**: `ddl-auto=update` (preserves existing data)
