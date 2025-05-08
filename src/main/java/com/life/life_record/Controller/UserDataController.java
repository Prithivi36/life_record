package com.life.life_record.Controller;

import com.life.life_record.Entity.UserData;
import com.life.life_record.Entity.Record;
import com.life.life_record.Service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserDataController {

    @Autowired
    private UserDataService userDataService;

    @PostMapping
    public String saveUser(@RequestBody UserData userData) {
        return userDataService.saveUser(userData);
    }

    @GetMapping("/{id}")
    public UserData getUser(@PathVariable String id) {
        return userDataService.getUser(id);
    }
    @PatchMapping("/{id}/hosp/{hid}")
    public String makeD(@PathVariable String id,@PathVariable String hid){
        return userDataService.makeDoc(id, hid);
    }
    @PutMapping("/{id}")
    public String updateUser(@PathVariable String id, @RequestBody UserData userData) {
        return userDataService.updateUser(id, userData);
    }

    @GetMapping("/{id}/records/recent")
    public List<Record> getRecentRecords(@PathVariable String id) {
        return userDataService.recentRecord(id);
    }

    @GetMapping("/{id}/records/all")
    public List<Record> getAllRecords(@PathVariable String id) {
        return userDataService.allRecord(id);
    }

    @GetMapping("/{id}/records/followup")
    public List<Record> getFollowupRecords(@PathVariable String id) {
        return userDataService.followup(id);
    }

    @GetMapping("/id/mail/{email}")
    public String getIdByMail(@PathVariable String email) {
        return userDataService.findBymail(email);
    }

    @GetMapping("/{id}/records/completed")
    public List<Record> getCompletedRecords(@PathVariable String id) {
        return userDataService.completed(id);
    }
} 