package com.data.newAccount;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by somebody on 2016/8/2.
 */
@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
    Optional<Account> findByPhone(String phone);
}
