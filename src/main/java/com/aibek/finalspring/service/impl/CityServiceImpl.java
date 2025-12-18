package com.aibek.finalspring.service.impl;

import com.aibek.finalspring.dto.CityDto;
import com.aibek.finalspring.entity.CityEntity;
import com.aibek.finalspring.entity.CountryEntity;
import com.aibek.finalspring.mapper.CityMapper;
import com.aibek.finalspring.repository.CityRepo;
import com.aibek.finalspring.repository.CountryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.aibek.finalspring.service.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CityServiceImpl implements CityService {
    private final CityMapper cityMapper;
    private final CityRepo cityRepo;
    private final CountryRepo countryRepo;

    @Override
    public List<CityDto> getAll() {
        return cityMapper.toDtoList(cityRepo.findAll());
    }

    @Override
    public CityDto getById(Long id) {
        return cityMapper.toDto(cityRepo.findById(id).orElse(null));
    }

    @Override
    @Transactional
    public CityDto createCity(CityDto cityDto) {
        CityEntity cityEntity = cityMapper.toEntity(cityDto);

        CountryEntity country = countryRepo.findById(cityDto.getCountryId()).orElse(null);
        cityEntity.setCountry(country);

        CityEntity saved = cityRepo.save(cityEntity);
        return cityMapper.toDto(saved);
    }

    @Override
    @Transactional
    public CityDto updateCity(Long id, CityDto cityDto) {
        CityEntity updateCityEntity = cityRepo.findById(id).orElse(null);

        if (cityDto != null) {
            updateCityEntity.setName(cityDto.getNameDto());
            updateCityEntity.setPopulation(cityDto.getPopulationDto());

            CountryEntity country = countryRepo.findById(cityDto.getCountryId()).orElse(null);
            updateCityEntity.setCountry(country);
        }

        CityEntity saved = cityRepo.save(updateCityEntity);
        return cityMapper.toDto(saved);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        if (cityRepo.existsById(id)) {
            cityRepo.deleteById(id);
            return true;
        }

        return false;
    }
}
