package mk.ukim.finki.daily_bloom.repository;

import mk.ukim.finki.daily_bloom.domain.BudgetItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetItemRepository extends JpaRepository<BudgetItem,Long> {
    List<BudgetItem> findBudgetItemsByUserId(Long userId);

    void deleteById(Long id);
}
