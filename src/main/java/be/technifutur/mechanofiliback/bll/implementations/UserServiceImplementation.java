package be.technifutur.mechanofiliback.bll.implementations;

import be.technifutur.mechanofiliback.bll.UserService;
import be.technifutur.mechanofiliback.dal.repositories.UserRepository;
import be.technifutur.mechanofiliback.dl.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation  implements UserService {

    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        if (userRepository.existsById(user.getId())) {
            throw new RuntimeException("id already exists");
        }
        userRepository.save(user);
        return user;
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateBaseUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setUsername(user.getUsername());
        existingUser.setRole(user.getRole());
        userRepository.save(existingUser);
    }

    @Override
    public void updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setUsername(user.getUsername());
        existingUser.setRole(user.getRole());
        existingUser.setComments(user.getComments());
        existingUser.setMechas(user.getMechas());
        userRepository.save(existingUser);
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
