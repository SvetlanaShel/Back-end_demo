package de.ait.tasks.service;

import de.ait.tasks.dto.TaskRequestDto;
import de.ait.tasks.dto.TaskResponseDto;

import java.util.List;

public interface TaskService {
    List<TaskResponseDto> getTasks();
    TaskResponseDto getTaskById(Long id);
    TaskResponseDto createTask(TaskRequestDto dto);
}
