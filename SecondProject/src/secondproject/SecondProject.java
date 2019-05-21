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

                totalReviewsPorAno(dictionary);

                percentualReviewVsAll(dictionary, "Mediocre");

                System.out.println("\nMédia dos Scores = " + mediaScore(dictionary));
                desvioPadrao(dictionary);

            } else {
                //coloca o item em um novo dicionario
                dictionary.put(rowExcel[6], popular(games, rowExcel));
            }
            linha = br.readLine();
        }
        fileReader.close();
        bestAndWorstGame(dictionary);
        totalReviewsGenero(dictionary, "Action");
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
        game.setScore(Double.parseDouble(array[3]));
        game.setGenre(array[4]);
        game.setEditors_choice(array[5]);
        game.setRelease_year(array[6]);
        //coloca jogo dentro do array de jogos daquele ano
        i.setGame(game);
        return i;
    }

    public static void totalReviewsPorAno(TreeMap<String, GamesOfYear> table) {
        System.out.println("\nNÚMERO DE REVIEWS EM CADA ANO: ");
        int cont = 0;
        for (String k : table.keySet()) {
            cont++;
            System.out.println(cont + ". " + k + " = " + table.get(k).getGames().size() + " reviews");
        }
    }

    public static void maiorLancamentoGenero(TreeMap<String, GamesOfYear> table, String criterio) {
        int cont = 0;
        for (String k : table.keySet()) {
            for (int i = 0; i < table.get(k).getGames().size(); i++) {
                if (table.get(k).getGames().get(i).getGenre().equals(criterio)) {
                    cont++;
                }
            }
        }
        System.out.println("Jogos no Genero: " + criterio + " = " + cont + " No ano de ");
    }

    public static void totalReviewsGenero(TreeMap<String, GamesOfYear> table, String criterio) {
        System.out.println("\nNÚMERO DE '" + criterio + "' REVIEWS: ");
        int cont = 0;
        int temp = 0;
        String ano = null;
        String anoTemp = null;
        do {
            for (String k : table.keySet()) {
                for (int i = 0; i < table.get(k).getGames().size(); i++) {
                    if (table.get(k).getGames().get(i).getGenre().equals(criterio)) {
                        cont++;
                        ano = table.get(k).getGames().get(i).getRelease_year();
                    }
                }
            }
            ano = anoTemp;
            cont = temp;
        } while (cont > temp);
        System.out.println("Resultado: " + criterio + " = " + cont + " reviews" + anoTemp);
    }

    public static void percentualReviewVsAll(TreeMap<String, GamesOfYear> table, String criterio) {
        System.out.println("\nPERCENTUAL DE '" + criterio + "': ");
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
        System.out.println("Resultado: " + criterio + " = " + percentual + "%");

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
        System.out.println("\nDESVIO PADRÃO DOS SCORES: ");
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

        System.out.println("Desvio Padrão = " + Math.sqrt(variancia));
    }

    public static void bestAndWorstGame(TreeMap<String, GamesOfYear> table) {
        System.out.println("\nMELHOR JOGO E PIOR JOGO:");
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

        System.out.println("Melhor Jogo: " + bestGame.getTitle() + "\nPlataforma: " + bestGame.getPlatform() + "\nScore:" + bestGame.getScore() + "\n");
        System.out.println("Pior Jogo: " + worstGame.getTitle() + "\nPlataforma: " + worstGame.getPlatform() + "\nScore:" + worstGame.getScore());

    }
}
