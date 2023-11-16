package project.tasks.exception.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GlobalError {

    private Integer errorCode;

    private String message;

    private String details;

    private String timestamp;

    private String traceId;

    private List<ApiError> error;
}
