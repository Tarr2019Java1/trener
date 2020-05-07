package pl.sda.todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.sda.todoapp.entity.Todo;
import pl.sda.todoapp.generator.TodoDtoGenerator;
import pl.sda.todoapp.mapper.TodoMapper;
import pl.sda.todoapp.model.TodoDto;
import pl.sda.todoapp.service.TodoService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping("/todos")
    public String todos(Model model) {

        List<Todo> todos = todoService.getAll();
        List<Todo> completed = todoService.getAllCompleted();

        List<TodoDto> dtos = TodoMapper.mapEntityToDto(todos);
        List<TodoDto> completedDtos = TodoMapper.mapEntityToDto(completed);

        model.addAttribute("todos", dtos);
        model.addAttribute("completed", completedDtos);

        return "todos";
    }

    @ResponseBody
    @RequestMapping(value = "/todos/{name}", method = RequestMethod.POST)
    public ResponseEntity<?> addTodos(@PathVariable("name") String name) {

        Todo todo = todoService.addTodo(name);

        TodoDto dto = TodoMapper.mapEntityToDto(todo);

        return ResponseEntity.ok(dto);
    }

    @ResponseBody
    @RequestMapping(value = "/todos/{id}", method = RequestMethod.PUT, produces = MediaType.TEXT_PLAIN_VALUE)
    public String updateComplated(@PathVariable("id") Long id) {

        todoService.completeTodo(id);

        return "200 OK";
    }

}
