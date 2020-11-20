import java.util.Random;

public class Simulation {

    public static Terrain ter1 = new Terrain(10,10);

    public static void phaseInit(){
        System.out.println("PHASE 1:Initialisation de l'environnement:");
        // Faire loop sur liste ensuite
        // Initialisation : Créer l'environnement
        initRandomRessources("Roche", 5) ;
        initRandomRessources("Arbre", 5) ;
        // Affichage du terrain avec les ressources ajoutées
        System.out.println("Informations sur le terrain:\n"+ter1);
        ter1.affiche();
    }

    /** Permet de placer aléatoirement un nombre donné d'un type de ressource sur un Terrain.
     *
     * @param nom Correspond au nom du type de ressource à créer (exemple : Roche, Arbre,...)
     * @param m Correspond au nombre de ressource à créer
     */
    public static void initRandomRessources(String nom, int m){// puis int n pour les agents
        int compteobjet = 0; // Compteur du nombre de ressource/objet créé(e)s
        while (compteobjet < m) {
            // Génération aléatoire des coordonnées et de la quantité des Arbres à créer
            int x = new Random().nextInt(ter1.nbLignes); // Valeur aléatoire d'abscisse comprise entre 1 et m
            int y = new Random().nextInt(ter1.nbColonnes); // Valeur aléatoire d'ordonnée comprise entre 1 et m
            int q = new Random().nextInt(3)+1; // Valeur aléatoire de quantité comprise entre 1 et nb

            // Vérification si Vide, alors 
            if (ter1.caseEstVide(x,y)){
                Ressource res1 = new Ressource(nom,m);
                ter1.setCase(x,y,res1);
                compteobjet++ ;
            }
        }
        System.out.println("..."+m+" ressources "+nom+" ont été ajoutées...");
    }
}
