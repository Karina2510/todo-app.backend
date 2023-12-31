package project.tasks.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="tasks")
public class Task {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "due_time")
    private LocalTime dueTime;

    @Column(name = "is_archived")
    private Boolean isArchived;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "task")
    private List<Routine> routines;

}
