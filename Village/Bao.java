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
    public static int NbrAleatoire(int min,int max){
        return ((int) (Math.random() * (max - min) + min));
    }


    /** Permet de calculer la somme du contenu d'un tableau d'entier
     * 
     * @param itab Tableau d'entier
     */ 
    public static int SommeTabEntier(int[] itab){
        int total =0;
        for (int i=0; i<itab.length; i++){
            total += itab[i];
        }
        return total;
    }

    /** Permet de calculer le nombre total de ressource à créer à partir du tableau d'initialisation de ressource
     * 
     * @param stab Correspond au tableau d'initialisation des ressources (Tableau de String à deux dimensions)
     */ 
    public static int NbrRessourceTotale(String[][] stab){
        int total =0;
        for (int t=0; t<stab.length; t++){
            total += Integer.parseInt(stab[t][1]);
        }
        return total;
    }

}
