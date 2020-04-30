package pl.sda.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.todoapp.generator.TodoDtoGenerator;

@Controller
public class TodoController {

    @RequestMapping("/todos")
    public String todos(Model model) {

        model.addAttribute("todos", TodoDtoGenerator.generateTodoDtoList(10));
        model.addAttribute("completed", TodoDtoGenerator.generateTodoDtoList(10));

        return "todos";
    }

}
