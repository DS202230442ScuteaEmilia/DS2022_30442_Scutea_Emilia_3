package assignment1.controllers;

import assignment1.dtos.DeviceDTO;
import assignment1.dtos.DeviceEnergyConsumptionDTO;
import assignment1.dtos.UserDTO;
import assignment1.entities.DeviceEnergyConsumption;
import assignment1.entities.User;
import assignment1.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static assignment1.UrlMappings.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(USER)
public class UserController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping(USER_DEVICES)
    public List<DeviceDTO> getAllDevicesForUser(@PathVariable Long user_id){
        return deviceService.allDevicesForUser(user_id);
    }

    @PostMapping(ADD_ENERGY_CONSUMPTION)
    public ResponseEntity<?> addEnergyConsumption(@PathVariable Long device_id, @PathVariable Double energy) throws InterruptedException {
        deviceService.addEnergyConsumption(device_id, energy);
        return ResponseEntity.ok("Energy added");
    }

    @GetMapping(USER_CONSUMPTIONS)
    public List<DeviceEnergyConsumptionDTO> getAllConsumptionsForUser(@PathVariable Long user_id) {
        return deviceService.getAllConsumptionsForUser(user_id);
    }

    @PostMapping(CONSUMPTIONS_BY_DATE)
    public List<Double> getConsumptionsByDate(@PathVariable Long device_id, @RequestBody String date){
        return deviceService.getConsumptionsByDate(device_id,date);

    }
}
