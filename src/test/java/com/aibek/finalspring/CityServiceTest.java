package com.aibek.finalspring;

import com.aibek.finalspring.dto.CityDto;
import com.aibek.finalspring.entity.CountryEntity;
import com.aibek.finalspring.repository.CountryRepo;
import com.aibek.finalspring.service.CityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class CityServiceTest {
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryRepo countryRepo;

    private CityDto createTestCity() {
        CountryEntity country = new CountryEntity();
        country.setName("TestCountry");
        country.setContinent("Test");
        country.setPopulation(123);
        CountryEntity savedCountry = countryRepo.save(country);

        CityDto newCity = CityDto.builder()
                .nameDto("TestCity")
                .populationDto(100000)
                .countryId(savedCountry.getId())
                .build();

        return cityService.createCity(newCity);
    }

    @Test
    void getAllTest(){
        createTestCity();

        List<CityDto> cityDtos = cityService.getAll();

        Assertions.assertNotNull(cityDtos);
        Assertions.assertNotEquals(0, cityDtos.size());

        for (CityDto cityDto : cityDtos) {
            Assertions.assertNotNull(cityDto.getId());
            Assertions.assertNotNull(cityDto.getNameDto());
            Assertions.assertNotNull(cityDto.getPopulationDto());
            Assertions.assertNotNull(cityDto.getCountryId());
        }
    }


    @Test
    void getByIdTest() {
        CityDto created = createTestCity();
        Long cityId = created.getId();

        CityDto cityDto = cityService.getById(cityId);

        Assertions.assertNotNull(cityDto);
        Assertions.assertNotNull(cityDto.getId());
        Assertions.assertNotNull(cityDto.getNameDto());
        Assertions.assertNotNull(cityDto.getPopulationDto());
        Assertions.assertNotNull(cityDto.getCountryId());
    }


    @Test
    void createCityTest() {
        CityDto created = createTestCity();

        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());

        CityDto loaded = cityService.getById(created.getId());

        Assertions.assertEquals(created.getId(), loaded.getId());
        Assertions.assertEquals(created.getNameDto(), loaded.getNameDto());
        Assertions.assertEquals(created.getPopulationDto(), loaded.getPopulationDto());
        Assertions.assertEquals(created.getCountryId(), loaded.getCountryId());
    }


    @Test
    void deleteCityTest() {
        CityDto created = createTestCity();
        Long cityId = created.getId();

        Assertions.assertTrue(cityService.delete(cityId));

        CityDto deleted = cityService.getById(cityId);
        Assertions.assertNull(deleted);
    }
}
