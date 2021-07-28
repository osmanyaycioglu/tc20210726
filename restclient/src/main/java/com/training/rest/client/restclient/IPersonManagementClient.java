package com.training.rest.client.restclient;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "personmanagement", url = "http://127.0.0.1:8080/eetraining/rest")
@RequestMapping("/api/v1/person/provision")
public interface IPersonManagementClient {

    @PostMapping("/add")
    public String add(@RequestBody final Person person);

    @GetMapping("/getall")
    public List<Person> getall();

}
