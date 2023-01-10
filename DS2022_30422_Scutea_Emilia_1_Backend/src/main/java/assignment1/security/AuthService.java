package assignment1.security;

import assignment1.entities.Role;
import assignment1.entities.User;
import assignment1.repositories.RoleRepository;
import assignment1.repositories.UserRepository;
import assignment1.security.dto.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder encoder;

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public void register(SignupRequest signUpRequest) {

        Optional<Role> role = roleRepository.findByName(signUpRequest.getRole());

        if (role.isPresent()) {
            User user = User.builder()
                    .username(signUpRequest.getUsername())
                    .password(encoder.encode(signUpRequest.getPassword()))
                    .email(signUpRequest.getEmail())
                    .age(signUpRequest.getAge())
                    .role(role.get())
                    .build();
            userRepository.save(user);
        }
        else{
            User user = User.builder()
                    .username(signUpRequest.getUsername())
                    .password(encoder.encode(signUpRequest.getPassword()))
                    .email(signUpRequest.getEmail())
                    .age(signUpRequest.getAge())
                    .build();
            userRepository.save(user);

        }


    }
}
