package com.goncodev.todolistbff.repositories;

import com.goncodev.todolistbff.repositories.entities.TodoTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoTaskRepository extends JpaRepository<TodoTask, Long> {
}
