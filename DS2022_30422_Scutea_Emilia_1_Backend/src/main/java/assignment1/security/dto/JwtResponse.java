package assignment1.security.dto;

import assignment1.entities.ERole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtResponse {

    private String token;
    private Long id;
    private String username;
    private String email;
    private ERole role;
}
