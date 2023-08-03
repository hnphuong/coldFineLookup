package hnp.selenium.chromedriver.dto.response;

import hnp.selenium.chromedriver.dto.response.chatGPT.Choice;
import hnp.selenium.chromedriver.dto.response.chatGPT.Usage;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChatGPTResponse {
    private String id;
    private String object;
    private Integer created;
    private String model;
    private List<Choice> choices;
    private Usage usage;
}
