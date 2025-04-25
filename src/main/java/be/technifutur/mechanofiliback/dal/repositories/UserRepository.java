package be.technifutur.mechanofiliback.dal.repositories;

import be.technifutur.mechanofiliback.dl.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String userName);

    boolean existsByEmail(String email);

    boolean existsByUsername(String userName);
}
