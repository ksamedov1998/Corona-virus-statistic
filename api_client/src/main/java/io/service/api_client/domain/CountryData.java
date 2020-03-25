package io.service.api_client.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CountryData {

    private String country_name;
    private String region;
    private String cases;
    private String active_cases;
    private String new_cases;
    private String deaths;
    private String new_deaths;
    private String serious_critical;
    private String total_recovered;
    private String total_cases_per_1m_population;

}
