package assignment1.services;

import assignment1.dtos.DeviceDTO;
import assignment1.dtos.DeviceEnergyConsumptionDTO;
import assignment1.entities.Device;
import assignment1.entities.DeviceEnergyConsumption;
import assignment1.mappers.DeviceMapper;
import assignment1.repositories.DeviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private DeviceEnergyConsumptionService deviceEnergyConsumptionService;

    @Autowired
    private DeviceMapper deviceMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public List<DeviceDTO> allDevices() {
        return deviceRepository.findAll().stream().map(deviceMapper::toDto).collect(Collectors.toList());
    }

    public Device save(Device device) {
        return deviceRepository.save(device);
    }

    public List<DeviceDTO> allDevicesForUser(Long user_id) {
        return deviceRepository.findByUser_Id(user_id).stream()
                .map(deviceMapper::toDto)
                .collect(Collectors.toList());
    }

    public Device findById(Long id) {
        return deviceRepository.findById(id)
                .orElseThrow(() -> {
                    LOGGER.error("Device with id " + id + "was not found in db");
                    return new EntityNotFoundException("Device with id " + id + " not found.");
                });
    }

    public boolean existsById(Long id) {
        return deviceRepository.existsById(id);
    }

    public DeviceDTO create(DeviceDTO deviceDTO) {
        //create new device

        Device device = deviceRepository.save(deviceMapper.fromDto(deviceDTO));
        System.out.println("cons is " + device.getMaxEnergyConsumption());
        System.out.println("dto " +  deviceDTO.getMaxHourlyEnergyCons());

//        // create new energy consumption
//        DeviceEnergyConsumption energyConsumption = deviceEnergyConsumptionService.createEnergyConsumption(device, 0.0);
//
//        //assign energy consumption to device
//        List<DeviceEnergyConsumption> consumptionList = new ArrayList<>();
//        consumptionList.add(energyConsumption);
//        device.setDeviceEnergyConsumption(consumptionList);
        // save device
        return deviceMapper.toDto(device);
    }

    public DeviceDTO edit(DeviceDTO deviceDTO) {
        Device device = findById(deviceDTO.getId());
        device.setAddress(deviceDTO.getAddress());
        device.setDescription(deviceDTO.getDescription());
        return deviceMapper.toDto(deviceRepository.save(device));
    }

    public boolean delete(Long device_id) {
        Device device = findById(device_id);
        deviceRepository.delete(device);
        return deviceRepository.findById(device.getId()).isEmpty();
    }

    public void addEnergyConsumption(Long device_id, Double consumption) throws InterruptedException {

        Device device = findById(device_id);
        DeviceEnergyConsumption deviceEnergyConsumption = deviceEnergyConsumptionService.createEnergyConsumption(device, consumption);

        deviceEnergyConsumption = deviceEnergyConsumptionService.save(deviceEnergyConsumption);
        List<DeviceEnergyConsumption> consumptionList = device.getDeviceEnergyConsumption();
        consumptionList.add(deviceEnergyConsumption);
        device.setDeviceEnergyConsumption(consumptionList);
        deviceRepository.save(device);
    }

    public List<DeviceEnergyConsumptionDTO> getAllConsumptionsForUser(Long user_id) {
        List<DeviceDTO> deviceDTOS = allDevicesForUser(user_id);
        List<DeviceEnergyConsumptionDTO> energyConsumptionDTOS = new ArrayList<>();

        for (DeviceDTO deviceDTO : deviceDTOS) {
            List<DeviceEnergyConsumptionDTO> energyList = deviceEnergyConsumptionService.getAllEnergyConsumptionsForDevice(deviceDTO.getId());
            energyConsumptionDTOS.addAll(energyList);
        }
        return energyConsumptionDTOS;
    }

    private boolean checkDay(Instant date, String str) {
        return date.toString().substring(8,10).equals(str.substring(8, 10));
    }

    private boolean checkMonth(Instant date, String str) {
        return date.toString().substring(5, 7).equals(parseMonth(str.substring(4, 7)));
    }

    private String parseMonth(String str) {
        return switch (str) {
            case "Jan" -> "01";
            case "Feb" -> "02";
            case "Mar" -> "03";
            case "Apr" -> "04";
            case "May" -> "05";
            case "Jun" -> "06";
            case "Jul" -> "07";
            case "Aug" -> "08";
            case "Sep" -> "09";
            case "Oct" -> "10";
            case "Nov" -> "11";
            case "Dec" -> "12";
            default -> "";
        };
    }

    private boolean checkYear(Instant date, String str) {
        return date.toString().substring(0, 3).equals(str.substring(11, 14));
    }

    private boolean checkDate(Instant date, String str) {
        return checkDay(date, str) && checkMonth(date, str) && checkYear(date, str);
    }

    public List<Double> getConsumptionsByDate(Long device_id, String date) {
        List<DeviceEnergyConsumptionDTO> energyConsumptionDTOS = deviceEnergyConsumptionService.getAllEnergyConsumptionsForDevice(device_id);
        return filterByDate(energyConsumptionDTOS, date);
    }

    private Integer getHour(Instant date){
        return Integer.valueOf(date.toString().substring(11,13));
    }

    private List<Double> filterByDate(List<DeviceEnergyConsumptionDTO> energyConsumptionDTOS, String date) {
        List<DeviceEnergyConsumptionDTO> consumptionDTOS = new ArrayList<>();
        List<Double> finalList = new ArrayList<Double>(Collections.nCopies(24, 0.0));
        for (DeviceEnergyConsumptionDTO dto : energyConsumptionDTOS) {
            if (checkDate(dto.getTimestamp(), date)) {
                consumptionDTOS.add(dto);
            }
        }
        for(DeviceEnergyConsumptionDTO dto: consumptionDTOS){
            int hour = getHour(dto.getTimestamp());
            Double currentSum = finalList.get(hour);
            currentSum += dto.getConsumption();
            finalList.remove(hour);
            finalList.add(hour, currentSum);
        }
        return finalList;
    }
}
