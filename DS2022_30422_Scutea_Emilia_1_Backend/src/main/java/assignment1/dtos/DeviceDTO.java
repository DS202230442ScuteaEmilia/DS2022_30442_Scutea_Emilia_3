package assignment1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceDTO implements Serializable {
    @JsonProperty
    private Long id;

    @JsonProperty
    private String address;

    @JsonProperty
    private String description;

    @JsonProperty
    private Long user_id;

    @JsonProperty
    private Double maxHourlyEnergyCons;
}
