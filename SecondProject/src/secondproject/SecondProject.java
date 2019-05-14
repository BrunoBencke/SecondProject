/*

 + número de reviews deste ano
 + percentual de ‘Mediocre’ reviews (sobre o número de reviews deste ano)
 + média aritmética dos scores
 + desvio padrão populacional dos scores
 + melhor Game (basta indicar um entre os de maior score)
 + pior Game (basta indicar um entre os de menor score)
 Ao final: qual o ano em que foi lançado um maior número de Games do gênero ‘Action’?

 */
package secondproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author bruno.bencke
 * @author gabriel.frantz
 */
public class SecondProject {

    public static void main(String[] args) throws IOException, FileNotFoundException, IOException {

        calculoQuestao();
        FileReader fileReader = new FileReader("game-reviews_NOVO.csv");
        BufferedReader br = new BufferedReader(fileReader);
        String linha = br.readLine(); // leitura da primeira linha/cabeçalho do excel
        String[] rowExcel;

        TreeMap<String, GamesOfYear> dictionary = new TreeMap();

        GamesOfYear games;

        while (linha != null) {

            rowExcel = linha.split(";");
            games = new GamesOfYear();

            if (dictionary.containsKey(rowExcel[6])) {
                //pega dicionario que o item deve ser adicionado
                games = dictionary.get(rowExcel[6]);
                //coloca o item no dicionario
                dictionary.put(rowExcel[6], popular(games, rowExcel));
            } else {
                //coloca o item em um novo dicionario
                dictionary.put(rowExcel[6], popular(games, rowExcel));
            }
            linha = br.readLine();
        }
        fileReader.close();
    }

    public static void calculoQuestao() {
        int calculo = (596129 + 596553) % 3;
        if (calculo == 0) {
            System.out.println(calculo + ". Sumarizar para cada gênero de Game! ");
        } else if (calculo == 1) {
            System.out.println(calculo + ". Sumarizar para cada plataforma! ");
        } else {
            System.out.println(calculo + ". Sumarizar para cada ano de lançamento! ");
        }
    }

    public static GamesOfYear popular(GamesOfYear i, String[] array) {
        Game game = new Game();
        //preenche jogo com linha lida
        game.setTitle(array[0]);
        game.setPlatform(array[1]);
        game.setScore_phrase(array[2]);
        System.out.println(array[3]);
        game.setScore(Double.parseDouble(array[3]));
        game.setGenre(array[4]);
        game.setEditors_choice(array[5]);
        game.setRelease_year(array[6]);
        //coloca jogo dentro do array de jogos daquele ano
        i.setGame(game);
        return i;
    }

    public static void totalReviewsPorAno(TreeMap<String, GamesOfYear> table) {
        System.out.println("\n\tNumero de reviews por ano");
        int cont = 0;
        for (String k : table.keySet()) {
            cont++;
            System.out.println(cont + "\t" + k + " = " + table.get(k).getGames().size());
        }
    }

    public static void totalReviewsCriterio(TreeMap<String, GamesOfYear> table, String criterio) {
        System.out.println("\n\tNumero de '" + criterio + "'reviews");
        int cont = 0;
        for (String k : table.keySet()) {
            for (int i = 0; i < table.get(k).getGames().size(); i++) {
                if (table.get(k).getGames().get(i).getScore_phrase().equals(criterio)) {
                    cont++;
                }
            }
        }
        System.out.println("Resultado:\t" + criterio + " = " + cont);
    }

    public static void percentualReviewVsAll(TreeMap<String, GamesOfYear> table, String criterio) {
        System.out.println("\n\tPercentual de '" + criterio + "'");
        int cont = 0;
        int all = 0;
        for (String k : table.keySet()) {
            for (int i = 0; i < table.get(k).getGames().size(); i++) {
                if (table.get(k).getGames().get(i).getScore_phrase().equals(criterio)) {
                    cont++;
                }
            }
            all += table.get(k).getGames().size();
        }

        Double percentual = (cont * (100.0 / all));
        System.out.println("Resultado:\t" + criterio + " = " + percentual + " %");

    }

    public static Double mediaScore(TreeMap<String, GamesOfYear> table) {
//        System.out.println("\n\tMédia dos Score");
        int cont = 0;
        Double score = 0.0;
        for (String k : table.keySet()) {
            for (int i = 0; i < table.get(k).getGames().size(); i++) {
                score += table.get(k).getGames().get(i).getScore();
                cont++;
            }
        }
        return score / cont;
    }

    public static void desvioPadrao(TreeMap<String, GamesOfYear> table) {
        System.out.println("\n\tDesvio padrão dos Scores:");
        ArrayList<Double> v = new ArrayList();
        Double media = mediaScore(table);
        Double temp;
        for (String k : table.keySet()) {
            for (int i = 0; i < table.get(k).getGames().size(); i++) {
                temp = ((table.get(k).getGames().get(i).getScore()) - media) * ((table.get(k).getGames().get(i).getScore()) - media);
                v.add(temp);
            }
        }
        Double variancia = 0.0;
        for (int i = 0; i < v.size(); i++) {
            variancia += v.get(i);
        }

        variancia = variancia / (v.size() - 1);

        System.out.println("Desvio Padrão = \t" + Math.sqrt(variancia));
    }

    public static void bestAndWorstGame(TreeMap<String, GamesOfYear> table) {
        System.out.println("\n\tMelhor e Pior Jogo:");
        Game bestGame = new Game();
        bestGame.setScore(0.0);
        Game worstGame = new Game();
        worstGame.setScore(10.0);
        int cont = 0;
        for (String k : table.keySet()) {
            for (int i = 0; i < table.get(k).getGames().size(); i++) {
                bestGame.setPosicaoScore('+', table.get(k).getGames().get(i));
                worstGame.setPosicaoScore('-', table.get(k).getGames().get(i));
            }
        }

        System.out.println("Melhor jogo =>\t" + bestGame.getTitle() + " - " + bestGame.getPlatform() + " - " + bestGame.getScore());
        System.out.println("Pior Jogo   =>\t" + worstGame.getTitle() + " - " + worstGame.getPlatform() + " - " + worstGame.getScore());

    }
}
