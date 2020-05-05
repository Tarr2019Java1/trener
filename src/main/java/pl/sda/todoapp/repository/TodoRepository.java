package pl.sda.todoapp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.todoapp.entity.Todo;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    List<Todo> getAllByCompleted(boolean completed);
}
