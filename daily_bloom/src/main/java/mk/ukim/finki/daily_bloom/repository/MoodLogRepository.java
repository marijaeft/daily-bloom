package mk.ukim.finki.daily_bloom.repository;

import mk.ukim.finki.daily_bloom.domain.MoodLog;
import mk.ukim.finki.daily_bloom.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoodLogRepository extends JpaRepository<MoodLog,Long> {
    List<MoodLog> findMoodLogsByUser(User user);
}
