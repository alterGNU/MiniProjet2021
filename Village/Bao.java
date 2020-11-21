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
        return ((int) (Math.random() * (max)));
    }

    ///** Methode permettant d'afficher le contenu d'un tableau d'objet
    // *
    // * @param obj Correspond au type d'objet à afficher
    // * retournés
    // */
    //public static void afficheTableauObjet(
        //Loop permettant d'afficher un tableau de string
        //for (String[] tab: ressource){
        //    for (String s: tab){
        //        System.out.print(s + "\t");
        //    }
        //    System.out.println("\n");
        //}

}
