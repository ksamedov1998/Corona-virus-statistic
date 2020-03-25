package io.service.api_client.domain;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientImp {
    private WebClient webClient;

    private RestClientProperties restClientProperties;

    public WebClientImp(RestClientProperties restClientProperties) {
        this.restClientProperties=restClientProperties;
        webClient=WebClient.builder()
                    .defaultHeader("x-rapidapi-host", restClientProperties.getHost())
                    .defaultHeader("x-rapidapi-key", restClientProperties.getApiKey())
                    .build();
    }

    public WebClient getWebClient() {
        return webClient;
    }
}
