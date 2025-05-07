package com.life.life_record.Service.Impl;

import com.life.life_record.Entity.Record;
import com.life.life_record.Repository.RecordRepo;
import com.life.life_record.Service.RecordService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecordServiceImpl implements RecordService {

    private RecordRepo recordRepo;

    @Override
    public String saveRecord(Record record) {
        recordRepo.save(record);
        return "Record saved successfully";
    }

    @Override
    public Record getRecord(String id) {
        Optional<Record> record = recordRepo.findById(id);
        return record.orElse(null);
    }

    @Override
    public String updateRecord(String id, Record record) {
        Optional<Record> existingRecord = recordRepo.findById(id);
        if (existingRecord.isPresent()) {
            Record updatedRecord = existingRecord.get();
            updatedRecord.setTitle(record.getTitle());
            updatedRecord.setUserId(record.getUserId());
            updatedRecord.setFollowUp(record.isFollowUp());
            updatedRecord.setFollowUpDate(record.getFollowUpDate());
            updatedRecord.setDoctor(record.getDoctor());
            updatedRecord.setHospital(record.getHospital());
            updatedRecord.setSymptoms(record.getSymptoms());
            updatedRecord.setPrescriptions(record.getPrescriptions());
            updatedRecord.setDoctorNotes(record.getDoctorNotes());
            recordRepo.save(updatedRecord);
            return "Record updated successfully";
        }
        return "Record not found";
    }

    @Override
    public String deleteRecord(String id) {
        if (recordRepo.existsById(id)) {
            recordRepo.deleteById(id);
            return "Record deleted successfully";
        }
        return "Record not found";
    }

    @Override
    public List<Record> getAllRecords() {
        return recordRepo.findAll();
    }

    @Override
    public List<Record> getRecordsByDoctor(String doctorId) {
        return recordRepo.findByDoctor(doctorId);
    }

    @Override
    public List<Record> getRecordsByHospital(String hospital) {
        return recordRepo.findByHospital(hospital);
    }

    @Override
    public List<Record> getByUserId(String user_id) {
        return recordRepo.findByUserId(user_id);
    }
} 