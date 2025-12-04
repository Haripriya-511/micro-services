package com.demo.consumer.httpinterfaces;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/http-interface")
@AllArgsConstructor
public class HttpInterfacesController {
    private final ProviderApi providerApi;
    @GetMapping("/instance")
    public String getInstanceDetails(){
        return providerApi.getInstanceInfo();
    }

}
