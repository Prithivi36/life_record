package com.life.life_record.Repository;

import com.life.life_record.Entity.Record;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepo extends MongoRepository<Record,String> {
    List<Record> findByDoctor(String doctorId);
    List<Record> findByHospital(String hospital);
    List<Record> findByUserId(String user_id);
}
