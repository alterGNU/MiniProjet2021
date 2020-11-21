/** Lance les différentes phase composant la simulation:
 *      - Phase d'initialisation
 *      - Phase de récolte
 *
 * @param T : Correspond au terrain sur lequel effectuer la simulation
 * @param tabRessource : Tableau contenant le nom et le nombre de ressources à ajouter au terrain
 * @param tabnom : Tableau contenant les noms (et donc le nombre) des Villageois à créer
 * @param tabVillageois : Tableau de villageois
 */
public class Simulation {

    private final Terrain T = new Terrain(10,10);
    private String[][] tabRessource;
    private String[] tabnom;
    private Villageois[] tabVillageois;

    /** Constructeur de Simulation.
     * Les simulations partage toutes un même terrain
     *
     * @param nom : Correspond au nom de la simulation
     * @param l : Correspond au nombre de ligne du terrain à générer et sur lequel faire les simulations
     * @param c : Correspond au nombre de colonne du terrain à générer et sur lequel faire les simulations
     */
    public Simulation(String[][] tab,String[] tabnom){
        this.tabRessource=tab;
        this.tabnom=tabnom;
    }

    public void phaseInit(){
        
        System.out.println("PHASE 1:Initialisation de l'environnement:");

        // Initialisation : Génére aléatoirement des cases sur lesquelles placer les ressources à partir d'un tableau de
        // ressource
        initRandomRessources(this.tabRessource) ;
        // Initialisation : Créer les villageois à partir d'un tableau de nom
        initVillageois(this.tabnom);
        // Affichage du terrain avec les ressources ajoutées
        System.out.println("Informations sur le terrain:\n"+T);
        T.affiche();
    }


    /** Initialisation des villageois:
     *   - 1 Créer les villageois à partir du tableau d'un tableau de nom
     * <ul>
     * <li> Créer les villageois à partir d'un tableau de nom
     * <li> Créer un tableau de villageois
     * </ul>
     *
     * @param tabnom Correspond a un tableau de nom à attribuer aux villageois
     */
    public void initVillageois(String[] tabnom){
       int taille = tabnom.length;
        Villageois tabVillageois[] = new Villageois[taille];
        for (int i=0; i<taille;i++){
        tabVillageois[i] = new Villageois(tabnom[i]);
        System.out.println(tabVillageois[i].toString());
        }
        System.out.println(Villageois.getCpt()+" villageois on été créé.");
    }


    /** Permet de placer aléatoirement un nombre donné d'un type de ressource sur un Terrain.
     *
     * @param nom Correspond au nom du type de ressource à créer (exemple : Roche, Arbre,...)
     * @param m Correspond au nombre de ressource à créer
     */
    public void initRandomRessources(String[][] tab){
        for (int i =0; i<tab.length; i++){
            String nom = tab[i][0];
            int m = Integer.parseInt(tab[i][1]);
            int compteobjet = 0; // Compteur du nombre de ressource/objet créé(e)s
            while (compteobjet < m) {
                // Génération aléatoire des coordonnées et de la quantité des Arbres à créer
                int x = Bao.NbrAlea(T.nbLignes); // Valeur aléatoire d'abscisse comprise entre 1 et m
                int y = Bao.NbrAlea(T.nbColonnes); // Valeur aléatoire d'ordonnée comprise entre 1 et m
                int q = Bao.NbrAlea(3); // Valeur aléatoire de quantité comprise entre 1 et 3
                //System.out.println("TIRÉ AU SORT:"+nom+".x."+x+".y."+y+".q."+q);

                // Vérification si Vide, alors 
                if (T.caseEstVide(x,y)){
                    Ressource res1 = new Ressource(nom,m);
                    T.setCase(x,y,res1);
                    //System.out.println(" AJOUTÉ :"+nom+".x."+x+".y."+y+".q."+q);
                    compteobjet++ ;
                }
                else{
                    //System.out.println("...Case non vide, recherche d'un autre emplacement...");
                }
            }
            System.out.println("..."+m+" ressources "+nom+" ont été ajoutées...");
        }
    }
}
