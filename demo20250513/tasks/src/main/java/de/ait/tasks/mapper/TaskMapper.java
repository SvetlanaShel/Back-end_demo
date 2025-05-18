package de.ait.tasks.mapper;

import de.ait.tasks.dto.TaskRequestDto;
import de.ait.tasks.dto.TaskResponseDto;
import de.ait.tasks.model.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskResponseDto toDto(Task task);
    List<TaskResponseDto> toDtoList(List<Task> task);
    Task fromDto(TaskRequestDto dto);
}
