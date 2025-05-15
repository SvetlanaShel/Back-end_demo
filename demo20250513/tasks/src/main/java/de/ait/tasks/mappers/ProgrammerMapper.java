package de.ait.tasks.mappers;


import de.ait.tasks.dto.ProgrammerRequestDto;
import de.ait.tasks.dto.ProgrammerResponseDto;
import de.ait.tasks.model.Programmer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgrammerMapper {
    ProgrammerResponseDto toResponceDto(Programmer programmer);
    List<ProgrammerResponseDto> toResponceDtoList(List<Programmer> programmer);
    Programmer fromRequestDto(ProgrammerRequestDto dto);

}
