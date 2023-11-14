package project.tasks.dto.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskInputDTO {

    @JsonProperty("name")
    @NotBlank(message = "o campo name não está preenchido")
    private String name;

    @JsonProperty("due_time")
    @NotNull(message = "o campo dueTime não está preenchido")
    private LocalTime dueTime;
}
