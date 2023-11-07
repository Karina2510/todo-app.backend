package project.tasks.dto.task;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String name;

    @JsonProperty("due_time")
    private LocalTime dueTime;
}
