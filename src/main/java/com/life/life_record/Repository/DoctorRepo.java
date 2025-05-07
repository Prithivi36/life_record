package com.life.life_record.Repository;

import com.life.life_record.Entity.DoctorBase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends MongoRepository<DoctorBase,String> {
}
