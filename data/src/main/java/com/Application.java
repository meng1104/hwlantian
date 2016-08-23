package com;


import com.data.oldUser.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Service;

/**
 * Created by somebody on 2016/7/5.
 */

@SpringBootApplication
@EnableRedisHttpSession
@EnableRedisRepositories
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@ComponentScan(basePackages = {"com"})
public class Application implements CommandLineRunner {
   @Autowired
    private ServiceRedir serviceRedir;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //user->account
         //serviceRedir.getUserAll().stream().forEach(System.out::println);
        // serviceRedir.getUserAll().stream().forEach((User u) -> serviceRedir.saveAccount(u));

       //account
        serviceRedir.getAmountAll().stream().forEach(System.out::println);
        System.out.print(serviceRedir.getByphone("13149455156").toString());

        //deviaAdapter
      //  serviceRedir.getDeviceAll().stream().forEach(System.out::println);
    }
}
