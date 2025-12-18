package com.aibek.finalspring.service;

import com.aibek.finalspring.dto.CountryDto;
import java.util.List;

public interface CountryService {
    List<CountryDto> getAll();
    CountryDto getById(Long id);
    CountryDto createCountry(CountryDto countryDto);
    CountryDto updateCountry(Long id, CountryDto countryDto);
    boolean delete(Long id);
}