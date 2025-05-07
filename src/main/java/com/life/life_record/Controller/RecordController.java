package com.life.life_record.Controller;

import com.life.life_record.Entity.Record;
import com.life.life_record.Service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
@CrossOrigin(origins = "*")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @PostMapping
    public String saveRecord(@RequestBody Record record) {
        return recordService.saveRecord(record);
    }
    @GetMapping("/usr/{id}")
    public List<Record> getByUserId(@PathVariable String id) {
        return recordService.getByUserId(id);
    }
    @GetMapping("/{id}")
    public Record getRecord(@PathVariable String id) {
        return recordService.getRecord(id);
    }

    @PutMapping("/{id}")
    public String updateRecord(@PathVariable String id, @RequestBody Record record) {
        return recordService.updateRecord(id, record);
    }

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable String id) {
        return recordService.deleteRecord(id);
    }

    @GetMapping
    public List<Record> getAllRecords() {
        return recordService.getAllRecords();
    }

    @GetMapping("/doctor/{doctorId}")
    public List<Record> getRecordsByDoctor(@PathVariable String doctorId) {
        return recordService.getRecordsByDoctor(doctorId);
    }

    @GetMapping("/hospital/{hospital}")
    public List<Record> getRecordsByHospital(@PathVariable String hospital) {
        return recordService.getRecordsByHospital(hospital);
    }
} 