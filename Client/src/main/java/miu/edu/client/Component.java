package miu.edu.client;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@org.springframework.stereotype.Component
public class Component {

    @Bean
    public RestOperations restTemplate() {
        return new RestTemplate();
    }
}
