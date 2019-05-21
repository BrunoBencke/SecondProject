package secondproject;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Reviews {

    ArrayList<Double> scores;
    Map<String, Double> games;
    int reviews;
    int mediocres;
    int contAction;
    double percentualMediocres;
    double score;
    double bestScore;
    double worstScore;
    String bestGame;
    String worstGame;

   public Reviews(Double score, String nome) {
        this.reviews = 0;
        this.percentualMediocres = 0;
        this.bestGame = nome;
        this.bestScore = score;
        this.worstGame = nome;
        this.worstScore = score;
        this.scores = new ArrayList();
        this.scores.add(score);
        this.contAction = 0;
        this.games = new TreeMap<String, Double>();
    }

    public void addGame(String game, Double score) {
        this.games.put(game, score);
    }

    public void score(double score) {
        this.score = this.score + score;
    }

    public void addScore(Double s) {
        this.scores.add(s);
    }

    public void contReview() {
        this.reviews++;
    }

    public void contMediocres(String score) {
        if (score.equals("Mediocre")) {
            this.mediocres++;
        }
    }

    public void bestGame(double score, String nameGame) {
        if (score > this.bestScore) {
            this.bestScore = score;
            this.bestGame = nameGame;
        }
    }

    public void worstGame(double score, String nameGame) {
        if (score < this.worstScore) {
            this.worstScore = score;
            this.worstGame = nameGame;
        }
    }

    public double desvioPadrao() {
        double soma = 0;
        for (int i = 0; i < this.scores.size(); i++) {
            soma = soma + Math.pow(this.scores.get(i) - this.mediaScore(), 2);
        }
        return Math.sqrt(soma / this.reviews);
    }

    public Double mediaScore() {
        return score / reviews;
    }

    public String percentualMediocre() {
        return (this.mediocres * 100 / this.reviews) + "%";
    }

    public void addAction(String score, String game) {
        if (score.equals("Action") && !this.games.containsKey(game)) {
            this.contAction++;
        }
    }
}
