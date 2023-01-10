package assignment1.entities;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class DeviceEnergyConsumption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant timestamp;

    private Double consumption;


    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;
}
