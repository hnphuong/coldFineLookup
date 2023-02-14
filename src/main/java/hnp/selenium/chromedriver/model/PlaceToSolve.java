package hnp.selenium.chromedriver.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Getter
@Setter
public class PlaceToSolve implements Serializable {
    private static final long serialVersionUID = 2405172041950251807L;
    @Field(value = "name")
    private String name;

    @Field(value = "address")
    private String address;

    @Field(value = "phone")
    private String phone;
}
