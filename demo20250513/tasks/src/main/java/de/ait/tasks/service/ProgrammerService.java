package de.ait.tasks.service;

import de.ait.tasks.dto.ProgrammerResponseDto;

import java.util.List;

public interface ProgrammerService {
    List<ProgrammerResponseDto> getAllProgrammer();
}
