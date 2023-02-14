package hnp.selenium.chromedriver.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Getter
@Setter
public class BasicTable implements Serializable {
    @Id
    @Field("_id")
    private ObjectId id;

    @CreatedBy
    @Field("created_by")
    private String createdBy;

    @CreatedDate
    @Field("created_date")
    private ZonedDateTime createdDate;

    @LastModifiedBy
    @Field("modified_by")
    private String modifiedBy;

    @LastModifiedDate
    @Field("modified_date")
    private ZonedDateTime modifiedDate;
}
