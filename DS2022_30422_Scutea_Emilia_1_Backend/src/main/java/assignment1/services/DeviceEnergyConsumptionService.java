package assignment1.services;

import assignment1.dtos.DeviceDTO;
import assignment1.dtos.DeviceEnergyConsumptionDTO;
import assignment1.entities.Device;
import assignment1.entities.DeviceEnergyConsumption;
import assignment1.mappers.DeviceEnergyConsumptionMapper;
import assignment1.mappers.DeviceMapper;
import assignment1.repositories.DeviceEnergyConsumptionRepository;
import assignment1.websocket.WebSocketController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceEnergyConsumptionService {

    @Autowired
    private DeviceEnergyConsumptionRepository deviceEnergyConsumptionRepository;

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private WebSocketController webSocketController;

    @Autowired
    private UserService userService;


    public DeviceEnergyConsumption save(DeviceEnergyConsumption deviceEnergyConsumption) throws InterruptedException {
        DeviceEnergyConsumption consumption = deviceEnergyConsumptionRepository.save(deviceEnergyConsumption);
        checkExceededConsumption(deviceEnergyConsumption);
        return consumption;
    }

    private boolean checkDate(Instant instant, DeviceEnergyConsumption deviceEnergyConsumption){
        Integer hour = Integer.valueOf(deviceEnergyConsumption.getTimestamp().toString().substring(11,13));
        Integer day =  Integer.valueOf(deviceEnergyConsumption.getTimestamp().toString().substring(8,10));
        String month = deviceEnergyConsumption.getTimestamp().toString().substring(5,7);

        Integer dtoHour = Integer.valueOf(instant.toString().substring(11,13));
        Integer dtoDay =  Integer.valueOf(instant.toString().substring(8,10));
        String dtoMonth = instant.toString().substring(5,7);
        System.out.println("DTO " + hour + "/" + day +"/"+month + " CONSUMPTION " + dtoHour +"/"+dtoDay+"/"+dtoMonth);
        return hour.equals(dtoHour) && day.equals(dtoDay) && month.equals(dtoMonth);
    }
    public void checkExceededConsumption(DeviceEnergyConsumption deviceEnergyConsumption) throws InterruptedException {
        List<DeviceEnergyConsumptionDTO> dtos = getAllEnergyConsumptionsForDevice(deviceEnergyConsumption.getDevice().getId());

        Double hourlyConsumption = 0.0;
        System.out.println("Initialized hourly consumption " + hourlyConsumption);

        for(DeviceEnergyConsumptionDTO consumption : dtos){
            if(checkDate(consumption.getTimestamp(), deviceEnergyConsumption)){
                hourlyConsumption += consumption.getConsumption();
                System.out.println("Hourly consumption " + hourlyConsumption);
            }
            else{
                int hour = Integer.parseInt(deviceEnergyConsumption.getTimestamp().toString().substring(11, 13));
                int dtoHour = Integer.parseInt(consumption.getTimestamp().toString().substring(11, 13));
                int minute = Integer.parseInt(deviceEnergyConsumption.getTimestamp().toString().substring(14, 16));
                System.out.println("hour " + hour + "  dto hour " + dtoHour);
                if(hour == dtoHour+1 && minute==0){
                    hourlyConsumption += consumption.getConsumption();
                    System.out.println("Last hourly consumption " + hourlyConsumption);
                    break;
                }
            }
        }

        if(hourlyConsumption > deviceEnergyConsumption.getDevice().getMaxEnergyConsumption()){
            System.out.println("SENT NOTIFICATION");
            Long userId = userService.getUserIdForDevice(deviceEnergyConsumption.getDevice().getId());
            webSocketController.sendNotification(String.valueOf(userId),String.valueOf(hourlyConsumption), deviceEnergyConsumption.getDevice().getId().toString(), deviceEnergyConsumption.getDevice().getMaxEnergyConsumption().toString());

        }
    }

    public DeviceEnergyConsumption createEnergyConsumption(Device device, Double consumption) {
        return DeviceEnergyConsumption.builder()
                .consumption(consumption)
                .timestamp(Instant.now())
                .device(device)
                .build();

    }

    public List<DeviceEnergyConsumptionDTO> getAllEnergyConsumptionsForDevice(Long device_id) {
        return deviceEnergyConsumptionRepository.findAllByDevice_IdOrderByTimestamp(device_id).stream()
                .map(DeviceEnergyConsumptionMapper::toDto)
                .collect(Collectors.toList());
    }

}