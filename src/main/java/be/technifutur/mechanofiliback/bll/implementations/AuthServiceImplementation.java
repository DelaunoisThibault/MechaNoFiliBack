package be.technifutur.mechanofiliback.bll.implementations;

import be.technifutur.mechanofiliback.bll.AuthService;
import be.technifutur.mechanofiliback.dal.repositories.UserRepository;
import be.technifutur.mechanofiliback.dl.entities.User;
import be.technifutur.mechanofiliback.dl.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImplementation implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(User user) {
        if (userRepository.existsByEmail(user.getEmail()) || userRepository.existsByUsername(user.getUsername())) {

            throw new RuntimeException();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(UserRole.USER);
        userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(

                () -> new RuntimeException("")
        );
        if (!passwordEncoder.matches(password, user.getPassword())) {

            throw new RuntimeException();
        }
        return user;
    }
}
