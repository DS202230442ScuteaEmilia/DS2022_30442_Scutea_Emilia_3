package assignment1.mappers;

import assignment1.dtos.DeviceDTO;
import assignment1.entities.Device;
import assignment1.entities.DeviceEnergyConsumption;
import assignment1.entities.User;
import assignment1.repositories.UserRepository;
import assignment1.services.DeviceEnergyConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceMapper {
    @Autowired
    private DeviceEnergyConsumptionService energyConsService;
    @Autowired
    private UserRepository userRepository;

    private Optional<User> findUserOfDevice(DeviceDTO deviceDTO) {
        return userRepository.findById(deviceDTO.getUser_id());
    }

    public Device fromDto(DeviceDTO deviceDTO) {

        Optional<User> user = findUserOfDevice(deviceDTO);
        if(user.isPresent()){
            return Device.builder()
                    .id(deviceDTO.getId())
                    .address(deviceDTO.getAddress())
                    .description(deviceDTO.getDescription())
                    .user(user.get())
                    .maxEnergyConsumption(deviceDTO.getMaxHourlyEnergyCons())
                    .build();
        }
        else{
            return Device.builder()
                    .id(deviceDTO.getId())
                    .address(deviceDTO.getAddress())
                    .description(deviceDTO.getDescription())
                    .maxEnergyConsumption(deviceDTO.getMaxHourlyEnergyCons())
                    .build();
        }



    }

    public DeviceDTO toDto(Device device) {
        if (device.getUser() != null) {
            return DeviceDTO.builder()
                    .id(device.getId())
                    .address(device.getAddress())
                    .description(device.getDescription())
                    .user_id(device.getUser().getId())
                    .maxHourlyEnergyCons(device.getMaxEnergyConsumption())
                    .build();
        } else {
            return DeviceDTO.builder()
                    .id(device.getId())
                    .address(device.getAddress())
                    .description(device.getDescription())
                    .maxHourlyEnergyCons(device.getMaxEnergyConsumption())
                    .build();
        }

    }
}
