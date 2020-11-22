/** Classe Bao : Boite-à-outils
 * Classe statique contenant des méthodes statiques
 */
public class Bao {

    /** Constructeur vide permettant d'interdire l'instanciation de cette classe d'outils
    */
    private Bao(){
    }

    /** Methode permettant de fournir un nombre d'entier naturel compris entre le min et le max fournis
     *
     * @param min Correspond au minimum (inclu)
     * @param max Correspond au maximum (exclu)
     */
    public static int nbrAleatoire(int min,int max){
        return ((int) (Math.random() * (max - min) + min));
    }

    /** Permet de calculer la somme du contenu d'un tableau d'entier
     * 
     * @param itab Tableau d'entier
     */ 
    public static int sommeTabEntier(int[] itab){
        int total =0;
        for (int i=0; i<itab.length; i++){
            total += itab[i];
        }
        return total;
    }

    /** Permet de calculer la distance, en nombre de déplacement, entre le village est une case du terrain
     * On décide de placer le village à la case (-1,-1), il se trouve donc à l'exterieur du terrain
     * @param x Correspond à l'abscisse de la case
     * @param y Correspond à l'ordonnée de la case
     */ 
    public static int distVillage(int x,int y){return 1+x+y;}

    /** Permet de calculer la distance la plus courte possible entre le village est une case du terrain(en nombre de
     * déplacement)
     * @param x Correspond à l'abscisse de la case
     * @param y Correspond à l'ordonnée de la case
     */ 
    public static int distVillageOpti(int x,int y){return (Math.min(x,y)+1);}

    /** Permet de calculer le nombre total de ressource à créer à partir du tableau d'initialisation de ressource
     * 
     * @param stab Correspond au tableau d'initialisation des ressources (Tableau de String à deux dimensions)
     */ 
    public static int nbrRessourceTotal(String[][] stab){
        int total =0;
        for (int t=0; t<stab.length; t++){
            total += Integer.parseInt(stab[t][1]);
        }
        return total;
    }

}
