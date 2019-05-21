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
        }
    }
}
