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

/**
 *
 * @author bruno.bencke
 * @author gabriel.frantz
 */
public class SecondProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
