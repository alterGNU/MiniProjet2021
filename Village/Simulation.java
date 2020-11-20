/** Lance les différentes phase composant la simulation:
 *      - Phase d'initialisation
 *      - Phase de récolte
 *
 * @param T : Correspond au terrain sur lequel effectuer la simulation
 * @param tabRessource : Tableau contenant le nom et le nombre de ressources à ajouter au terrain
 * @param listVillageois : Liste contenant les noms (et donc le nombre) des Villageois 
 */
public class Simulation {

    private Terrain T=new Terrain(10,10);
    private String[][] tabRessource;
    private listVillageois;

    /** Constructeur de Simulation.
pa     * Les simulations partage toutes un même terrain
     *
     * @param nom : Correspond au nom de la simulation
     * @param l : Correspond au nombre de ligne du terrain à générer et sur lequel faire les simulations
     * @param c : Correspond au nombre de colonne du terrain à générer et sur lequel faire les simulations
     */
    public Simulation(String[][] tabRessource, listVillageois){
        this.tabRessource=tabRessource;
        this.listVillageois=listVillageois;
        Simulation.phaseInit();
    }

    public void phaseInit(){
        System.out.println("PHASE 1:Initialisation de l'environnement:");

        // Initialisation : Créer l'environnement
        initRandomRessources(tabRessource) ;

        // Affichage du terrain avec les ressources ajoutées
        System.out.println("Informations sur le terrain:\n"+T);
        T.affiche();
    }

    /** Permet de placer aléatoirement un nombre donné d'un type de ressource sur un Terrain.
     *
     * @param nom Correspond au nom du type de ressource à créer (exemple : Roche, Arbre,...)
     * @param m Correspond au nombre de ressource à créer
     */
    public void initRandomRessources(){// puis int n pour les agents
        for (int i =0; i<this.tab.length; i++){
            String nom = this.tab[i][0];
            int m = Integer.parseInt(this.tab[i][1]);
            int compteobjet = 0; // Compteur du nombre de ressource/objet créé(e)s
            while (compteobjet < m) {
                // Génération aléatoire des coordonnées et de la quantité des Arbres à créer
                int x = Bao.NbrAlea(T.nbLignes); // Valeur aléatoire d'abscisse comprise entre 1 et m
                int y = Bao.NbrAlea(T.nbColonnes); // Valeur aléatoire d'ordonnée comprise entre 1 et m
                int q = Bao.NbrAlea(3); // Valeur aléatoire de quantité comprise entre 1 et 3

                // Vérification si Vide, alors 
                if (T.caseEstVide(x,y)){
                    Ressource res1 = new Ressource(nom,m);
                    T.setCase(x,y,res1);
                    compteobjet++ ;
                }
            }
            System.out.println("..."+m+" ressources "+nom+" ont été ajoutées...");
        }
    }
}
