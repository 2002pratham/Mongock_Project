package entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Inherited;

@Document(collection = "users")
@RequiredArgsConstructor
@Getter
@Setter
public class User {
    @Id
    private ObjectId id;
    private String name;
    private String email;
}
