package dto;

import com.ragaslan.rest.entity.PostTag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;


@Data
public class PostDTO {

    @NotNull(message = "Title is mandatory !")
    @NotBlank(message = "Title is mandatory !")
    public String title;

    @NotNull(message = "Content is mandatory !")
    @NotBlank(message = "Content is mandatory !")
    public String content;

    @NotNull(message = "Author is mandatory !")
    @NotBlank(message = "Author is mandatory !")
    public String author;

    @NotNull(message = "createdAt is mandatory !")
    @NotBlank(message = "createdAt is mandatory !")
    public String createdAt;

    public List<PostTag> tags;
}
