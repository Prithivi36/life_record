package com.life.life_record.Repository;

import com.life.life_record.Entity.UserData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepo extends MongoRepository<UserData,String> {
}
