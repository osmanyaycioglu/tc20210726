package com.training.rest.client.restclient;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class RestclientApplication implements ApplicationRunner {

    public static void main(final String[] args) {
        SpringApplication.run(RestclientApplication.class,
                              args);
    }

    @Override
    public void run(final ApplicationArguments argsParam) throws Exception {
        Random randomLoc = new SecureRandom();
        Person personLoc = new Person();
        personLoc.setUsername("osman" + randomLoc.nextLong());
        personLoc.setName("osman" + randomLoc.nextLong());
        personLoc.setSurname("yaycıoğlu");
        personLoc.setHeight(200);
        personLoc.setWeight(95);

        RestTemplate rt = new RestTemplate();
        String result = rt.postForObject("http://127.0.0.1:8080/eetraining/rest/api/v1/person/provision/add",
                                         personLoc,
                                         String.class);
        System.out.println(result);

    }

}
