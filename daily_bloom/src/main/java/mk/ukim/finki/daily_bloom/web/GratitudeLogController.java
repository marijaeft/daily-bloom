package mk.ukim.finki.daily_bloom.web;

import mk.ukim.finki.daily_bloom.domain.GratitudeLog;
import mk.ukim.finki.daily_bloom.service.GratitudeLogService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/gratitude-log")
public class GratitudeLogController {
    private final GratitudeLogService gratitudeLogService;

    public GratitudeLogController(GratitudeLogService gratitudeLogService) {
        this.gratitudeLogService = gratitudeLogService;
    }

    @GetMapping("/{id}")
    public Optional<GratitudeLog> getGratitudeLog(@PathVariable Long id) {
        return gratitudeLogService.findById(id);
    }

    @PostMapping("/add")
    public GratitudeLog createGratitudeLog(@RequestParam("userId") Long userId,
                                           @RequestParam("gratitudeText") String gratitudeText) {
        return gratitudeLogService.create(userId, gratitudeText);
    }
}
