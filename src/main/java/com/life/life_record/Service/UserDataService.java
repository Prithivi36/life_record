package com.life.life_record.Service;

import com.life.life_record.Entity.UserData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public interface UserDataService {
    String saveUser(UserData usrD);
    UserData getUser(String id);
    String updateUser(String id,UserData data);
    List<Record> recentRecord(String id);
    List<Record> allRecord(String id);
    List<Record> followup(String id);
    List<Record> completed(String id);
}
