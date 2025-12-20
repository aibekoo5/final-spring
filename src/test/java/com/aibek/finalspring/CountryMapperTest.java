package com.aibek.finalspring;

import com.aibek.finalspring.dto.CountryDto;
import com.aibek.finalspring.entity.CountryEntity;
import com.aibek.finalspring.mapper.CountryMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;


public class CountryMapperTest {
    private final CountryMapper countryMapper = Mappers.getMapper(CountryMapper.class);

    @Test
    void convertEntityToDtoTest(){
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setId(1L);
        countryEntity.setName("Italy");
        countryEntity.setContinent("Europe");
        countryEntity.setPopulation(5000000);

        CountryDto countryDto = countryMapper.toDto(countryEntity);

        Assertions.assertNotNull(countryDto);
        Assertions.assertNotNull(countryDto.getId());
        Assertions.assertNotNull(countryDto.getNameDto());
        Assertions.assertNotNull(countryDto.getContinent());
        Assertions.assertTrue(countryDto.getPopulationDto() > 0);

        Assertions.assertEquals(countryEntity.getId(), countryDto.getId());
        Assertions.assertEquals(countryEntity.getName(), countryDto.getNameDto());
        Assertions.assertEquals(countryEntity.getContinent(), countryDto.getContinent());
        Assertions.assertEquals(countryEntity.getPopulation(), countryDto.getPopulationDto());
    }

    @Test
    void convertDtoToEntityTest(){
        CountryDto countryDto = new CountryDto(1L, "Spain", 5000000, "Europe");

        CountryEntity countryEntity = countryMapper.toEntity(countryDto);

        Assertions.assertNotNull(countryEntity);
        Assertions.assertNotNull(countryEntity.getId());
        Assertions.assertNotNull(countryEntity.getName());
        Assertions.assertNotNull(countryEntity.getContinent());
        Assertions.assertTrue(countryEntity.getPopulation() > 0);

        Assertions.assertEquals(countryEntity.getId(), countryDto.getId());
        Assertions.assertEquals(countryEntity.getName(), countryDto.getNameDto());
        Assertions.assertEquals(countryEntity.getContinent(), countryDto.getContinent());
        Assertions.assertEquals(countryEntity.getPopulation(), countryDto.getPopulationDto());
    }

    @Test
    void convertEntityListToDtoListTest(){
        List<CountryEntity> countryEntityList = new ArrayList<>();

        CountryEntity kazakhstan = new CountryEntity();
        kazakhstan.setId(1L);
        kazakhstan.setName("Kazakhstan");
        kazakhstan.setContinent("Asia");
        kazakhstan.setPopulation(20000000);

        CountryEntity russia = new CountryEntity();
        russia.setId(2L);
        russia.setName("Russia");
        russia.setContinent("Eurasian");
        russia.setPopulation(5000000);

        CountryEntity polsha = new CountryEntity();
        polsha.setId(3L);
        polsha.setName("Polsha");
        polsha.setContinent("Eu");
        polsha.setPopulation(50202021);

        countryEntityList.add(kazakhstan);
        countryEntityList.add(russia);
        countryEntityList.add(polsha);

        List<CountryDto> countryDtoList = countryMapper.toDtoList(countryEntityList);

        Assertions.assertNotNull(countryDtoList);
        Assertions.assertNotEquals(0, countryDtoList.size());
        Assertions.assertEquals(countryDtoList.size(), countryEntityList.size());

        for (int i = 0; i < countryEntityList.size(); i++) {
            CountryEntity countryEntity = countryEntityList.get(i);
            CountryDto countryDto = countryDtoList.get(i);

            Assertions.assertNotNull(countryDto);
            Assertions.assertNotNull(countryDto.getId());
            Assertions.assertNotNull(countryDto.getNameDto());
            Assertions.assertNotNull(countryDto.getContinent());
            Assertions.assertTrue(countryDto.getPopulationDto() > 0);

            Assertions.assertEquals(countryEntity.getId(), countryDto.getId());
            Assertions.assertEquals(countryEntity.getName(), countryDto.getNameDto());
            Assertions.assertEquals(countryEntity.getContinent(), countryDto.getContinent());
            Assertions.assertEquals(countryEntity.getPopulation(), countryDto.getPopulationDto());
        }
    }
}

