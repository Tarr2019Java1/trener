package pl.sda.todoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.todoapp.entity.Todo;
import pl.sda.todoapp.repository.TodoRepository;

import java.util.List;

@Service("todoService")
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

//    @Autowired
//    public TodoServiceImpl(TodoRepository todoRepository) {
//        this.todoRepository = todoRepository;
//    }

    @Override
    public List<Todo> getAll() {
        return todoRepository.getAllByCompleted(false);
    }

    @Override
    public List<Todo> getAllCompleted() {
        return todoRepository.getAllByCompleted(true);
    }

    @Override
    public Todo addTodo(String name) {
        Todo todo = new Todo(name, false);
        return todoRepository.save(todo);
    }

    @Override
    public void completeTodo(Long id) {
        Todo todo = todoRepository.getById(id);

        if (todo != null) {
            todo.setCompleted(true);
            todoRepository.save(todo);
        }
    }
}
