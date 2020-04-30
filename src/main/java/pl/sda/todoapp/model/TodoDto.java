package pl.sda.todoapp.model;

public class TodoDto {

    private String name;

    public TodoDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
