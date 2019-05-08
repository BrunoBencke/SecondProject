package secondproject;

public class Reviews {
    private static int totalScore; // total de reviews deste ano
    private static float scorePhr; // percentual de mediocre do ano
    private static float mediaScores; // media dos scores(notas)
    private static float desvioPadraoScores; //desvio padrão populacional dos scores
    private static String bestGame; // um dos jogos com maior score
    private static String worstGame; // um dos jogos com pior score
    private static int countGenreAction;// contador jogos de acao deste ano

    public static int getTotalScore() {
        return totalScore;
    }

    public static void setTotalScore(int aTotalScore) {
        totalScore = aTotalScore;
    }

    public static float getScorePhr() {
        return scorePhr;
    }

    public static void setScorePhr(float aScorePhr) {
        scorePhr = aScorePhr;
    }

    public static float getMediaScores() {
        return mediaScores;
    }

    public static void setMediaScores(float aMediaScores) {
        mediaScores = aMediaScores;
    }

    public static float getDesvioPadraoScores() {
        return desvioPadraoScores;
    }

    public static void setDesvioPadraoScores(float aDesvioPadraoScores) {
        desvioPadraoScores = aDesvioPadraoScores;
    }

    public static String getBestGame() {
        return bestGame;
    }

    public static void setBestGame(String aBestGame) {
        bestGame = aBestGame;
    }

    public static String getWorstGame() {
        return worstGame;
    }

    public static void setWorstGame(String aWorstGame) {
        worstGame = aWorstGame;
    }

    public static int getCountGenreAction() {
        return countGenreAction;
    }

    public static void setCountGenreAction(int aCountGenreAction) {
        countGenreAction = aCountGenreAction;
    }
}
