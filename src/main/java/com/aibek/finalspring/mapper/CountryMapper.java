package com.aibek.finalspring.mapper;

import com.aibek.finalspring.dto.CountryDto;
import com.aibek.finalspring.entity.CountryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    @Mapping(target = "nameDto", source = "name")
    @Mapping(target = "populationDto", source = "population")
    CountryDto toDto(CountryEntity entity);

    @Mapping(target = "name", source = "nameDto")
    @Mapping(target = "population", source = "populationDto")
    CountryEntity toEntity(CountryDto dto);

    List<CountryDto> toDtoList(List<CountryEntity> entities);
}

