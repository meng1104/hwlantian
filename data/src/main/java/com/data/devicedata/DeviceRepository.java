package com.data.devicedata;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by somebody on 2016/8/10.
 */
@Repository
public interface DeviceRepository extends MongoRepository<DeviceAdapter,String> {
}
