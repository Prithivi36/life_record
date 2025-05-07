package com.life.life_record.Service;

import com.life.life_record.Entity.Record;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecordService {
    String saveRecord(Record record);
    Record getRecord(String id);
    String updateRecord(String id, Record record);
    String deleteRecord(String id);
    List<Record> getAllRecords();
    List<Record> getRecordsByDoctor(String doctorId);
    List<Record> getRecordsByHospital(String hospital);
    List<Record> getByUserId(String user_id);
}