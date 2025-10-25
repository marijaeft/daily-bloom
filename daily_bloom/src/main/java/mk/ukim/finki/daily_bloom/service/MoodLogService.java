package mk.ukim.finki.daily_bloom.service;

import jakarta.persistence.*;
import mk.ukim.finki.daily_bloom.domain.MoodCategory;
import mk.ukim.finki.daily_bloom.domain.MoodLog;
import mk.ukim.finki.daily_bloom.domain.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MoodLogService {
    MoodLog create(Long userId, Integer moodRate, String moodCategory);
    Optional<MoodLog> findById(Long id);
    List<MoodLog> findByUser(Long userId);
//    Optional<MoodLog> findByDate(Long userId, Date date);
    void delete(Long id);
}

