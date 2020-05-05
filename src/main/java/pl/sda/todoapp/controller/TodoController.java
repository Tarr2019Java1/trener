package pl.sda.todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.todoapp.entity.Todo;
import pl.sda.todoapp.generator.TodoDtoGenerator;
import pl.sda.todoapp.mapper.TodoMapper;
import pl.sda.todoapp.model.TodoDto;
import pl.sda.todoapp.service.TodoService;

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

}
