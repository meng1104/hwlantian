package com.data.oldUser;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

/**
 * Created by somebody on 2016/8/3.
 */
@Component
@Configuration
@EnableMongoRepositories(basePackages = "com.data.oldUser", mongoTemplateRef = UserMongoConfig.templateName)
public class UserMongoConfig {
    @Value("${useruri}")
    String uri;
    @Value("${userdatabase}")
    String database;
    static final String templateName = "userTemplate";

    @Bean(name = templateName)
    public MongoTemplate template() throws UnknownHostException {

        MongoClient client = new MongoClient(new MongoClientURI(uri));
        MongoDbFactory factory = new SimpleMongoDbFactory(client, database);
        MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(factory), new MongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return new MongoTemplate(factory, converter);
    }


}
