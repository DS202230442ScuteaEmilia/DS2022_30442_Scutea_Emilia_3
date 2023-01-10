package assignment1.repositories;

import assignment1.entities.Role;
import assignment1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameAndAge(String username, Integer age);

//    Optional<User> findById(Long id);

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);

    Optional<User> findUserByRole(Role role);

    Optional<User> findById(Long id);

}
