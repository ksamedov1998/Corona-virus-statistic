package io.service.api_client.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

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
    public CountryStatWithRecordDate[] latest_stat_by_country;


}
