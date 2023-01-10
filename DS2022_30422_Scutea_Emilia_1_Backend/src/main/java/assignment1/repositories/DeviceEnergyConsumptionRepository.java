package assignment1.repositories;

import assignment1.entities.DeviceEnergyConsumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceEnergyConsumptionRepository extends JpaRepository<DeviceEnergyConsumption, Long> {

    Optional<DeviceEnergyConsumption> findById(Long id);

    List<DeviceEnergyConsumption> findAllByDevice_IdOrderByTimestamp(Long device_id);
}
