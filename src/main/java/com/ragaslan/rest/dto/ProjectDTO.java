package com.ragaslan.rest.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProjectDTO {

    @NotBlank(message = "name is mandatory !")
    @NotNull(message = "name is mandatory !")
    public String name;

    @NotBlank(message = "introduction text is mandatory !")
    @NotNull(message = "introduction text is mandatory !")
    public String introduction;


    @NotNull(message = "github link is mandatory !")
    @NotBlank(message = "github link is mandatory !")
    public String githubLink;

    @NotBlank(message = "content is mandatory !")
    @NotNull(message = "content is mandatory !")
    public String content;

}
