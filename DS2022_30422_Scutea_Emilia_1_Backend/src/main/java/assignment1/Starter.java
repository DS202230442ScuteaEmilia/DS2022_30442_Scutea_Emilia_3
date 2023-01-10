package assignment1;

import assignment1.entities.Device;
import assignment1.entities.ERole;
import assignment1.entities.Role;
import assignment1.entities.User;
import assignment1.rabbitmq.ReadQueueMessages;
import assignment1.websocket.WebSocketService;
import assignment1.repositories.DeviceRepository;
import assignment1.repositories.RoleRepository;
import assignment1.repositories.UserRepository;
import assignment1.security.AuthService;
import assignment1.security.dto.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Starter implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private ReadQueueMessages readQueueMessages;

    @Autowired
    private AuthService authService;

    @Autowired
    private WebSocketService webSocketService;

    private final boolean create = true;


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        if(create) {
            userRepository.deleteAll();
            roleRepository.deleteAll();

            for (ERole role : ERole.values()) {
                roleRepository.save(Role.builder().name(role).build());
            }

            authService.register(SignupRequest.builder()
                    .age(20)
                    .email("escutea@gmail.com")
                    .password("123456")
                    .username("emily1")
                    .role(ERole.USER)
                    .build());

            authService.register(SignupRequest.builder()
                    .age(20)
                    .email("escutea@yahoo.ro")
                    .password("123456")
                    .username("emily2")
                    .role(ERole.USER)
                    .build());

            authService.register(SignupRequest.builder()
                    .age(20)
                    .email("escutea@gmail.com")
                    .password("123456")
                    .username("admin1")
                    .role(ERole.ADMIN)
                    .build());

            User user1 = userRepository.findByUsername("emily1").get();

            Device device = Device.builder()
                    .address("Observatorului 34")
                    .description("My phone")
                    .user(user1)
                    .maxEnergyConsumption(25.0)
                    .build();
            device = deviceRepository.save(device);

            List<Device> devices = new ArrayList<>();
            devices.add(device);
            user1.setDevices(devices);
            userRepository.save(user1);

            User user2 = userRepository.findByUsername("emily2").get();

            Device device2 = Device.builder()
                    .address("Observatorului 34")
                    .description("My laptop")
                    .user(user2)
                    .maxEnergyConsumption(20.0)
                    .build();
            device2 = deviceRepository.save(device2);

            List<Device> devices2 = new ArrayList<>();
            devices2.add(device2);
            user2.setDevices(devices2);
            userRepository.save(user2);

            Device device3 = Device.builder()
                    .address("Ceahlau")
                    .description("Microunde")
                    .user(user1)
                    .maxEnergyConsumption(20.0)
                    .build();
            device3 = deviceRepository.save(device3);

            List<Device> devices3 = user1.getDevices();
            devices3.add(device3);
            user1.setDevices(devices3);
            userRepository.save(user1);


            Device device4 = Device.builder()
                    .address("Mihai Viteazu")
                    .description("Frigider")
                    .user(user2)
                    .maxEnergyConsumption(20.0)
                    .build();
            device4 = deviceRepository.save(device4);

            List<Device> devices4 = user2.getDevices();
            devices4.add(device4);
            user2.setDevices(devices4);
            userRepository.save(user2);
        }

        try {
            readQueueMessages.readMessages();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
