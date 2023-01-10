package assignment1.security.dto;

import assignment1.entities.ERole;
import assignment1.entities.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignupRequest {
    private String username;
    private String email;
    private String password;
    private Integer age;
    private ERole role;
}
