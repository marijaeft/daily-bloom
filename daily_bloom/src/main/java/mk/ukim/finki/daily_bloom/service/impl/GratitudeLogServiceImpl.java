package mk.ukim.finki.daily_bloom.service.impl;

import mk.ukim.finki.daily_bloom.domain.GratitudeLog;
import mk.ukim.finki.daily_bloom.domain.User;
import mk.ukim.finki.daily_bloom.repository.GratitudeLogRepository;
import mk.ukim.finki.daily_bloom.repository.UserRepository;
import mk.ukim.finki.daily_bloom.service.GratitudeLogService;
import mk.ukim.finki.daily_bloom.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GratitudeLogServiceImpl implements GratitudeLogService {

    private final GratitudeLogRepository gratitudeLogRepository;
    private final UserService userService;

    public GratitudeLogServiceImpl(GratitudeLogRepository gratitudeLogRepository, UserService userService) {
        this.gratitudeLogRepository = gratitudeLogRepository;

        this.userService = userService;
    }


    @Override
    public GratitudeLog create(Long userId, String gratitudeLog) {
        GratitudeLog gratitudeLog1 = new GratitudeLog();
        User user = userService.findById(userId).orElse(null);

        gratitudeLog1.setGratitudeText(gratitudeLog);
        gratitudeLog1.setUser(user);
        return gratitudeLogRepository.save(gratitudeLog1);
    }

    @Override
    public Optional<GratitudeLog> findById(Long id) {
        return gratitudeLogRepository.findById(id);
    }

    @Override
    public List<GratitudeLog> findByUser(Long userId) {
        User user = userService.findById(userId).orElse(null);
        return gratitudeLogRepository.findGratitudeLogsByUser(user);
    }

    @Override
    public void delete(Long id) {
        gratitudeLogRepository.deleteById(id);
    }
}
