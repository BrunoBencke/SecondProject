package secondproject;

public class Game {

    private String title;
    private String platform;
    private String score_phrase;
    private Double score;
    private String genre;
    private String editors_choice;
    private String release_year;

    public Game(String title, String platform, String score_phrase, Double score, String genre, String editors_choice, String release_year) {
        this.title = title;
        this.platform = platform;
        this.score_phrase = score_phrase;
        this.score = score;
        this.genre = genre;
        this.editors_choice = editors_choice;
        this.release_year = release_year;
    }

    public Game() {

    }

    public Game(Game game) {
        populaGame(game);
    }

    private void populaGame(Game game) {
        this.title = game.getTitle();
        this.platform = game.getPlatform();
        this.score_phrase = game.getScore_phrase();
        this.score = game.getScore();
        this.genre = game.getGenre();
        this.editors_choice = game.getEditors_choice();
        this.release_year = game.getRelease_year();
    }

    public void setPosicaoScore(char sinal, Game game) {
        if (sinal == '+') {
            if (game.getScore() > this.getScore()) {
                this.populaGame(game);
            }
        } else if (sinal == '-') {
            if (game.getScore() < this.getScore()) {
                this.populaGame(game);
            }
        } else {
            System.out.println("Sinal Inválido!");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getScore_phrase() {
        return score_phrase;
    }

    public void setScore_phrase(String score_phrase) {
        this.score_phrase = score_phrase;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getEditors_choice() {
        return editors_choice;
    }

    public void setEditors_choice(String editors_choice) {
        this.editors_choice = editors_choice;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }
}
