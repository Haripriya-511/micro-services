package com.demo.consumer.httpinterfaces;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpConfig {
//    @Bean
//    @LoadBalanced
//    public WebClient.Builder webClient(){
//        return WebClient.builder();
//    }
    @Bean
    public ProviderApi providerApi(WebClient.Builder builder){
        WebClient webClient=builder
                .baseUrl("http://provider")
                .build();
        WebClientAdapter adapter=WebClientAdapter.create(webClient);
        HttpServiceProxyFactory factory=HttpServiceProxyFactory.builderFor(adapter).build();

        ProviderApi service= factory.createClient(ProviderApi.class);
        return service;

    }
}
