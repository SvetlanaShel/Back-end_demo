package de.ait.tasks.mapper;


import de.ait.tasks.dto.ProgrammerRequestDto;
import de.ait.tasks.dto.ProgrammerResponseDto;
import de.ait.tasks.model.Programmer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgrammerMapper {
    ProgrammerResponseDto toDto(Programmer programmer);
    List<ProgrammerResponseDto> toDtoList(List<Programmer> programmer);
    Programmer fromDto(ProgrammerRequestDto dto);
}
