package mk.ukim.finki.daily_bloom.service;

import mk.ukim.finki.daily_bloom.domain.BudgetItem;
import mk.ukim.finki.daily_bloom.domain.DTO.BudgetItemDTO;

import java.util.List;
import java.util.Optional;

public interface BudgetItemService {
    BudgetItem create(BudgetItemDTO budgetItemDTO);
    Optional<BudgetItem> findById(Long id);
    List<BudgetItem> findAllByUser(Long userId);
//    List<BudgetItem> findByDateRange(Long userId, LocalDate start, LocalDate end);
    void delete(Long id);
}
