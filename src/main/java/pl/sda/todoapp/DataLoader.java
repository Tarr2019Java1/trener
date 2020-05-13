package pl.sda.todoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.sda.todoapp.entity.Todo;
import pl.sda.todoapp.entity.User;
import pl.sda.todoapp.repository.TodoRepository;
import pl.sda.todoapp.repository.UserRepository;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user = new User("jnowak", passwordEncoder.encode("123456"), "Jan", "Nowak");
        userRepository.save(user);

        for (int i = 1; i <= 15; i++) {
            insertTodo(i, false, user);
            insertTodo(i, true, user);
        }
    }

    private void insertTodo(int index, boolean completed, User user) {
        Todo todo = new Todo();
        todo.setName("Zadanie " + index);
        todo.setCompleted(completed);
        todo.setUser(user);

        todoRepository.save(todo);
    }
}
