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
        System.out.println("Initialisation de l'environnement\n");
		Terrain t = new Terrain(10,10);
		System.out.println("La valeur de Xmax du tableau t est "+ t.nbLignes );
		System.out.println("La valeur de Ymax du tableau t est "+ t.nbColonnes );
        
        /* 
         * Fabriquer 5 Arbres de quantité et localisation aléatoire
         * 
         * 1-Loop while vérifiant la disponibilité des cases se trouvant aux coordonnées générées aléatoirement
         * 2-Créer les 5 objets 
         * 
         */
        int nbrArbre = 0; // Compteur de
        while (nbrArbre < 5) {
            // Génération aléatoire des coordonnées et de la quantité des Arbres à créer
            int x = new Random().nextInt(t.nbLignes); // Valeur aléatoire d'abscisse comprise entre 1 et 5
            int y = new Random().nextInt(t.nbColonnes); // Valeur aléatoire d'ordonnée comprise entre 1 et 5
            int q = new Random().nextInt(3)+1; // Valeur aléatoire de quantité comprise entre 1 et 5

            System.out.println("Création de nouvelles coordonnées: ("+x+";"+y+") ainsi que de la quantité :"+q+".");

            // Vérification si Vide, alors 
            if (t.caseEstVide(x,y)){
                Ressource res1 = new Ressource("Arbre",5);
                t.setCase(x,y,res1);
                System.out.println("Ajout aux coordonnées ("+x+";"+y+") la ressource "+ t.getCase(x,y) +" de quantité = "+q+" à la liste!");
                nbrArbre++ ;
            } else {
                System.out.println("Ajout impossible car les coordonnées corresponde à une case non vide du tableau!");
                System.out.println("...Recherche d'une autre case...");
            }

        }

		// Affichage du terrain avec les ressources ajoutées
		t.affiche();
		// Informations sur le terrain
		System.out.println("Informations sur le terrain:\n"+t);
    }
}
