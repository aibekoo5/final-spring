package com.aibek.finalspring.service.impl;

import com.aibek.finalspring.dto.NationDto;
import com.aibek.finalspring.entity.NationEntity;
import com.aibek.finalspring.mapper.NationMapper;
import com.aibek.finalspring.repository.NationRepo;
import com.aibek.finalspring.service.NationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NationServiceImpl implements NationService {
    private final NationMapper nationMapper;
    private final NationRepo nationRepo;

    @Override
    public List<NationDto> getAll(){
        return nationMapper.toDtoList(nationRepo.findAll());
    }

    @Override
    public NationDto getById(Long id) {
        return nationMapper.toDto(nationRepo.findById(id).orElse(null));
    }

    @Override
    public NationDto createNation(NationDto nationDto) {
        return nationMapper.toDto(nationRepo.save(nationMapper.toEntity(nationDto)));
    }

    @Override
    public NationDto updateNation(Long id, NationDto nationDto) {
        NationEntity updateNationEntity = nationRepo.findById(id).orElse(null);

        if (nationDto != null) {
            updateNationEntity.setName(nationDto.getNameDto());
            updateNationEntity.setDescription(nationDto.getDescriptionDto());
        }

        return nationMapper.toDto(nationRepo.save(updateNationEntity));
    }

    @Override
    public boolean delete(Long id) {
        nationRepo.deleteById(id);
        return true;
    }
}
