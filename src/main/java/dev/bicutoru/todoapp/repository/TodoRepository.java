package dev.bicutoru.todoapp.repository;

import dev.bicutoru.todoapp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
