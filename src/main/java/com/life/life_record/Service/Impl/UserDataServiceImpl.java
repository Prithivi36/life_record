package com.life.life_record.Service.Impl;

import com.life.life_record.Entity.DoctorBase;
import com.life.life_record.Entity.Emergency;
import com.life.life_record.Entity.UserData;
import com.life.life_record.Entity.Record;
import com.life.life_record.Repository.DoctorRepo;
import com.life.life_record.Repository.UserDataRepo;
import com.life.life_record.Service.UserDataService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserDataServiceImpl implements UserDataService {

    private UserDataRepo userDataRepo;
    private DoctorRepo doctorRepo;

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
            Emergency emergency = new Emergency();
            emergency.setName(data.getEmergency().getName());
            emergency.setPhone(data.getEmergency().getPhone());
            emergency.setRelation(data.getEmergency().getRelation());
            user.setEmergency(emergency);
            userDataRepo.save(user);
            return "User updated successfully";
        }
        return "User not found";
    }

    @Override
    public List<Record> recentRecord(String id) {
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
    public List<Record> allRecord(String id) {
        UserData user = getUser(id);
        return user != null ? user.getRecord() : List.of();
    }

    @Override
    public List<Record> followup(String id) {
        UserData user = getUser(id);
        if (user != null && user.getRecord() != null) {
            return user.getRecord().stream()
                    .filter(Record::isFollowUp)
                    .toList();
        }
        return List.of();
    }

    @Override
    public List<Record> completed(String id) {
        UserData user = getUser(id);
        if (user != null && user.getRecord() != null) {
            return user.getRecord().stream()
                    .filter(record -> !record.isFollowUp())
                    .toList();
        }
        return List.of();
    }

    @Override
    public String findBymail(String email) {
        UserData user = userDataRepo.findByEmail(email);
        return user.get_id();
    }
    public String makeDoc(String id,String hosp) {
        UserData user = getUser(id);
        if (user != null && user.getRecord() != null) {
            user.setDoc(true);
            userDataRepo.save(user);
            DoctorBase db = new DoctorBase();
            db.set_id(user.get_id());
            db.setName(user.getName());
            db.setHospital(hosp);

            doctorRepo.save(db);
            return "Doc made";
        }
        return "Doc not found";
    }
} 