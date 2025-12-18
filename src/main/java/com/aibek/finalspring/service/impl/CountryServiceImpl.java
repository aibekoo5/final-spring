package com.aibek.finalspring.service.impl;

import com.aibek.finalspring.dto.CountryDto;
import com.aibek.finalspring.entity.CountryEntity;
import com.aibek.finalspring.mapper.CountryMapper;
import com.aibek.finalspring.repository.CountryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.aibek.finalspring.service.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryMapper countryMapper;
    private final CountryRepo countryRepo;

    @Override
    public List<CountryDto> getAll() {
        return countryMapper.toDtoList(countryRepo.findAll());
    }

    @Override
    public CountryDto getById(Long id) {
        return countryMapper.toDto(countryRepo.findById(id).orElse(null));
    }

    @Override
    public CountryDto createCountry(CountryDto countryDto) {
        return countryMapper.toDto(countryRepo.save(countryMapper.toEntity(countryDto)));
    }

    @Override
    public CountryDto updateCountry(Long id, CountryDto countryDto) {
        CountryEntity updateCountryEntity = countryRepo.findById(id).orElse(null);

        if(countryDto != null){
            updateCountryEntity.setName(countryDto.getNameDto());
            updateCountryEntity.setPopulation(countryDto.getPopulationDto());
            updateCountryEntity.setContinent(countryDto.getContinent());
        }

        return countryMapper.toDto(countryRepo.save(updateCountryEntity));
    }

    @Override
    public boolean delete(Long id) {
        CountryEntity countryEntity = countryRepo.findById(id).orElse(null);
        if(countryEntity != null){
            countryRepo.delete(countryEntity);
            return true;
        }

        return false;
    }
}
