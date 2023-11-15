package project.tasks.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskException extends RuntimeException{

    public TaskException(String message){
        super(message);
    }

    public TaskException(String message, Throwable ex){
        super(message, ex);
    }
}
