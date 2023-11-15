package project.tasks.exception.error;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ApiError {
    private Integer codeError;
    private HttpStatus statusErro;
    private String mensage;
    private LocalDateTime timestamp;

}
