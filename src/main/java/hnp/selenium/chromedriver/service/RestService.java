package hnp.selenium.chromedriver.service;

import hnp.selenium.chromedriver.dto.request.ChatGPTRequest;
import hnp.selenium.chromedriver.dto.response.ChatGPTResponse;

public interface RestService {
    ChatGPTResponse chatGPTRest(ChatGPTRequest request);
}
