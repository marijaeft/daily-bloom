package mk.ukim.finki.daily_bloom.service;

import mk.ukim.finki.daily_bloom.domain.DTO.TaskDTO;
import mk.ukim.finki.daily_bloom.domain.Task;
import mk.ukim.finki.daily_bloom.domain.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task create(TaskDTO taskDTO);
    Task update(Long taskId, TaskDTO taskDTO);
    Optional<Task> findById(Long taskId);
//    List<Task> findByUser(User user);
//    List<Task> findByDateRange(User user, LocalDateTime start, LocalDateTime end);
    Task markDone(Long taskId);
    void delete(Long taskId);
}
