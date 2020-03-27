package io.service.api_client.service.Implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.service.api_client.domain.*;
import io.service.api_client.service.CountryService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

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

        countryHistory.setLastestData(splitDataPerDay(countryHistory));
        return countryHistory;
    }

    private static CountryStatWithRecordDate[] splitDataPerDay(CountryHistory history){
        List<CountryStatWithRecordDate> countyStat= new ArrayList<>();
        CountryStatWithRecordDate d1;
        CountryStatWithRecordDate d2;

        for(int i=0;i<history.getLastestData().length-1;i++){
            d1=history.getLastestData()[i];
            d2=history.getLastestData()[i+1];
            if(d2.getRecord_date().truncatedTo(DAYS).until(d1.getRecord_date().truncatedTo(DAYS),DAYS)!=0){
                countyStat.add(d1);
            }
        }
        return  countyStat.stream().toArray(CountryStatWithRecordDate[]::new);
    }


}
