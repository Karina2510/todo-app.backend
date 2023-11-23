package project.tasks.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.tasks.dto.task.CreateTaskInputDTO;
import project.tasks.dto.task.TaskResponseDTO;
import project.tasks.dto.task.UpdateTaskDTO;
import project.tasks.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<TaskResponseDTO> created(
            @RequestBody @Valid CreateTaskInputDTO createTaskInputDTO){
        return ResponseEntity.ok().body(service.createTask(createTaskInputDTO));
    }

    @GetMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity taskFindBydId(@PathVariable String id){
        return ResponseEntity.ok().body(service.taskFindById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(
            @RequestBody UpdateTaskDTO updateTaskDTO, @PathVariable String id){
        TaskResponseDTO taskResponseDTO = service.updateTaskDTO(id, updateTaskDTO);
        return ResponseEntity.status(HttpStatus.OK).body(taskResponseDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity deleteTaskById(@PathVariable String id){
        this.service.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }
}
