package de.ait.tasks.dto;

import de.ait.tasks.model.Priority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TaskRequestDto {
    private String description;
    private Priority priority;
    private Long programmerId;
}
