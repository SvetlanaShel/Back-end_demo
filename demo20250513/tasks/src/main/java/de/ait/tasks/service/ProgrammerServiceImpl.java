package de.ait.tasks.service;

import de.ait.tasks.dto.ProgrammerResponseDto;
import de.ait.tasks.mappers.ProgrammerMapper;
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
    public List<ProgrammerResponseDto> getAllProgrammer() {
        return mapper.toResponceDtoList(repository.findAll());
    }

    private static ProgrammerResponseDto getProgrammerDto(Programmer programmer) {
        return new ProgrammerResponseDto(programmer.getId(), programmer.getName(), programmer.getTasks());
    }
}
