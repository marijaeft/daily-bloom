package mk.ukim.finki.daily_bloom.service.impl;

import mk.ukim.finki.daily_bloom.domain.DTO.WeeklyReflectionDTO;
import mk.ukim.finki.daily_bloom.domain.WeeklyReflection;
import mk.ukim.finki.daily_bloom.domain.User;
import mk.ukim.finki.daily_bloom.repository.WeeklyReflectionRepository;
import mk.ukim.finki.daily_bloom.service.UserService;
import mk.ukim.finki.daily_bloom.service.WeeklyReflectionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeeklyReflectionServiceImpl implements WeeklyReflectionService {

    private final WeeklyReflectionRepository repo;
    private final UserService userService;

    public WeeklyReflectionServiceImpl(WeeklyReflectionRepository repo, UserService userService) {
        this.repo = repo;
        this.userService = userService;
    }


    @Override
    public WeeklyReflection create(WeeklyReflectionDTO weeklyReflectionDTO) {
        WeeklyReflection weeklyReflection = new WeeklyReflection();
        User user = userService.findById(weeklyReflectionDTO.getUserId()).orElse(null);

        weeklyReflection.setQuestion1(weeklyReflectionDTO.getQuestion1());
        weeklyReflection.setQuestion2(weeklyReflectionDTO.getQuestion2());
        weeklyReflection.setQuestion3(weeklyReflectionDTO.getQuestion3());
        weeklyReflection.setQuestion4(weeklyReflectionDTO.getQuestion4());
        weeklyReflection.setUser(user);
        return repo.save(weeklyReflection);
    }

    @Override
    public Optional<WeeklyReflection> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void delete(Long id) {
        WeeklyReflection weeklyReflection = repo.findById(id).orElse(null);
        repo.delete(weeklyReflection);
    }
}
