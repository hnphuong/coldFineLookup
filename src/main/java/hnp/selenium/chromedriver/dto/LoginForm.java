package hnp.selenium.chromedriver.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter
public class LoginForm {
    @NotNull(message = "username can't empty!")
    private String username;

    @NotNull(message = "password can't empty!")
    private String password;
}
