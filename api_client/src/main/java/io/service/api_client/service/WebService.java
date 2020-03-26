package io.service.api_client.service;

import io.service.api_client.domain.AllCountriesDataWrapper;
import io.service.api_client.domain.SingleCountryInfo;

public interface WebService {
    AllCountriesDataWrapper getAllCountriesInfo();
    SingleCountryInfo getCountryInfo(String country);
}
