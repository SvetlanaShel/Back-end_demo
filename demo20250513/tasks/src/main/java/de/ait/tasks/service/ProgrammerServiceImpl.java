package de.ait.tasks.service;

import de.ait.tasks.dto.ProgrammerRequestDto;
import de.ait.tasks.dto.ProgrammerResponseDto;
import de.ait.tasks.mapper.ProgrammerMapper;
import de.ait.tasks.model.Programmer;
import de.ait.tasks.repository.ProgrammerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgrammerServiceImpl implements ProgrammerService {
    private final ProgrammerRepository repository;
    private final ProgrammerMapper mapper;

    @Override
    public List<ProgrammerResponseDto> getProgrammers() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public ProgrammerResponseDto getProgrammerById(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public ProgrammerResponseDto createTask(ProgrammerRequestDto dto) {
        Programmer programmer = mapper.fromDto(dto);
        Programmer saved = repository.save(programmer);
        return mapper.toDto(saved);
    }

}
