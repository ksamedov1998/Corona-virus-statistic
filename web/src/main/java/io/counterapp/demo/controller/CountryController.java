package io.counterapp.demo.controller;

import io.service.api_client.domain.CountryHistory;
import io.service.api_client.service.CountryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "/names")
    public String[] getAllCountryNames(){
        return countryService.getAllAffectedCountryNames();
    }

    @GetMapping(value = "/history")
    public CountryHistory getDataPerDay(){
        return countryService.getCountryDataByDate("Azerbaijan");
    }
}
