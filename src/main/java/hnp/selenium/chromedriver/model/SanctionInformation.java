package hnp.selenium.chromedriver.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@Document(collection = "sanction_information")
public class SanctionInformation extends BasicTable{
    @Field(value = "unique_key")
    private String uniqueKey;

    @Field(value = "license_plates")
    private String licensePlates;

    @Field(value = "type_vehicle")
    private String typeVehicle;

    @Field(value = "resource_original")
    private String resourceOriginal;

    @Field(value = "sanction_detail")
    private List<SanctionDetail> sanctionDetails;
}
