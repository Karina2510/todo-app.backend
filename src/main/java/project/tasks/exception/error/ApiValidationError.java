package project.tasks.exception.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiValidationError {

    private String field;
    private Object value;
    private String message;
}
