package de.ait.userApi.dto;

import de.ait.userApi.model.Address;
import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@ToString
public class UserRequestDto {
    private String name;
    private String email;
    private String password;
    private Address address;
}
