public class Grade {
    private Subject subject;
    private int score;

    public Grade(Subject subject, int score) {
        this.subject = subject;
        this.score = score;
    }

    public Subject getSubject() {
        return subject;
    }

    public int getScore() {
        return score;
    }
}
