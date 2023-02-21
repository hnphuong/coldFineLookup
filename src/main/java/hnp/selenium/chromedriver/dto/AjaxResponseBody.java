package hnp.selenium.chromedriver.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AjaxResponseBody {
    private String msg;
    private List<User> result;
}
