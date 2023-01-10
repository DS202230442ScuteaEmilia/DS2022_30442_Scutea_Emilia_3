package assignment1.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Table
@Getter
@Setter
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private String description;

    @OneToMany
    private List<DeviceEnergyConsumption> deviceEnergyConsumption;

    private Double maxEnergyConsumption;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
