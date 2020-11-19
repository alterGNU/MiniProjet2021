import java.util.Random;
import java.io.*;

/**
 * @author Laurent GRONDIN
 * 
 */
public class Simulation {
    // Permet de cleaner l'écran du terminal
    public static final char ESC = 27;

    /**
     * @param args
     */
    public static void main(String[] args)
            throws Exception {
            Console c = System.console();
            if (c == null) {
                System.err.println("no console");
                System.exit(1);
            }

            // Nettoye l'écran un première fois
            System.console().writer().print(ESC + "[2J");
            System.console().flush();
            Thread.sleep(500);

            // Initialisation : Créer l'environnement
            Terrain ter1 = new Terrain(10,10);

            // AFFICHER-CLEAN
            System.console().writer().print(ESC + "[1;1H");
            System.console().flush();
            System.out.println("PHASE : INITIALISATION DÉBUT");
            ter1.affiche();
            System.out.println("Ressources du village : ");
            Thread.sleep(1000);
            
            initRandomRessources(ter1,"Roche", 5) ;
            initRandomRessources(ter1,"Arbre", 5) ;
            
            // AFFICHER-CLEAN
            System.console().writer().print(ESC + "[1;1H");
            System.console().flush();
            System.out.println("PHASE : INITIALISATION TERMINÉE");
            ter1.affiche();
            System.out.println("Ressources Disponibles : ");
            System.out.println("Ressources Collectées : ");
    }

    /** Permet de placer aléatoirement un nombre donné d'un type de ressource sur un Terrain.
     *
     * @param t Correspond au terrain sur lequel placer les ressources
     * @param nom Correspond au nom du type de ressource à créer (exemple : Roche, Arbre,...);
     * @param nb Correspond au nombre de ressource à créer
     */
    public static void initRandomRessources(Terrain t,String nom, int nb){
        int compteobjet = 0; // Compteur du nombre de ressource/objet créé(e)s
            while (compteobjet < nb) {
                // Génération aléatoire des coordonnées et de la quantité des Arbres à créer
                int x = new Random().nextInt(t.nbLignes); // Valeur aléatoire d'abscisse comprise entre 1 et nb
                int y = new Random().nextInt(t.nbColonnes); // Valeur aléatoire d'ordonnée comprise entre 1 et nb
                int q = new Random().nextInt(3)+1; // Valeur aléatoire de quantité comprise entre 1 et nb

                //System.out.println("Création de nouvelles coordonnées: ("+x+";"+y+") ainsi que de la quantité :"+q+".");

                // Vérification si Vide, alors 
                try{
                    if (t.caseEstVide(x,y)){
                        Ressource res1 = new Ressource(nom,nb);
                        t.setCase(x,y,res1);
                        // AFFICHER-CLEAN
                        System.console().writer().print(ESC + "[1;1H");
                        System.console().flush();
                        System.out.println("PHASE : INITIALISATION EN COURS");
                        t.affiche();
                        System.out.println("Ressources du village : ");
                        Thread.sleep(250);
                        compteobjet++ ;
                    }
                }catch(InterruptedException ex){
            }
        }
    }
}
