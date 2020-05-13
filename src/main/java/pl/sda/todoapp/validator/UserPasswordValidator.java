package pl.sda.todoapp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.sda.todoapp.model.UserDto;

public class UserPasswordValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "valid.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "valid.passwordConfirm");

        UserDto dto = (UserDto) o;
        if (!dto.getPassword().equals(dto.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "valid.passwordConfirmDiff");
        }

        String firstName = dto.getFirstName();
        if (firstName.length() < 3 || firstName.length() > 25) {
            errors.rejectValue("firstName", "valid.firstNameLength");
        }
    }
}