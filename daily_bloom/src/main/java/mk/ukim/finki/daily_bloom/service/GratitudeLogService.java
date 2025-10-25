package mk.ukim.finki.daily_bloom.service;

import mk.ukim.finki.daily_bloom.domain.GratitudeLog;
import mk.ukim.finki.daily_bloom.domain.User;

import java.util.List;
import java.util.Optional;

public interface GratitudeLogService {
    GratitudeLog create(Long userId, String gratitudeLog);
    Optional<GratitudeLog> findById(Long id);
    List<GratitudeLog> findByUser(Long userId);
    void delete(Long id);
}
