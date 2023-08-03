package hnp.selenium.chromedriver.service.impl;

import hnp.selenium.chromedriver.config.EndpointConfig;
import hnp.selenium.chromedriver.dto.request.ChatGPTRequest;
import hnp.selenium.chromedriver.dto.response.ChatGPTResponse;
import hnp.selenium.chromedriver.service.RestService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RestServiceImpl implements RestService {
    EndpointConfig endpointConfig;
    static final String PREFIX = "RestServiceImpl_";

    @Override
    public ChatGPTResponse chatGPTRest(ChatGPTRequest request) {
        log.info(PREFIX + "chatGPT ChatGPTRequest ={}", request);
        return endpointConfig.investmentToolApiClient().post()
                .uri(uriBuilder -> uriBuilder
                        .path(endpointConfig.getChatGpt().getCompletions())
                        .build())
                .body(Mono.just(request), new ParameterizedTypeReference<>() {
                })
                .header("Authorization","Bearer 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")
                .exchangeToMono(this::handleChatGPTResponse)
                .timeout(Duration.ofMillis(endpointConfig.getTimeout()), Mono.empty())
                .block();
    }

    private Mono<ChatGPTResponse> handleChatGPTResponse(ClientResponse clientResponse) {
        if (clientResponse.statusCode().equals(HttpStatus.OK)) {
            return clientResponse.bodyToMono(ChatGPTResponse.class);
        }
        log.error(clientResponse.toString());
        return Mono.empty();
    }
}
