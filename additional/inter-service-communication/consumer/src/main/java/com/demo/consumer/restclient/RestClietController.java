package com.demo.consumer.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api/rc")
public class RestClietController {
    @Autowired
    private ProviderRestClient restClient;

    @GetMapping("/instance")
    public String getInsatnce() {
        return restClient.getInsatnceInfo();
    }
}
