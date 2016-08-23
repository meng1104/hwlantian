package com.data.devicedata;

import com.data.newAccount.AccountMongoConfig;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

/**
 * Created by somebody on 2016/8/10.
 */
@Component
//@Configuration
@EnableMongoRepositories(basePackages = "com.data.devicedata", mongoTemplateRef = DeviceMonConf.templateName)
public class DeviceMonConf {
    @Value("${deviceuri}")
    String uri;
    @Value("${devicedatabase}")
    String database;
    static final String templateName = "deviceTemplate";

    @Bean(name = templateName)
    public MongoTemplate template() throws UnknownHostException {
        MongoClient client = new MongoClient(new MongoClientURI(uri));
        return new MongoTemplate(client, database);
    }
}
