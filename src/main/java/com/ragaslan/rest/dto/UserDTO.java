package com.ragaslan.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {

    public int id;

    @NotNull(message = "user can't be null !")
    @NotBlank(message = "user can't be blank !")
    public String username;

    @NotNull(message = "password can't be null !")
    @NotBlank(message = "password can't be blank !")
    public String password;

    public String role;
}
