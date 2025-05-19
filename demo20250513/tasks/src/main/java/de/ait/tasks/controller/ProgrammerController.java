package de.ait.tasks.controller;

import de.ait.tasks.dto.ProgrammerRequestDto;
import de.ait.tasks.dto.ProgrammerResponseDto;
import de.ait.tasks.service.ProgrammerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/programmers")
public class ProgrammerController {
    private final ProgrammerService service;

    @GetMapping
    public ResponseEntity<List<ProgrammerResponseDto>> getProgrammers() {
        return ResponseEntity.ok().body(service.getProgrammers());

    }



    @GetMapping("/{id}")
    public ResponseEntity<ProgrammerResponseDto> getProgrammers(@PathVariable("id") Long id){
        return ResponseEntity.ofNullable(service.getProgrammerById(id));
    }

    @PostMapping
    public ResponseEntity<ProgrammerResponseDto> addProgrammer(@RequestBody ProgrammerRequestDto dto){
        ProgrammerResponseDto saved = service.createTask(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).body(saved);

    }


}

