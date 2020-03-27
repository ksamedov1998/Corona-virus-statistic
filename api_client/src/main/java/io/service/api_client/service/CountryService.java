package io.service.api_client.service;

import io.service.api_client.domain.CountryHistory;

public interface CountryService {
    String[] getAllAffectedCountryNames();
    CountryHistory getCountryDataByDate(String country);
}
