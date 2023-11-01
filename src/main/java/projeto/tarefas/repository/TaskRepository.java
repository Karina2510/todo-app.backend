package projeto.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.tarefas.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
}
