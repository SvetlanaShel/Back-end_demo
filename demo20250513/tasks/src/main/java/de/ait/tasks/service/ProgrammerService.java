package de.ait.tasks.service;

import de.ait.tasks.dto.ProgrammerRequestDto;
import de.ait.tasks.dto.ProgrammerResponseDto;

import java.util.List;

public interface ProgrammerService {
    List<ProgrammerResponseDto> getProgrammers();
    ProgrammerResponseDto getProgrammerById(Long id);
    ProgrammerResponseDto createTask(ProgrammerRequestDto dto);
}
