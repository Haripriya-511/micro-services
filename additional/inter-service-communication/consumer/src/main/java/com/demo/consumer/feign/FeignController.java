package com.demo.consumer.feign;


import lombok.AllArgsConstructor;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/feign")
public class FeignController {
    private final ProviderFeignClient feignClient;

    @GetMapping("/instance")
    public String getInstance(){
    return feignClient.getInstanceInfo();
    }
}
