package io.service.api_client.service.Implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.service.api_client.domain.*;
import io.service.api_client.service.CountryService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImp  implements CountryService {
    private WebClientImp webClient;
    private Properties properties;
    private ObjectMapper objectMapper;

    public CountryServiceImp(WebClientImp webClient, Properties properties, ObjectMapper objectMapper) {
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

    @Override
    @SneakyThrows
    public CountryHistory getCountryDataByDate(String country) {
        String data=  webClient.getWebClient().get()
                .uri(UriComponentsBuilder.
                        fromUri(URI.create(properties.getCountryHistory()))
                        .queryParam("country",country)
                        .build().toUri())
                .retrieve()
                .bodyToMono(String.class)
                .block();

        CountryHistory countryHistory =objectMapper.readValue(data, CountryHistory.class);

        countryHistory.setLastestData(sumStatPerDay(countryHistory));
        return countryHistory;
    }

    private static CountryStatWithRecordDate[] sumStatPerDay(CountryHistory history){
        List<CountryStatWithRecordDate> countyStat= Arrays.stream(history.getLastestData()).collect(Collectors.toList());
        CountryStatWithRecordDate todayData;
        CountryStatWithRecordDate comparedDate;
        for(int i=0,j=1;i<countyStat.size() && j<countyStat.size();){
            todayData=countyStat.get(i);
            comparedDate=countyStat.get(j);
            if(todayData.getRecord_date().until(comparedDate.getRecord_date(),ChronoUnit.DAYS)==0){

                todayData.setActive_cases(todayData.getActive_cases()+comparedDate.getActive_cases());

                todayData.setNew_cases(todayData.getNew_cases()+comparedDate.getNew_cases());

                todayData.setNew_deaths(todayData.getNew_deaths()+comparedDate.getNew_deaths());

                todayData.setSerious_critical(todayData.getSerious_critical()+comparedDate.getSerious_critical());

                todayData.setTotal_cases(todayData.getTotal_cases()+comparedDate.getTotal_cases());

                todayData.setTotal_cases_per1m(todayData.getTotal_cases_per1m()+comparedDate.getTotal_cases_per1m());

                todayData.setTotal_deaths(todayData.getTotal_deaths()+comparedDate.getTotal_deaths());

                todayData.setTotal_recovered(todayData.getTotal_recovered()+comparedDate.getTotal_recovered());

                todayData.setRecord_date(comparedDate.getRecord_date());

                countyStat.remove(i+1);
                j++;
            }else{
                i++;
                j++;
            }
        }
        return  countyStat.stream().toArray(CountryStatWithRecordDate[]::new);
    }


}
