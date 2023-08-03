package hnp.selenium.chromedriver.service;

import hnp.selenium.chromedriver.dto.request.QuestionChatGPTRequest;
import hnp.selenium.chromedriver.dto.response.ChatGPTResponse;
import hnp.selenium.chromedriver.dto.response.chatGPT.Message;

public interface ChatGptService {
    ChatGPTResponse chatGPT(QuestionChatGPTRequest request);
    Message messageChatGPT(QuestionChatGPTRequest request);
}
