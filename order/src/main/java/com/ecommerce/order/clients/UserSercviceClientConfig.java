package com.ecommerce.order.clients;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestTemplateAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.io.IOException;
import java.net.URI;

@Configuration
public class UserSercviceClientConfig {
    @Bean
    public UserServiceClient userServiceClient(RestTemplate restTemplate) {

        RestTemplateAdapter adapter = RestTemplateAdapter.create(restTemplate);

        HttpServiceProxyFactory factory =
                HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(UserServiceClient.class);
    }

}
