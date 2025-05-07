package com.life.life_record.Impl;

import com.life.life_record.Entity.RecordsStruct;
import com.life.life_record.Entity.UserData;
//import com.life.life_record.Entity.Record;
import com.life.life_record.Repository.UserDataRepo;
import com.life.life_record.Service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    private UserDataRepo userDataRepo;

    @Override
    public String saveUser(UserData usrD) {
        userDataRepo.save(usrD);
        return "User saved successfully";
    }

    @Override
    public UserData getUser(String id) {
        Optional<UserData> userData = userDataRepo.findById(id);
        return userData.orElse(null);
    }

    @Override
    public String updateUser(String id, UserData data) {
        Optional<UserData> existingUser = userDataRepo.findById(id);
        if (existingUser.isPresent()) {
            UserData user = existingUser.get();
            user.setName(data.getName());
            user.setEmail(data.getEmail());
            user.setPhone(data.getPhone());
            user.setBlood(data.getBlood());
            user.setDob(data.getDob());
            user.setAdhr(data.getAdhr());
            user.setEmergency1(data.getEmergency1());
            user.setEmergency2(data.getEmergency2());
            userDataRepo.save(user);
            return "User updated successfully";
        }
        return "User not found";
    }

    @Override
    public List<RecordsStruct> recentRecord(String id) {
        UserData user = getUser(id);
        if (user != null && user.getRecord() != null) {
            return user.getRecord().stream()
                    .sorted((r1, r2) -> r2.get_id().compareTo(r1.get_id()))
                    .limit(5)
                    .toList();
        }
        return List.of();
    }

    @Override
    public List<RecordsStruct> allRecord(String id) {
        UserData user = getUser(id);
        return user != null ? user.getRecord() : List.of();
    }

    @Override
    public List<RecordsStruct> followup(String id) {
        UserData user = getUser(id);
        if (user != null && user.getRecord() != null) {
            return user.getRecord().stream()
                    .filter(RecordsStruct::isFollowUp)
                    .toList();
        }
        return List.of();
    }

    @Override
    public List<RecordsStruct> completed(String id) {
        UserData user = getUser(id);
        if (user != null && user.getRecord() != null) {
            return user.getRecord().stream()
                    .filter(record -> !record.isFollowUp())
                    .toList();
        }
        return List.of();
    }
}