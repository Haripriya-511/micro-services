package com.demo.consumer.restclient;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {
    @Bean
    public RestClient restClient(RestClient.Builder builder){
        return builder.baseUrl("http://provider")
                .build();
    }
    @Bean
    @LoadBalanced
    public RestClient.Builder loadbalancedClientBuilder(){
        return RestClient.builder();
    }
}
