package project.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.tasks.entity.Routine;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, String> {
}
