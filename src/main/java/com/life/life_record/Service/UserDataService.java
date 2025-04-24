package com.life.life_record.Service;

import com.life.life_record.Entity.UserData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public interface UserDataService {
    String saveUser(UserData usrD);
    UserData getUser(String id);
}
