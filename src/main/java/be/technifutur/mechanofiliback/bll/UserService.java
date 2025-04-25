package be.technifutur.mechanofiliback.bll;

import be.technifutur.mechanofiliback.dl.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User saveUser(User user);
    User findUserById(Long id);
    List<User> findAllUsers();
    void updateBaseUser(Long id, User user);
    void updateUser(Long id, User user);
    void deleteUserById(Long id);
}
