package pl.sda.todoapp.mapper;

import pl.sda.todoapp.entity.Todo;
import pl.sda.todoapp.model.TodoDto;

import java.util.ArrayList;
import java.util.List;

public class TodoMapper {

    public static Todo mapDtoToEntity(TodoDto dto) {

        return null;
    }

    public static TodoDto mapEntityToDto(Todo entity) {

        TodoDto dto = new TodoDto(entity.getName());
        dto.setCreateDate(entity.getCreateDate());
        dto.setCloseDate(entity.getCloseDate());
        return null;
    }

    public static List<TodoDto> mapEntityToDto(List<Todo> entities) {

        List<TodoDto> dtos = new ArrayList<>();

        for (Todo todo : entities) {
            dtos.add(mapEntityToDto(todo));
        }

        return dtos;
    }
}
