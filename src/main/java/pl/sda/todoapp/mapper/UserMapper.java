package pl.sda.todoapp.mapper;

import pl.sda.todoapp.entity.User;
import pl.sda.todoapp.model.UserDto;

public class UserMapper {

    public static UserDto mapEntityToDto(User user) {

        UserDto dto = new UserDto();
        dto.setUsername(user.getUsername());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());

        return dto;
    }
}