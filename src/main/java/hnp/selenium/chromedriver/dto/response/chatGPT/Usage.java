package hnp.selenium.chromedriver.dto.response.chatGPT;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usage {
    @JsonProperty(value = "prompt_tokens")
    private Integer promptTokens;
    @JsonProperty(value = "completion_tokens")
    private Integer completionTokens;
    @JsonProperty(value = "total_tokens")
    private Integer totalTokens;
}
