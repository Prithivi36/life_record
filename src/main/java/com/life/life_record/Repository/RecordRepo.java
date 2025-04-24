package com.life.life_record.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepo extends MongoRepository<Record,String> {
}
