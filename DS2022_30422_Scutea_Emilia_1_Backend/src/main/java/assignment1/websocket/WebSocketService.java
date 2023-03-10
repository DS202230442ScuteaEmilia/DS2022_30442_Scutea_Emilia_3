package assignment1.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {
    @Autowired
    private SimpMessagingTemplate template;

    public void processMsg(String userId, String cons, String id, String maxCons) {
        // pushing the data to the websocket
        this.template.convertAndSend("/topic", userId + " : Consumption " + cons + " for device with id " + id+ " exceeds maximum hourly consumption of " + maxCons);
    }
}
