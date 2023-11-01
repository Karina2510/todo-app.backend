package projeto.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.tarefas.entity.Routine;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, String> {
}
