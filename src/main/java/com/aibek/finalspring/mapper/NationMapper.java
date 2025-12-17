package com.aibek.finalspring.mapper;

import com.aibek.finalspring.dto.NationDto;
import com.aibek.finalspring.entity.NationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NationMapper {
    @Mapping(target = "nameDto", source = "name")
    @Mapping(target = "descriptionDto", source = "description")
    NationDto toDto(NationEntity entity);

    @Mapping(target = "name", source = "nameDto")
    @Mapping(target = "description", source = "descriptionDto")
    NationEntity toEntity(NationDto dto);

    List<NationDto> toDtoList(List<NationEntity> entities);
}