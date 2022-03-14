package sb.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.HashMap;

@Document(indexName = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    private String id;

    @Field(name = "name",type = FieldType.Text)
    private String name;

    @Field(name = "surname",type = FieldType.Text)
    private String surname;

    @Field(name = "birthDay",type = FieldType.Date)
    private Date birthDay;

}
