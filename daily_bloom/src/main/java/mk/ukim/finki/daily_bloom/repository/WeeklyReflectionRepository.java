package mk.ukim.finki.daily_bloom.repository;

import mk.ukim.finki.daily_bloom.domain.WeeklyReflection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeeklyReflectionRepository extends JpaRepository<WeeklyReflection, Long> {
}
