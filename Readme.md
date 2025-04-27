# TODO's List App

This is a simple Todo API designed to apply study concepts like security, databases, containerization, and more. The goal is to keep it straightforward, focusing on simplicity while including annotations to clarify the logic.

Key decisions made for this project:
1. **Liquibase for database management**: Changes are applied using Liquibase to avoid rerunning scripts if the database becomes inconsistent (since it's a testing environment, this might happen).
   - All changesets are consolidated in a single changelog file located at `src/resources/migrations/db.changelog-master.sql`. This approach keeps things simple, avoiding the need to separate changes into multiple files.
2. **Transaction annotations**: Ensures a "fail-safe" behavior; if an operation fails, no changes are committed to the database.
3. **Database setup via Docker**: The file `/db/docker-compose.yml` contains a simple configuration to run PostgreSQL in a container with a detached volume.
4. **Lack of Exception Handling**: Currently, there is no `ExceptionHandler`, so the application does not provide detailed logs for errors.