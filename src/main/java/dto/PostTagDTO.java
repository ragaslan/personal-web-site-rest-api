package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostTagDTO {
    @NotBlank(message = "Tag name is mandatory !")
    @NotNull(message = "Tag name is mandatory")
    public String name;

}
