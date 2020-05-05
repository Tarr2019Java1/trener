package pl.sda.todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.todoapp.generator.TodoDtoGenerator;
import pl.sda.todoapp.service.TodoService;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping("/todos")
    public String todos(Model model) {

        model.addAttribute("todos", todoService.getAll());
        model.addAttribute("completed", todoService.getAllCompleted());

        return "todos";
    }

}
