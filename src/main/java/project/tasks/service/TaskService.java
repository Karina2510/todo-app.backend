package project.tasks.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.tasks.dto.task.CreateTaskInputDTO;
import project.tasks.dto.task.TaskResponseDTO;
import project.tasks.entity.Task;
import project.tasks.repository.TaskRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;


    public TaskResponseDTO createTask(CreateTaskInputDTO input){
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
}
