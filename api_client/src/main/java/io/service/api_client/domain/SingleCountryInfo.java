package io.service.api_client.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
@ToString
public class SingleCountryInfo {
    /* {
    "country":"Azerbaijan",
    "latest_stat_by_country":[
      {
         .......
      }
   ]
}
    * */
    private String country;
    public CountyLatestData[] latest_stat_by_country;

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public static class CountyLatestData {
        /*
        * "id":"171481",
         "country_name":"Azerbaijan",
         "total_cases":"87",
         "new_cases":"15",
         "active_cases":"76",
         "total_deaths":"1",
         "new_deaths":"",
         "total_recovered":"10",
         "serious_critical":"6",
         "region":null,
         "total_cases_per1m":"9",
         "record_date":"2020-03-24 14:10:02.334"
        * */
        private String id;
        private String country_name;
        private String total_cases;
        private String new_cases;
        private String active_cases;
        private String total_deaths;
        private String new_deaths;
        private String total_recovered;
        private String serious_critical;
        private String region;
        private String total_cases_per1m;
        private String record_date;
    }

}
