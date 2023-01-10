package assignment1.repositories;

import assignment1.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
//    @Query(value = "SELECT * FROM  Device WHERE user.id = ?1")
    List<Device> findAllByUser(Long user_id);

    List<Device> findByUser_Id(Long user_id);

}
