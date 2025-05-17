package de.ait.userApi.dto;

import de.ait.userApi.model.Address;
import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@ToString
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private Address address;
}
