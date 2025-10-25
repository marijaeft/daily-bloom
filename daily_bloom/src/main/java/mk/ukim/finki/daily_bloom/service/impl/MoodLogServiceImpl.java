package mk.ukim.finki.daily_bloom.service.impl;

import mk.ukim.finki.daily_bloom.domain.MoodCategory;
import mk.ukim.finki.daily_bloom.domain.MoodLog;
import mk.ukim.finki.daily_bloom.domain.User;
import mk.ukim.finki.daily_bloom.repository.MoodLogRepository;
import mk.ukim.finki.daily_bloom.service.MoodLogService;
import mk.ukim.finki.daily_bloom.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoodLogServiceImpl implements MoodLogService {

    private final MoodLogRepository moodLogRepository;
    private final UserService userService;

    public MoodLogServiceImpl(MoodLogRepository moodLogRepository, UserService userService) {
        this.moodLogRepository = moodLogRepository;
        this.userService = userService;
    }

    @Override
    public MoodLog create(Long userId, Integer moodRate, String moodCategory) {
        MoodLog moodLog = new MoodLog();
        User user = userService.findById(userId).orElse(null);

        moodLog.setMoodRate(moodRate);
        moodLog.setMoodCategory(MoodCategory.valueOf(moodCategory));
        moodLog.setUser(user);
        return moodLogRepository.save(moodLog);
    }

    @Override
    public Optional<MoodLog> findById(Long id) {

        return moodLogRepository.findById(id);
    }

    @Override
    public List<MoodLog> findByUser(Long userId) {
        User user = userService.findById(userId).orElse(null);
        return moodLogRepository.findMoodLogsByUser(user);
    }

    @Override
    public void delete(Long id) {
        moodLogRepository.deleteById(id);
    }

}
