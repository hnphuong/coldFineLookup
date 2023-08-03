package hnp.selenium.chromedriver.dto.request;

import hnp.selenium.chromedriver.dto.response.chatGPT.Message;
import lombok.Data;

import java.util.List;

@Data
public class ChatGPTRequest {
    private String model;
    private List<Message> messages;
    private Double temperature;
}
