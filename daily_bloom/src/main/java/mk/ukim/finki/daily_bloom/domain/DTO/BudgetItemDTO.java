package mk.ukim.finki.daily_bloom.domain.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class BudgetItemDTO {
    @Setter
    private Long userId;
    private LocalDate date;
    private String note;
    private BigDecimal amount;
    @Setter
    private String category;
    private String type;

    public BudgetItemDTO() {

    }

    public BudgetItemDTO(Long userId, LocalDate date, String note, BigDecimal amount, String category, String type) {
    this.userId = userId;
    this.date = date;
    this.note = note;
    this.amount = amount;
    this.category = category;
    this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getNote() {
        return note;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

}
