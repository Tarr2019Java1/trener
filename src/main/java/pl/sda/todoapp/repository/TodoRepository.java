package pl.sda.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.sda.todoapp.entity.Todo;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> getAllByCompleted(boolean completed);

    Todo getById(Long id);
}
