package pl.sda.todoapp.generator;

import pl.sda.todoapp.model.TodoDto;

import java.util.ArrayList;
import java.util.List;

public class TodoDtoGenerator {

    public static List<TodoDto> generateTodoDtoList(int count) {

        List<TodoDto> todos = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            TodoDto dto = new TodoDto("Zadanie " + i);
            todos.add(dto);
        }

        return todos;
    }
}
