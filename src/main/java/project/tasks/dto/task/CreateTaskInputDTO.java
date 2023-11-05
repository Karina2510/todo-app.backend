package project.tasks.dto.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskInputDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("dueTime")
    private LocalDateTime dueTime;
}
