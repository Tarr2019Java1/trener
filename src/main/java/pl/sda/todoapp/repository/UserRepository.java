package pl.sda.todoapp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.todoapp.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
