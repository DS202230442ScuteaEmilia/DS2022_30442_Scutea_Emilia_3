package assignment1.dtos;

import lombok.*;

import java.time.Instant;

@Setter
@Getter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class DeviceEnergyConsumptionDTO {
    private Long id;
    private Instant timestamp;
    private Double consumption;
    private Long device_id;
}
