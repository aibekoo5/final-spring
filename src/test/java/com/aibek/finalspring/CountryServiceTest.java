package com.aibek.finalspring;

import com.aibek.finalspring.dto.CountryDto;
import com.aibek.finalspring.service.CountryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(properties = {
        "spring.flyway.enabled=false",
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
public class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    private CountryDto createTestCountry() {
        CountryDto dto = CountryDto.builder()
                .nameDto("TestCountry")
                .continent("Asia")
                .populationDto(1_000_000)
                .build();

        return countryService.createCountry(dto);
    }

    @Test
    void getAllTest() {
        createTestCountry();

        List<CountryDto> countryDtoList = countryService.getAll();

        Assertions.assertNotNull(countryDtoList);
        Assertions.assertNotEquals(0, countryDtoList.size());

        for (CountryDto countryDto : countryDtoList) {
            Assertions.assertNotNull(countryDto);
            Assertions.assertNotNull(countryDto.getId());
            Assertions.assertNotNull(countryDto.getNameDto());
            Assertions.assertNotNull(countryDto.getContinent());
            Assertions.assertTrue(countryDto.getPopulationDto() > 0);
        }
    }

    @Test
    void getByIdTest() {
        CountryDto created = createTestCountry();
        Long id = created.getId();

        CountryDto countryDto = countryService.getById(id);

        Assertions.assertNotNull(countryDto);
        Assertions.assertNotNull(countryDto.getId());
        Assertions.assertNotNull(countryDto.getNameDto());
        Assertions.assertNotNull(countryDto.getContinent());
        Assertions.assertTrue(countryDto.getPopulationDto() > 0);
    }

    @Test
    void addTest() {
        CountryDto countryDto = CountryDto.builder()
                .nameDto("French")
                .continent("EU")
                .populationDto(65_000_000)
                .build();

        CountryDto add = countryService.createCountry(countryDto);

        Assertions.assertNotNull(add);
        Assertions.assertNotNull(add.getId());
        Assertions.assertNotNull(add.getNameDto());
        Assertions.assertNotNull(add.getContinent());
        Assertions.assertTrue(add.getPopulationDto() > 0);

        CountryDto added = countryService.getById(add.getId());

        Assertions.assertNotNull(added);
        Assertions.assertNotNull(added.getId());
        Assertions.assertNotNull(added.getNameDto());
        Assertions.assertNotNull(added.getContinent());
        Assertions.assertTrue(added.getPopulationDto() > 0);

        Assertions.assertEquals(add.getId(), added.getId());
        Assertions.assertEquals(add.getNameDto(), added.getNameDto());
        Assertions.assertEquals(add.getContinent(), added.getContinent());
        Assertions.assertEquals(add.getPopulationDto(), added.getPopulationDto());
    }

    @Test
    void updateTest() {
        CountryDto created = createTestCountry();
        Long id = created.getId();

        CountryDto newCountry = CountryDto.builder()
                .id(id)
                .nameDto("Kazakh")
                .continent("EU")
                .populationDto(19_000_000)
                .build();

        CountryDto update = countryService.updateCountry(id, newCountry);

        Assertions.assertNotNull(update);
        Assertions.assertNotNull(update.getId());
        Assertions.assertNotNull(update.getNameDto());
        Assertions.assertNotNull(update.getContinent());
        Assertions.assertTrue(update.getPopulationDto() > 0);

        Assertions.assertEquals(newCountry.getId(), update.getId());
        Assertions.assertEquals(newCountry.getNameDto(), update.getNameDto());
        Assertions.assertEquals(newCountry.getContinent(), update.getContinent());
        Assertions.assertEquals(newCountry.getPopulationDto(), update.getPopulationDto());

        CountryDto updated = countryService.getById(id);

        Assertions.assertNotNull(updated);
        Assertions.assertNotNull(updated.getId());
        Assertions.assertNotNull(updated.getNameDto());
        Assertions.assertNotNull(updated.getContinent());
        Assertions.assertTrue(updated.getPopulationDto() > 0);

        Assertions.assertEquals(update.getId(), updated.getId());
        Assertions.assertEquals(update.getNameDto(), updated.getNameDto());
        Assertions.assertEquals(update.getContinent(), updated.getContinent());
        Assertions.assertEquals(update.getPopulationDto(), updated.getPopulationDto());
    }

    @Test
    void deleteTest() {
        CountryDto created = createTestCountry();
        Long id = created.getId();

        Assertions.assertTrue(countryService.delete(id));

        CountryDto deleted = countryService.getById(id);
        Assertions.assertNull(deleted);
    }
}
