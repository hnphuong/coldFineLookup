package hnp.selenium.chromedriver.dto.response.chatGPT;

import lombok.Data;

@Data
public class Message {
    private String role;
    private String content;
}
