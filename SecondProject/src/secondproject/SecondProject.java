/*

+ número de reviews deste ano
+ percentual de ‘Mediocre’ reviews (sobre o número de reviews deste ano)
+ média aritmética dos scores
+ desvio padrão populacional dos scores
+ melhor jogo (basta indicar um entre os de maior score)
+ pior jogo (basta indicar um entre os de menor score)
Ao final: qual o ano em que foi lançado um maior número de jogos do gênero ‘Action’?

 */
package secondproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author bruno.bencke
 * @author gabriel.frantz
 */
public class SecondProject {

    public static void main(String[] args) {
        calculoQuestao();
        SecondProject obj = new SecondProject();
        obj.run();

    }

    public void run() {

        String arquivoCSV = "C:\\Users\\gabriel.frantz\\Documents\\NetBeansProjects\\SecondProject\\SecondProject\\src\\secondproject\\game-reviews.csv";
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ";";
        try {

            br = new BufferedReader(new FileReader(arquivoCSV));
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
                String[] pais = linha.split(csvDivisor);
                for (int i = 0; i < pais.length; i++) {
                   // System.out.println(pais[i]);

                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void calculoQuestao() {
        int calculo = (596129 + 596553) % 3;
        if (calculo == 0) {
            System.out.println(calculo + ". Sumarizar para cada gênero de jogo! ");
        } else if (calculo == 1) {
            System.out.println(calculo + ". Sumarizar para cada plataforma! ");
        } else {
            System.out.println(calculo + ". Sumarizar para cada ano de lançamento! ");
        }
    }
}
