package io.service.api_client.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Component
public class AllCountriesDataWrapper {
    private CountryData[] countries_stat;
    private String statistic_taken_at;
//    public AllCountriesDataWrapper organizeData() {
//        Map<String,CountryData> countryData= new HashMap<>();
//        for(CountryData data:covid19Stats){
//            if(countryData.containsKey(data.getCountry_name())){
//                data.set(data.getConfirmed()
//                                        +countryData.get(data.getCountry()).getConfirmed());
//                data.setDeaths(data.getDeaths()
//                        +countryData.get(data.getCountry()).getDeaths());
//                data.setRecovered(data.getRecovered()
//                        +countryData.get(data.getCountry()).getRecovered());
//
//                countryData.replace(data.getCountry(),data);
//
//            }else{
//                countryData.put(data.getCountry(),data);
//            }
//        }
//        covid19Stats=countryData.values().stream().collect(Collectors.toList());
//        covid19Stats.sort((o1, o2) -> o1.getConfirmed()<o2.getConfirmed()?1:-1);
//        return this;
//    }

}
