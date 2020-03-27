package io.service.api_client.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CountryHistory {

    private String country;

    @JsonProperty("stat_by_country")
    private CountryStatWithRecordDate[] lastestData;

}
