package hnp.selenium.chromedriver.service.impl;

import hnp.selenium.chromedriver.dto.request.ChatGPTRequest;
import hnp.selenium.chromedriver.dto.request.QuestionChatGPTRequest;
import hnp.selenium.chromedriver.dto.response.ChatGPTResponse;
import hnp.selenium.chromedriver.dto.response.chatGPT.Message;
import hnp.selenium.chromedriver.service.ChatGptService;
import hnp.selenium.chromedriver.service.RestService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ChatGptServiceImpl implements ChatGptService {
    RestService restService;

    @Override
    public ChatGPTResponse chatGPT(QuestionChatGPTRequest request) {
        return this.chatGPTResponse(request);
    }

    private ChatGPTResponse chatGPTResponse(QuestionChatGPTRequest request){
        ChatGPTRequest chatGPTRequest = new ChatGPTRequest();
        chatGPTRequest.setModel("gpt-3.5-turbo");
        chatGPTRequest.setTemperature(0.7);
        List<Message> messageList = new ArrayList<>();
        Message message = new Message();
        message.setContent(request.getQuestion());
        message.setRole("user");
        messageList.add(message);
        chatGPTRequest.setMessages(messageList);
        return restService.chatGPTRest(chatGPTRequest);
    }

    @Override
    public Message messageChatGPT(QuestionChatGPTRequest request) {
        ChatGPTResponse chatGPTResponse = this.chatGPTResponse(request);
        return Objects.requireNonNull(chatGPTResponse.getChoices().stream().findFirst().orElse(null)).getMessage();
    }
}
