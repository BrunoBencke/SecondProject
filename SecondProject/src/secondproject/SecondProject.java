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
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author bruno.bencke
 * @author gabriel.frantz
 */
public class SecondProject {

    public static void main(String[] args) throws IOException, FileNotFoundException {
//        SimpleReader f = new SimpleReader(archive);
//        String s = f.readLine();
//        s = f.readLine();
        FileReader fileReader = new FileReader("game-reviews.csv");
        BufferedReader br = new BufferedReader(fileReader);
        String s = br.readLine();
        Map<Integer, Reviews> map = new TreeMap<Integer, Reviews>();
        while (s != null) {
            String[] vets = s.split(";");
            String nome = vets[0];
            String avaliacao = vets[2];
            Double score = Double.parseDouble(vets[3]);
            String genero = vets[4];
            int ano = Integer.parseInt(vets[6]);
            Reviews control = null;
            if (!map.containsKey(ano)) {
                control = new Reviews(score, nome);
            } else {
                control = map.get(ano);
            }
            control.contReview();
            control.contMediocres(avaliacao);
            control.score(score);
            control.bestGame(score, nome);
            control.worstGame(score, nome);
            control.addScore(score);
            control.addAction(genero, nome);
            control.addGame(nome, score);
            map.put(ano, control);
            s = br.readLine();
        }
        Set<Integer> anos = map.keySet();
        int qtdAction = 0;
        int AnoAction = 0;
        for (int ano : anos) {
            System.out.println("\n");
            System.out.println("Ano: " + ano);
            System.out.println("Número de reviews: " + map.get(ano).reviews + "");
            System.out.println("Percentual de 'Mediocre': " + map.get(ano).mediocres + " : " + map.get(ano).percentualMediocre());
            System.out.println("Média aritmética: " + map.get(ano).mediaScore() + "");
            System.out.println("Desvio padrão: " + map.get(ano).desvioPadrao());
            System.out.println("Melhor jogo: " + map.get(ano).bestGame + ": " + map.get(ano).bestScore);
            System.out.println("Pior jogo: " + map.get(ano).worstGame + ": " + map.get(ano).worstScore);
            if (map.get(ano).contAction > qtdAction) {
                qtdAction = map.get(ano).contAction;
                AnoAction = ano;
            }
        }
        System.out.println("");
        System.out.println("Ano em que foi lançado um maior número de jogos do gênero ‘Action’: " + AnoAction);
    }
}
