package pl.sda.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/jakies/zagniezdzenia/kilka/wiecej")
@Controller
public class MainController {

    @RequestMapping("/index")
    public String index(Model model) {

        return "index";
    }

    @RequestMapping("/index2")
    public String index2() {
        return "";
    }

}
