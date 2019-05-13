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
import java.util.TreeMap;

/**
 *
 * @author bruno.bencke
 * @author gabriel.frantz
 */

public class SecondProject {

    public static void main(String[] args) throws IOException, FileNotFoundException, IOException {

        calculoQuestao();        
        FileReader fileReader = new FileReader("game-reviews.csv");
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
        game.setScore(Double.parseDouble(array[3]));
        game.setGenre(array[4]);
        game.setEditors_choice(array[5]);
        game.setRelease_year(array[6]);
        //coloca jogo dentro do array de jogos daquele ano
        i.setGame(game);
        return i;
    }
}
