/** Classe Bao : Boite-à-outils
 * Classe statique contenant des méthodes statiques
 */
public class Bao {

    /** Constructeur vide permettant d'interdire l'instanciation de cette classe d'outils
     */
   private Bao(){
   }

    /** Methode permettant de fournir un nombre compris entre 1 et le nombre fourni
     *
     * @param max Correspond à la borne supérieur de l'intervalle dans lequel générer les entiers aléatoirement
     * retournés
     */
   public static int NbrAlea(int max){
       return (1 + (int) (Math.random() * (max)));
   }

}
