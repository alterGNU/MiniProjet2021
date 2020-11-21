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
    public static int NbrAlea(int min,int max){
        return ((int) (Math.random() * (max - min) + min));
    }

    ///** Methode permettant d'afficher le contenu d'un tableau de String
    // *
    // * @param obj Correspond au type d'objet à afficher
    // * retournés
    // */
    //public static void afficheTableauString(String type,String nom){
    //    for (type[] tab: nom){
    //        for (String s: tab){
    //            System.out.print(s + "\t");
    //        }
    //        System.out.println("\n");
    //    }

}
