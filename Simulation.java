import java.util.Random;

/**
 * @author Laurent GRONDIN
 * 
 */
public class Simulation {
	/**
	 * @param args
	 */
    public static void main(String[] args) {
        // Initialisation : Créer l'environnement
        System.out.println("Initialisation de l'environnement\n");
		Terrain ter1 = new Terrain(10,10);
        initRandomRessources(ter1,"Roche", 5) ;
        initRandomRessources(ter1,"Arbre", 5) ;
        // Affichage du terrain avec les ressources ajoutées
        ter1.affiche();
        System.out.println("Informations sur le terrain:\n"+ter1);
    }

    /** Permet de placer aléatoirement un nombre donné d'un type de ressource sur un Terrain.
     *
     * @param t Correspond au terrain sur lequel placer les ressources
     * @param nom Correspond au nom du type de ressource à créer (exemple : Roche, Arbre,...)
     * @param nb Correspond au nombre de ressource à créer
     */
    public static void initRandomRessources(Terrain t,String nom, int nb){
        int compteobjet = 0; // Compteur du nombre de ressource/objet créé(e)s
        while (compteobjet < nb) {
            // Génération aléatoire des coordonnées et de la quantité des Arbres à créer
            int x = new Random().nextInt(t.nbLignes); // Valeur aléatoire d'abscisse comprise entre 1 et nb
            int y = new Random().nextInt(t.nbColonnes); // Valeur aléatoire d'ordonnée comprise entre 1 et nb
            int q = new Random().nextInt(3)+1; // Valeur aléatoire de quantité comprise entre 1 et nb

            System.out.println("Création de nouvelles coordonnées: ("+x+";"+y+") ainsi que de la quantité :"+q+".");

            // Vérification si Vide, alors 
            if (t.caseEstVide(x,y)){
                Ressource res1 = new Ressource(nom,nb);
                t.setCase(x,y,res1);
                System.out.println("Ajout aux coordonnées ("+x+";"+y+") la ressource "+ t.getCase(x,y) +" de quantité = "+q+" à la liste!");
                compteobjet++ ;
            } else {
                System.out.println("Ajout impossible car les coordonnées corresponde à une case non vide du tableau!");
                System.out.println("...Recherche d'une autre case...");
            }

        }

    }
}
