package de.ait.tasks.controller;


import de.ait.tasks.dto.TaskRequestDto;
import de.ait.tasks.dto.TaskResponseDto;
import de.ait.tasks.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getTasks() {
        return ResponseEntity.ok().body(service.getTasks());

    }



    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> getTasks(@PathVariable("id") Long id){
        return ResponseEntity.ofNullable(service.getTaskById(id));
    }

    @PostMapping
    public ResponseEntity<TaskResponseDto> addTask(@RequestBody TaskRequestDto dto){
        TaskResponseDto saved = service.createTask(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).body(saved);

    }


}
