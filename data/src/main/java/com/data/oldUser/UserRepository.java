package com.data.oldUser;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by somebody on 2016/8/2.
 */
@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
