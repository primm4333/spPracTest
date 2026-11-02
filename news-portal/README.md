# Daily Brief - Java News Portal

A simple Spring Boot news website for the practical assessment.

## Features
- Browse all news categories.
- Select a category and view its headlines.
- A news item can belong to multiple categories (many-to-many).
- Open a headline to read the full article.
- Add reader comments to each article.
- Sample categories and news are inserted automatically on first run.

## Technology
- Java 17
- Spring Boot 3.4.5
- Spring MVC + Thymeleaf
- Spring Data JPA / Hibernate
- H2 for immediate local testing
- MySQL profile for MySQL
- Maven

## Run in IntelliJ IDEA Community Edition

1. Install a JDK 17 (or newer compatible JDK).
2. Open this folder in IntelliJ IDEA.
3. Allow IntelliJ to import the Maven project and download dependencies.
4. Open `NewsPortalApplication.java`.
5. Click the green Run icon next to `main`.
6. Visit http://localhost:8080

The default configuration uses an in-memory H2 database. No MySQL installation is needed to try the app. Data is reset when the application restarts.

H2 console: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:newsdb`
- Username: `sa`
- Password: leave blank

## Switch to MySQL

1. Install and start MySQL Server.
2. Create a database (or let the URL create it):

```sql
CREATE DATABASE news_portal;
```

3. Run the application with the `mysql` profile.

In IntelliJ: Run > Edit Configurations > select the application > add this to **Program arguments**:

```text
--spring.profiles.active=mysql
```

Set environment variables if your MySQL credentials differ:
- `DB_URL=jdbc:mysql://localhost:3306/news_portal`
- `DB_USERNAME=your_mysql_username`
- `DB_PASSWORD=your_mysql_password`

Default MySQL profile expects username `root` and an empty password if environment variables are not supplied. Change these to match your local installation.

## Main routes
- `GET /` - list categories
- `GET /category/{id}` - headlines in a category
- `GET /news/{id}` - full news item and comments
- `POST /news/{id}/comments` - add a comment

## Database relationships
- `news_categories`: join table for News <-> Category (many-to-many)
- `comments.news_id`: foreign key; one News -> many Comments

## Push to one Git repository

From the project folder:

```bash
git init
git add .
git commit -m "Build Java news portal"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/news-portal.git
git push -u origin main
```

Do not commit database passwords. Use environment variables for credentials.

## Notes for a practical-test submission
This is a focused demonstration implementation. For a production website, add authentication/authorization, CSRF protection (Spring Security), moderation, pagination, richer validation, and centralized error pages.
