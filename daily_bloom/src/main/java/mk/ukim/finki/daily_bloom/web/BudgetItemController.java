package mk.ukim.finki.daily_bloom.web;

import jakarta.persistence.*;
import mk.ukim.finki.daily_bloom.domain.BudgetCategory;
import mk.ukim.finki.daily_bloom.domain.BudgetItem;
import mk.ukim.finki.daily_bloom.domain.BudgetType;
import mk.ukim.finki.daily_bloom.domain.DTO.BudgetItemDTO;
import mk.ukim.finki.daily_bloom.domain.User;
import mk.ukim.finki.daily_bloom.service.BudgetItemService;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/budget-item")
public class BudgetItemController {
    private final BudgetItemService budgetItemService;

    public BudgetItemController(BudgetItemService budgetItemService) {
        this.budgetItemService = budgetItemService;
    }

    @GetMapping("/{userId}")
    public List<BudgetItem> getBudgetItemsByUser(@PathVariable Long userId) {
        return budgetItemService.findAllByUser(userId);
    }

    @GetMapping("/{id}")
    public Optional<BudgetItem> getBudgetItem(@PathVariable Long id) {
        return budgetItemService.findById(id);
    }

    @PostMapping("/add")
    public BudgetItem createBudgetItem(@RequestParam("userId") Long userId,
                                       @RequestParam("date") LocalDate date,
                                       @RequestParam("note") String note,
                                       @RequestParam("amount") BigDecimal amount,
                                       @RequestParam("category") String category,
                                       @RequestParam("type") String type) {
        BudgetItemDTO budgetItemDTO = new BudgetItemDTO(userId, date, note, amount, category, type);
        return budgetItemService.create(budgetItemDTO);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteBudgetItem(@PathVariable Long id) {
        budgetItemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
