package mk.ukim.finki.daily_bloom.domain;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mood_daily",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "mood_date"}))
public class MoodLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mood_id")
    private Long id;

    @Column(name = "mood_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date moodDate;

    @Column(name = "mood_rate", nullable = false)
    private Integer moodRate;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private MoodCategory moodCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public void setMoodRate(Integer moodRate) {
        this.moodRate = moodRate;
    }

    public void setMoodCategory(MoodCategory moodCategory) {
        this.moodCategory = moodCategory;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
