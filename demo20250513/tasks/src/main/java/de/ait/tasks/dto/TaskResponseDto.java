package de.ait.tasks.dto;


import de.ait.tasks.model.Priority;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class TaskResponseDto {
    private Long id;
    private String description;
    private Priority priority;
    private ProgrammerResponseDto programmer;
}
