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
public class TaskResponseDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("dueTime")
    private LocalTime dueTime;

    @JsonProperty("isArchived")
    private Boolean isArchived;

    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    @JsonProperty("updateAt")
    private LocalDateTime updateAt;
}
