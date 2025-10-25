package mk.ukim.finki.daily_bloom.repository;

import mk.ukim.finki.daily_bloom.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
