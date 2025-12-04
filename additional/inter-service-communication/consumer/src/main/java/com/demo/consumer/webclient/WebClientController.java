package com.demo.consumer.webclient;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/web")
@AllArgsConstructor
public class WebClientController {
    private ProviderWebClient webClient;


    @GetMapping("/instance")
    public Mono<String> getIsnatne(){
        return webClient.getInstanceInfo();

    }
}
