package assignment1.mappers;

import assignment1.dtos.UserDTO;
import assignment1.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .age(user.getAge())
//                .roles(user.getRoles())
//                .devices(user.getDevices())
                .build();
    }

    public static User fromDTO(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .age(userDTO.getAge())
//                .roles(userDTO.getRoles())
//                .devices(userDTO.getDevices())
                .build();
    }
}
