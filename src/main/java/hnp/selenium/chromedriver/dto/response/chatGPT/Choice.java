package hnp.selenium.chromedriver.dto.response.chatGPT;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Choice {
    private int index;
    private Message message;
    @JsonProperty(value = "finish_reason")
    private String finishReason;
}
