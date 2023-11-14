package project.tasks.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import project.tasks.exception.error.ApiError;
import project.tasks.exception.error.GlobalError;


import java.time.LocalDateTime;
import java.util.Arrays;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<ApiError> handleEntityNotFoundException(EntityNotFoundException exception) {
        return this.buildResponseEntity(ApiError.builder()
                .codeError(BAD_REQUEST.value())
                .statusErro(BAD_REQUEST)
                .mensage(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .build());
    }

    private ResponseEntity<ApiError> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatusErro());
    }

    @ExceptionHandler(TaskException.class)
    public ResponseEntity<GlobalError> taskException
        (HttpServletRequest request, TaskException ex){

        GlobalError globalError =
                GlobalError.builder()
                        .errorCode(HttpStatus.BAD_REQUEST.value())
                        .erros(
                                Arrays.asList(
                                        ApiError.builder()
                                                .codeError(BAD_REQUEST.value())
                                                .statusErro(BAD_REQUEST)
                                                .mensage(ex.getMessage())
                                                .timestamp(LocalDateTime.now())
                                                .build()))

                        .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(globalError);

    }
}
