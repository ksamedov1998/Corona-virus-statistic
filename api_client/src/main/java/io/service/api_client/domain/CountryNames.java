package io.service.api_client.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CountryNames {

    /*
    * affected_countries[]
    * statistic_taken_at
    * */
    private String[] affected_countries;
    private String statistic_taken_at;
}
