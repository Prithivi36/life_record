package com.life.life_record.Service;

import com.life.life_record.Entity.Record;

@Service
public interface RecordService {
    String saveRecord(Record record);
}