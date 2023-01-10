package assignment1.mappers;

import assignment1.dtos.DeviceDTO;
import assignment1.dtos.DeviceEnergyConsumptionDTO;
import assignment1.entities.Device;
import assignment1.entities.DeviceEnergyConsumption;

public class DeviceEnergyConsumptionMapper {
    public static DeviceEnergyConsumption fromDto(DeviceEnergyConsumptionDTO deviceEnergyConsumptionDTO){
        return DeviceEnergyConsumption.builder()
                .id(deviceEnergyConsumptionDTO.getId())
                .timestamp(deviceEnergyConsumptionDTO.getTimestamp())
                .consumption(deviceEnergyConsumptionDTO.getConsumption())
                .build();
    }

    public static DeviceEnergyConsumptionDTO toDto(DeviceEnergyConsumption device){
        return DeviceEnergyConsumptionDTO.builder()
                .id(device.getId())
                .timestamp(device.getTimestamp())
                .consumption(device.getConsumption())
                .device_id(device.getDevice().getId())
                .build();
    }
}
