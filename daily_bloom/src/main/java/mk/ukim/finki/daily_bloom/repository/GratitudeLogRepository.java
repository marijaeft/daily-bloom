package mk.ukim.finki.daily_bloom.repository;

import mk.ukim.finki.daily_bloom.domain.GratitudeLog;
import mk.ukim.finki.daily_bloom.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GratitudeLogRepository extends JpaRepository<GratitudeLog,Long> {
    List<GratitudeLog> findGratitudeLogsByUser(User user);
}
