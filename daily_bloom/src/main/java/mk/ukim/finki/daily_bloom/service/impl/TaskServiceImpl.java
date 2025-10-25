package mk.ukim.finki.daily_bloom.service.impl;

import mk.ukim.finki.daily_bloom.domain.DTO.TaskDTO;
import mk.ukim.finki.daily_bloom.domain.Task;
import mk.ukim.finki.daily_bloom.domain.TaskType;
import mk.ukim.finki.daily_bloom.domain.User;
import mk.ukim.finki.daily_bloom.repository.TaskRepository;
import mk.ukim.finki.daily_bloom.service.TaskService;
import mk.ukim.finki.daily_bloom.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repo;
    private final UserService userService;

    public TaskServiceImpl(TaskRepository repo, UserService userService) {
        this.repo = repo;
        this.userService = userService;
    }

    @Override
    public Task create(TaskDTO taskDTO) {
        Task task = new Task();
        User user = userService.findById(taskDTO.getUserId()).orElse(null);
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setCategory(TaskType.valueOf(taskDTO.getCategory()));
        task.setStartTime(taskDTO.getStartTime());
        task.setEndTime(taskDTO.getEndTime());
        task.setDuration(taskDTO.getDuration());
        task.setUser(user);
        return repo.save(task);
    }

    @Override
    public Task update(Long taskId, TaskDTO taskDTO) {
        Task task = repo.findById(taskId).orElse(null);
        User user = userService.findById(taskDTO.getUserId()).orElse(null);
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setCategory(TaskType.valueOf(taskDTO.getCategory()));
        task.setStartTime(taskDTO.getStartTime());
        task.setEndTime(taskDTO.getEndTime());
        task.setDuration(taskDTO.getDuration());
        task.setUser(user);
        return repo.save(task);
    }

    @Override
    public Optional<Task> findById(Long taskId) {
        return repo.findById(taskId);
    }

    @Override
    public Task markDone(Long taskId) {
        Task task = repo.findById(taskId).orElse(null);
        task.setIsDone(true);
        return repo.save(task);
    }

    @Override
    public void delete(Long taskId) {
        Task task = repo.findById(taskId).orElse(null);
        repo.delete(task);
    }
}
