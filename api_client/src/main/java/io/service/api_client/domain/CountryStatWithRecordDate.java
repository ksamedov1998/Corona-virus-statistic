package io.service.api_client.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CountryStatWithRecordDate {
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
    protected String id;
    protected String country_name;
    protected String total_cases;
    protected String new_cases;
    protected String active_cases;
    protected String total_deaths;
    protected String new_deaths;
    protected String total_recovered;
    protected String serious_critical;
    protected String region;
    protected String total_cases_per1m;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd kk:mm:ss[.[SSS][SS][S]]")
                            //2020-03-26 23:10:01.854
    private LocalDateTime record_date;
}
