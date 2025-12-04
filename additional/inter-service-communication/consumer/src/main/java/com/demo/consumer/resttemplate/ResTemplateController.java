package com.demo.consumer.resttemplate;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/rs")
@AllArgsConstructor
public class ResTemplateController {

    private final RestTemplateClient restTemplateClient;

    @GetMapping("/instance")
    public String getInstance(){
        return restTemplateClient.getInstanceInfo();
    }
}
