package mk.ukim.finki.daily_bloom.service.impl;

import mk.ukim.finki.daily_bloom.domain.BudgetCategory;
import mk.ukim.finki.daily_bloom.domain.BudgetItem;
import mk.ukim.finki.daily_bloom.domain.BudgetType;
import mk.ukim.finki.daily_bloom.domain.DTO.BudgetItemDTO;
import mk.ukim.finki.daily_bloom.domain.User;
import mk.ukim.finki.daily_bloom.repository.BudgetItemRepository;
import mk.ukim.finki.daily_bloom.service.BudgetItemService;
import mk.ukim.finki.daily_bloom.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetItemServiceImpl implements BudgetItemService {

    private final BudgetItemRepository budgetItemRepository;
    private final UserService userService;

    public BudgetItemServiceImpl(BudgetItemRepository budgetItemRepository, UserService userService) {
        this.budgetItemRepository = budgetItemRepository;
        this.userService = userService;
    }

    @Override
    public BudgetItem create(BudgetItemDTO budgetItemDTO) {
        User user = userService.findById(budgetItemDTO.getUserId()).orElse(null);

        BudgetItem budgetItem = new BudgetItem();
        budgetItem.setUser(user);
        budgetItem.setDate(budgetItemDTO.getDate());
        budgetItem.setNote(budgetItemDTO.getNote());
        budgetItem.setAmount(budgetItemDTO.getAmount());
        budgetItem.setCategory(BudgetCategory.valueOf(budgetItemDTO.getCategory()));
        budgetItem.setType(BudgetType.valueOf(budgetItemDTO.getType()));
        return budgetItemRepository.save(budgetItem);
    }

    @Override
    public Optional<BudgetItem> findById(Long id) {
        return budgetItemRepository.findById(id);
    }

    @Override
    public List<BudgetItem> findAllByUser(Long userId) {
        return budgetItemRepository.findBudgetItemsByUserId(userId);
    }

    @Override
    public void delete(Long id) {
        budgetItemRepository.deleteById(id);
    }
}
