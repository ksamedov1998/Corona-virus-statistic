package io.service.api_client.domain;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientImp {
    private WebClient webClient;

    private Properties properties;

    public WebClientImp(Properties properties) {
        this.properties = properties;
        webClient=WebClient.builder()
                    .codecs(clientCodecConfigurer -> clientCodecConfigurer.defaultCodecs().maxInMemorySize(3000000))
                    .defaultHeader("x-rapidapi-host", properties.getHost())
                    .defaultHeader("x-rapidapi-key", properties.getApiKey())
                    .build();
    }

    public WebClient getWebClient() {
        return webClient;
    }
}
