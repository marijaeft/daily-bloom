package mk.ukim.finki.daily_bloom.service;

import mk.ukim.finki.daily_bloom.domain.DTO.WeeklyReflectionDTO;
import mk.ukim.finki.daily_bloom.domain.WeeklyReflection;
import mk.ukim.finki.daily_bloom.domain.User;

import java.util.List;
import java.util.Optional;

public interface WeeklyReflectionService {
    WeeklyReflection create(WeeklyReflectionDTO weeklyReflectionDTO);
    Optional<WeeklyReflection> findById(Long id);
//    List<WeeklyReflection> findByUser(Long userId);
    void delete(Long id);
}
