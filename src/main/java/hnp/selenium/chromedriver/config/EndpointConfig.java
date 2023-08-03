package hnp.selenium.chromedriver.config;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@ConfigurationProperties(prefix = "endpoint")
@Getter
@Setter
@Configuration
@Slf4j
public class EndpointConfig {
    private ChatGpt chatGpt;
    private long timeout;

    @Bean(name = "chatGptApiClient")
    public WebClient investmentToolApiClient() {
        log.info("getInvestmentToolApiUrl: {}", getChatGpt().baseUrl);
        return WebClient.builder().baseUrl(getChatGpt().baseUrl).build();
    }

    @Data
    public static class ChatGpt {
        String baseUrl;
        String completions;
    }
}
