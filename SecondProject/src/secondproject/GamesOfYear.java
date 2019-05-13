package secondproject;

import java.util.ArrayList;

public class GamesOfYear {
    
    private ArrayList<Game> game = new ArrayList ();
    private Game best;
    private Game worst;

    public GamesOfYear() {
        
    }

    public ArrayList<Game> getGames() {
        return game;
    }

    public void setGame(Game game) {
        this.game.add(game);
    }

    public Game getBest() {
        return best;
    }

    public void setBest(Game best) {
        this.best.setPosicaoScore('+', best);
    }

    public Game getWorst() {
        return worst;
    }

    public void setWorst(Game worst) {
        this.worst.setPosicaoScore('-', worst);
    }
}
