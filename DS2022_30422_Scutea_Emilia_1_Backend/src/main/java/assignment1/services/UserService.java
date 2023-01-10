package assignment1.services;

import assignment1.dtos.DeviceDTO;
import assignment1.dtos.UserCreationDTO;
import assignment1.dtos.UserDTO;
import assignment1.entities.Device;
import assignment1.entities.ERole;
import assignment1.entities.Role;
import assignment1.entities.User;
import assignment1.mappers.UserMapper;
import assignment1.repositories.RoleRepository;
import assignment1.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private DeviceService deviceService;

    public List<UserDTO> findAll(){
        return userRepository.findAll().stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }

    public User findByID(Long id){
        return userRepository.findById(id).orElseThrow(() -> {
            LOGGER.error("User with id " + id + "  was not found in db");
            return new EntityNotFoundException("User with id "+ id + " does not exist");
        });
    }

    public UserDTO create(UserDTO userDTO){
        return UserMapper.toDTO(userRepository.save(UserMapper.fromDTO(userDTO)));
    }


    public UserDTO edit(UserDTO userDTO){
        User user = findByID(userDTO.getId());
        user.setAge(userDTO.getAge());
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        return UserMapper.toDTO(userRepository.save(user));
    }

    public boolean delete(Long user_id){
        User user = userRepository.findById(user_id).get();
        userRepository.delete(user);
        return userRepository.findById(user_id).isEmpty();
    }

    public void assignDevice(Long user_id, Long device_id){
        //set the user to the device
        User user = findByID(user_id);
        Device device = deviceService.findById(device_id);
        device.setUser(user);
        deviceService.save(device);

//        deviceService.addEnergyConsumption(device_id, 0L);
        // add the device to the devices list of the user
        List<Device> devices = user.getDevices();
        devices.add(device);
        user.setDevices(devices);
        userRepository.save(user);
    }

    public Long getUserIdForDevice(Long deviceId){
        List<User> users = userRepository.findAll();
        for(User user : users){
            List<Device> devices = user.getDevices();
            for(Device device: devices){
                if(device.getId().equals(deviceId)){
                    return user.getId();
                }
            }
        }
        return deviceId;
    }

    public User getAdmin() {
//        Role admin = roleRepository.findByName(ERole.ADMIN).get();
//        return UserMapper.toDTO(userRepository.findUserByRole(admin).get());
        return userRepository.findById(3L).get();
    }
}
