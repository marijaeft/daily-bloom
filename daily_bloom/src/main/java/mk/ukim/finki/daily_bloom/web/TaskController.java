package mk.ukim.finki.daily_bloom.web;

import mk.ukim.finki.daily_bloom.domain.DTO.TaskDTO;
import mk.ukim.finki.daily_bloom.domain.Task;
import mk.ukim.finki.daily_bloom.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public Optional<Task> getTask(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @PostMapping("/add")
    public Task createTask(@RequestParam("title") String title,
                           @RequestParam(value = "description", required = false) String description,
                           @RequestParam("category") String category,
                           @RequestParam("startTime") LocalDateTime startTime,
                           @RequestParam("endTime") LocalDateTime endTime,
                           @RequestParam("duration") Integer duration,
                           @RequestParam("userId") Long userId) {
        TaskDTO dto = new TaskDTO(title, description, category, startTime, endTime, duration, userId);
        return taskService.create(dto);
    }

    @PutMapping("/update/{id}")
    public Task updateTask(@PathVariable Long id,
                           @RequestParam("title") String title,
                           @RequestParam(value = "description", required = false) String description,
                           @RequestParam("category") String category,
                           @RequestParam("startTime") LocalDateTime startTime,
                           @RequestParam("endTime") LocalDateTime endTime,
                           @RequestParam("duration") Integer duration,
                           @RequestParam("userId") Long userId) {
        TaskDTO dto = new TaskDTO(title, description, category, startTime, endTime, duration, userId);
        return taskService.update(id, dto);
    }

    @PatchMapping("/done/{id}")
    public Task markTaskAsDone(@PathVariable Long id) {
        return taskService.markDone(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
