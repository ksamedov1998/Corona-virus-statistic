package io.service.api_client.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.service.api_client.domain.AllCountriesDataWrapper;
import io.service.api_client.domain.RestClientProperties;
import io.service.api_client.domain.SingleCountryInfo;
import io.service.api_client.domain.WebClientImp;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class WebServiceImp {
    @Autowired
    private  RestClientProperties properties;
    @Autowired
    private  WebClientImp webClient;
    @Autowired
    private  ObjectMapper objectMapper;

    @SneakyThrows
    public AllCountriesDataWrapper getAllCountriesInfo() {
       String data= webClient.getWebClient()
                .get()
                .uri(URI.create(properties.getAllCountryURL()))
                .retrieve().bodyToMono(String.class)
                .block();
        return objectMapper.readValue(data,AllCountriesDataWrapper.class);
    }

    @SneakyThrows
    public SingleCountryInfo getCountryInfo(String country) {
        String data=  webClient.getWebClient().get()
                .uri(UriComponentsBuilder.
                        fromUri(URI.create(properties.getSingleCountryURL()))
                        .queryParam("country",country)
                        .build().toUri())
                .retrieve()
                    .bodyToMono(String.class)
                .block();
        return objectMapper.readValue(data,SingleCountryInfo.class);
    }
}
