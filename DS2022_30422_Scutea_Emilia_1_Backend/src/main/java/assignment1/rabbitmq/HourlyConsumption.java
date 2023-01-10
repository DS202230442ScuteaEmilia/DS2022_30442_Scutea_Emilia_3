package assignment1.rabbitmq;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class HourlyConsumption {
    private Long id;
    private Instant date;
    private Double energy;
}
