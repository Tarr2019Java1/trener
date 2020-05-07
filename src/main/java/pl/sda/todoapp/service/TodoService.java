package pl.sda.todoapp.service;

import org.springframework.stereotype.Service;
import pl.sda.todoapp.entity.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> getAll();

    List<Todo> getAllCompleted();

    Todo addTodo(String name);

    void completeTodo(Long id);
}
