package assignment1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreationDTO implements Serializable {
    @JsonProperty("email")
    private String email;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("age")
    private Integer age;
}
