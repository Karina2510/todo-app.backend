package project.tasks.service;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.tasks.dto.task.CreateTaskInputDTO;
import project.tasks.dto.task.TaskResponseDTO;
import project.tasks.dto.task.UpdateTaskDTO;
import project.tasks.entity.Task;
import project.tasks.exception.TaskException;
import project.tasks.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;


    public TaskResponseDTO createTask(CreateTaskInputDTO input){

        if(input.getName().isEmpty()){
            throw new TaskException("O campo name está em branco");
        }

        if(input.getDueTime() == null){
            throw new TaskException("O campo due_time está em branco");
        }

        Task task =
                Task.builder()
                        .id(UUID.randomUUID().toString())
                        .name(input.getName())
                        .dueTime(input.getDueTime())
                        .isArchived(false)
                        .createdAt(LocalDateTime.now())
                        .updateAt(LocalDateTime.now())
                        .build();

        task = taskRepository.save(task);


        return TaskResponseDTO.builder()
                .id(task.getId())
                .name(task.getName())
                .dueTime(task.getDueTime())
                .isArchived(task.getIsArchived())
                .createdAt(task.getCreatedAt())
                .updateAt(task.getUpdateAt())
                .build();
    }

    public TaskResponseDTO taskFindById(String id){
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task de id " + id + " não encontrada"));

        return TaskResponseDTO.builder()
                .id(task.getId())
                .name(task.getName())
                .dueTime(task.getDueTime())
                .isArchived(task.getIsArchived())
                .createdAt(task.getCreatedAt())
                .updateAt(task.getUpdateAt())
                .build();
    }


    public TaskResponseDTO updateTaskDTO(String id, UpdateTaskDTO updateTaskDTO){
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task de id " + id + " não encontrada"));

        Optional.ofNullable(updateTaskDTO.getName()).ifPresent(name -> task.setName(name));
        Optional.ofNullable(updateTaskDTO.getDueTime()).ifPresent(dueTime -> task.setDueTime(dueTime));

        if (updateTaskDTO.getName().isEmpty()){
            throw new TaskException("O campo name está em branco");
        }

        if (updateTaskDTO.getDueTime() == null){
            throw new TaskException("O campo due_time está em branco");
        }

        taskRepository.save(task);

        return TaskResponseDTO.builder()
                .id(task.getId())
                .name(task.getName())
                .dueTime(task.getDueTime())
                .isArchived(task.getIsArchived())
                .createdAt(task.getCreatedAt())
                .updateAt(task.getUpdateAt())
                .build();

    }

    public void deleteTaskById(String id){
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task de id " + id + " não encontrada"));

        taskRepository.delete(task);
    }


}
