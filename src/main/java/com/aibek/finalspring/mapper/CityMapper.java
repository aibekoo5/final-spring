package com.aibek.finalspring.mapper;

import com.aibek.finalspring.dto.CityDto;
import com.aibek.finalspring.entity.CityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;


@Mapper(componentModel = "spring")
public interface CityMapper {

    @Mapping(target = "nameDto", source = "name")
    @Mapping(target = "populationDto", source = "population")
    @Mapping(target = "countryId", source = "country.id")
    @Mapping(target = "nations", source = "nations")
    CityDto toDto(CityEntity entity);

    @Mapping(target = "name", source = "nameDto")
    @Mapping(target = "population", source = "populationDto")
    @Mapping(target = "country.id",  source = "countryId")
    @Mapping(target = "nations",     source = "nations")
    CityEntity toEntity(CityDto dto);

    List<CityDto> toDtoList(List<CityEntity> entities);
}

