package io.service.api_client.service.Implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.service.api_client.domain.AllCountriesDataWrapper;
import io.service.api_client.domain.CountryNames;
import io.service.api_client.domain.RestClientProperties;
import io.service.api_client.domain.WebClientImp;
import io.service.api_client.service.CountryService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class CountryServiceImp  implements CountryService {
    private WebClientImp webClient;
    private RestClientProperties properties;
    private ObjectMapper objectMapper;

    public CountryServiceImp(WebClientImp webClient, RestClientProperties properties, ObjectMapper objectMapper) {
        this.webClient = webClient;
        this.properties = properties;
        this.objectMapper = objectMapper;
    }


    @Override
    @SneakyThrows
    public String[] getAllAffectedCountryNames() {
        String data= webClient.getWebClient()
                .get()
                .uri(URI.create(properties.getCountryNames()))
                .retrieve().bodyToMono(String.class)
                .block();
        CountryNames countryNames=objectMapper.readValue(data, CountryNames.class);
        return Arrays.stream(countryNames.getAffected_countries())
                                        .sorted()
                                        .toArray(String[]::new);

    }
}
