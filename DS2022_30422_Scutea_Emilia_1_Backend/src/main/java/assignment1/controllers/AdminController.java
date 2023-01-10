package assignment1.controllers;

import assignment1.dtos.DeviceDTO;
import assignment1.dtos.UserCreationDTO;
import assignment1.dtos.UserDTO;
import assignment1.entities.User;
import assignment1.services.DeviceService;
import assignment1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static assignment1.UrlMappings.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(ADMIN)
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private DeviceService deviceService;

    @GetMapping(ALL_USERS)
    public List<UserDTO> allUsers() {
        return userService.findAll();
    }

    @PostMapping(CREATE_USER)
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        userService.create(userDTO);
        return ResponseEntity.ok("User created");
    }

    @PostMapping(EDIT_USER)
    public UserDTO editUser(@RequestBody UserDTO userDTO) {
        return userService.edit(userDTO);
    }

    @DeleteMapping(DELETE_USER)
    public ResponseEntity<String> deleteUser(@PathVariable Long user_id) {
        if (userService.delete(user_id)) {
            return ResponseEntity.ok("User deleted");
        }
        return ResponseEntity.badRequest().body("User not deleted.");
    }

    @GetMapping(ALL_DEVICES)
    public List<DeviceDTO> allDevices() {
        return deviceService.allDevices();
    }

    @PostMapping(CREATE_DEVICE)
    public DeviceDTO createDevice(@RequestBody DeviceDTO deviceDTO) {
        return deviceService.create(deviceDTO);
    }

    @PostMapping(EDIT_DEVICE)
    public DeviceDTO editDevice(@RequestBody  DeviceDTO deviceDTO) {
        return deviceService.edit(deviceDTO);
    }

    @DeleteMapping(DELETE_DEVICE)
    public ResponseEntity<String> deleteDevice(@PathVariable Long device_id) {
        if (deviceService.delete(device_id)) {
            return ResponseEntity.ok("Device deleted");
        }
        return ResponseEntity.badRequest().body("Device not dleeted");
    }

    @PostMapping(ASSIGN_DEVICE)
    public ResponseEntity<String> assignDeviceToUser(@PathVariable Long user_id, @PathVariable Long device_id){

        userService.assignDevice(user_id, device_id);
        return ResponseEntity.ok("Device added");

    }

    @GetMapping(GET_ADMIN)
    public User getAdministrator() {
        return userService.getAdmin();
    }
}
