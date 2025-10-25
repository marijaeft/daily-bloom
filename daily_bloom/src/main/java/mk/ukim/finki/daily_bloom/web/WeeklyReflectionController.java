package mk.ukim.finki.daily_bloom.web;

import mk.ukim.finki.daily_bloom.domain.DTO.WeeklyReflectionDTO;
import mk.ukim.finki.daily_bloom.domain.WeeklyReflection;
import mk.ukim.finki.daily_bloom.service.WeeklyReflectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/weekly-reflection")
public class WeeklyReflectionController {

    private final WeeklyReflectionService weeklyReflectionService;

    public WeeklyReflectionController(WeeklyReflectionService weeklyReflectionService) {
        this.weeklyReflectionService = weeklyReflectionService;
    }

    @GetMapping("/{id}")
    public Optional<WeeklyReflection> getWeeklyReflection(@PathVariable Long id) {
        return weeklyReflectionService.findById(id);
    }

    @PostMapping("/add")
    public WeeklyReflection createWeeklyReflection(
            @RequestParam("question1") String question1,
            @RequestParam("question2") String question2,
            @RequestParam("question3") String question3,
            @RequestParam("question4") String question4,
            @RequestParam("userId") Long userId) {

        WeeklyReflectionDTO dto = new WeeklyReflectionDTO(
                question1, question2, question3, question4, userId
        );

        return weeklyReflectionService.create(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWeeklyReflection(@PathVariable Long id) {
        weeklyReflectionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
