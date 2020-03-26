package io.service.api_client.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TotalStatistic {
    /*
    * {
   "total_cases":"478,331",
   "total_deaths":"21,524",
   "total_recovered":"114,833",
   "new_cases":"7,363",
   "new_deaths":"246",
   "statistic_taken_at":"2020-03-26 09:59:06"
}
    * */

    @JsonProperty(value = "total_cases")
    String totalCases;

    @JsonProperty(value = "total_deaths")
    String total_deaths;

    @JsonProperty(value = "total_recovered")
    String total_recovered;

    @JsonProperty(value = "new_deaths")
    String new_deaths;

    @JsonProperty(value = "statistic_taken_at")
    String statistic_taken_at;

}
