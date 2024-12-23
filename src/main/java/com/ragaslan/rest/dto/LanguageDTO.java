package com.ragaslan.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LanguageDTO {

    @NotNull(message = "Name is mandatory !")
    @NotBlank(message = "Name is mandatory !")
    public String name;

    @NotNull(message = "isTool is mandatory !")
    @NotBlank(message = "isTool is mandatory !")
    public boolean isTool;
}
