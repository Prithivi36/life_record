package com.life.life_record.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "life_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserData {
    @Id
    private String _id;
    private String adhr;
    private String blood;
    private String dob;
    private boolean doc;
    private String email;
    private Emergency emergency;
    private String name;
    private String password;
    private String phone;
    List<Record> record;
}
