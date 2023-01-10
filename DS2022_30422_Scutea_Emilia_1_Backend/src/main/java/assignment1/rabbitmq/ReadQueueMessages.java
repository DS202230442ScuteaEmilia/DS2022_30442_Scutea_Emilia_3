package assignment1.rabbitmq;

import assignment1.entities.Device;
import assignment1.entities.DeviceEnergyConsumption;
import assignment1.services.DeviceEnergyConsumptionService;
import assignment1.services.DeviceService;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;
import java.time.Instant;

@Component
@RequiredArgsConstructor
public class ReadQueueMessages {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private DeviceEnergyConsumptionService deviceEnergyConsumptionService;

    public void readMessages() throws Exception, InterruptedException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("goose-01.rmq2.cloudamqp.com");
        factory.setUsername("dazlwzky");
        factory.setPassword("PqiBcwwudGOs6autNeiPsg1vOMKSrRVY");
        factory.setPort(5672);
        factory.setUri("amqps://dazlwzky:PqiBcwwudGOs6autNeiPsg1vOMKSrRVY@goose.rmq2.cloudamqp.com/dazlwzky");


        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();


        channel.queueDeclare("DS_QUEUE", true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {

            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);

            System.out.println(" [x] Received '" + message + "'");
            try {
                Thread.sleep(8000);
                convert(message);
                Thread.sleep(8000);
            } catch (InterruptedException | ParseException e) {
                throw new RuntimeException(e);
            }
        };
        channel.basicConsume("DS_QUEUE", true, deliverCallback, consumerTag -> {});
    }

    public void convert(String message) throws InterruptedException, ParseException {
        System.out.println(" IN CONVERT" + message + "'");

        String getMessage = message.substring(18, message.length() - 1);
        String[] getData = getMessage.split(",");

        String[] splitId = getData[0].split("=");
        String[] splitDate = getData[1].split("=");
        String[] splitEnergy = getData[2].split("=");

        Device device = deviceService.findById(Long.valueOf(splitId[1]));

        DeviceEnergyConsumption deviceEnergyConsumption = DeviceEnergyConsumption.builder()
                .device(device)
                .consumption(Double.parseDouble(splitEnergy[1]))
                .timestamp(Instant.parse(splitDate[1]))
                .build();
        deviceEnergyConsumptionService.save(deviceEnergyConsumption);
    }
}
