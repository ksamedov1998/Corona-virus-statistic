package io.service.api_client.domain;

import io.service.api_client.config.YamlPropertyFactory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;



@Getter
@Setter
@NoArgsConstructor
@Component
@PropertySource(factory = YamlPropertyFactory.class,value = "classpath:restClientProperties.yml")
public class RestClientProperties{

    @Value("${client.URL.allCountry}")
    private  String  allCountryURL;

    @Value("${client.URL.singleCountry}")
    private  String  singleCountryURL;

    @Value("${client.host}")
    private String host;

    @Value("${client.apiKey}")
    private String apiKey;

}
