package mk.ukim.finki.daily_bloom.domain.DTO;

public class WeeklyReflectionDTO {
    private String question1;
    private String question2;
    private String question3;
    private String question4;
    private Long userId;

    public WeeklyReflectionDTO() {
    }

    public WeeklyReflectionDTO(String question1, String question2, String question3, String question4, Long userId) {
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
        this.question4 = question4;
        this.userId = userId;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    public String getQuestion4() {
        return question4;
    }

    public void setQuestion4(String question4) {
        this.question4 = question4;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
