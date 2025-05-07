package com.life.life_record.Impl;

import com.life.life_record.Entity.RecordsStruct;
import com.life.life_record.Repository.RecordRepo;
import com.life.life_record.Service.RecordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecordServiceImpl implements RecordService {

    RecordRepo recordRepo;

    @Override
    public String saveRecord(RecordsStruct recordsStruct) {
        recordRepo.save(recordsStruct);
        return "Record saved successfully";
    }

    @Override
    public RecordsStruct getRecord(String id) {
        Optional<RecordsStruct> record = recordRepo.findById(id);
        return record.orElse(null);
    }

    @Override
    public String updateRecord(String id, RecordsStruct recordsStruct) {
        Optional<RecordsStruct> existingRecord = recordRepo.findById(id);
        if (existingRecord.isPresent()) {
            RecordsStruct updatedRecordsStruct = existingRecord.get();
            updatedRecordsStruct.setTitle(recordsStruct.getTitle());
            updatedRecordsStruct.setFollowUp(recordsStruct.isFollowUp());
            updatedRecordsStruct.setFollowUpDate(recordsStruct.getFollowUpDate());
            updatedRecordsStruct.setDoctor(recordsStruct.getDoctor());
            updatedRecordsStruct.setHospital(recordsStruct.getHospital());
            updatedRecordsStruct.setSymptoms(recordsStruct.getSymptoms());
            updatedRecordsStruct.setPrescriptions(recordsStruct.getPrescriptions());
            updatedRecordsStruct.setDoctorNotes(recordsStruct.getDoctorNotes());
            recordRepo.save(updatedRecordsStruct);
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
    public List<RecordsStruct> getAllRecords() {
        return recordRepo.findAll();
    }

    @Override
    public List<RecordsStruct> getRecordsByDoctor(String doctorId) {
        return recordRepo.findByDoctor(doctorId);
    }

    @Override
    public List<RecordsStruct> getRecordsByHospital(String hospital) {
        return recordRepo.findByHospital(hospital);
    }
}