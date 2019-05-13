package secondproject;

import java.util.TreeMap;

public class Reviews {
    private TreeMap<String, Integer> reviews;
    private TreeMap<String, Integer> plataforma;
    private int review;
    private Double score;
    private Double scoreTo2;
    private Double totalScore;
    private Game bestGame;
    private Game worstGame;

    public Reviews(String reviews, Double totalScore, Game bestGame, Game worstGame) {
        this.setReviews(reviews);
        this.review++;
        this.totalScore += totalScore;
        this.bestGame = bestGame;
        this.worstGame = worstGame;
    }

    public Reviews() {

    }

    public TreeMap<String, Integer> getReviews() {
        return reviews;
    }

    public void setReviews(String review) {
        if (this.reviews.containsKey(review)) {
            this.reviews.put(review, (1 + reviews.get(review)));
        } else {
            this.reviews.put(review, 1);
        }

    }

    public int getReview() {
        return review;
    }

    public void setReview() {
        this.review++;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public Game getBestGame() {
        return bestGame;
    }

    public void setBestGame(Game bestGame) {
        this.bestGame.setPosicaoScore('+', bestGame);
    }

    public Game getWorstGame() {
        return worstGame;
    }

    public void setWorstGame(Game worstGame) {
        this.worstGame.setPosicaoScore('-', worstGame);
    }

    public Double getScoreTo2() {
        return scoreTo2;
    }

    public void setReviewTo2(int scoreTo2) {
        this.scoreTo2 += Math.pow(scoreTo2, 2);
    }

    public TreeMap<String, Integer> getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        if (this.plataforma.containsKey(plataforma)) {
            this.plataforma.put(plataforma, this.plataforma.get(plataforma) + 1);
        } else {
            this.plataforma.put(plataforma, 1);
        }
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
