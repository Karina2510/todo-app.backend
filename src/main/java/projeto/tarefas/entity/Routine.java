package projeto.tarefas.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="routines")
public class Routine {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "is_finished")
    private Boolean isFinished;

    @ManyToOne
    @JoinColumn(name="tasks_id", nullable=false)
    private Task task;
}
