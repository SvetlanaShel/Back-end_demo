package de.ait.tasks.service;

import de.ait.tasks.dto.TaskRequestDto;
import de.ait.tasks.dto.TaskResponseDto;
import de.ait.tasks.mapper.TaskMapper;
import de.ait.tasks.model.Programmer;
import de.ait.tasks.model.Task;
import de.ait.tasks.repository.ProgrammerRepository;
import de.ait.tasks.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;
    private final TaskMapper mapper;
    private final ProgrammerRepository programmerRepository;



    @Override
    public List<TaskResponseDto> getTasks() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public TaskResponseDto getTaskById(Long id) {

        return mapper.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public TaskResponseDto createTask(TaskRequestDto dto) {
        Task task = mapper.fromDto(dto);
        Programmer programmer = programmerRepository.findById(dto.getProgrammerId()).orElseThrow(() -> new RuntimeException("Programmer not found"));
        task.setProgrammer(programmer);
        Task saved = repository.save(task);
        return mapper.toDto(saved);
    }

}