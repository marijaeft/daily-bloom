package mk.ukim.finki.daily_bloom.service;

import mk.ukim.finki.daily_bloom.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User register(User user);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    List<User> findAll();
    void delete(Long id);
}
