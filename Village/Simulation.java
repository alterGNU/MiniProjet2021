/** Lance les différentes phase composant la simulation:
 * <ul>
 * <li> Phase d'initialisation
 * <li> Phase de récolte
 * </ul>
 *
 * @param T : Correspond au terrain sur lequel effectuer la simulation
 * @param tabInitRessource : Tableau contenant le nom et le nombre de ressources à ajouter au terrain
 * @param tabnom : Tableau contenant les noms (et donc le nombre) des Villageois à créer
 * @param tabVillageois : Tableau d'objet:Villageois
 * @param tabRessource : Tableau d'objet:Ressource
 */
public class Simulation {

    //private final Terrain T = new Terrain(10,10);
    private Terrain T ;
    private String[][] tabInitRessource;
    private String[] tabnom;
    private Villageois[] tabVillageois;
    private Ressource[] tabRessource;

    /** Constructeur de Simulation.
     * Les simulations partage toutes un même terrain
     *
     * @param nom : Correspond au nom de la simulation
     * @param l : Correspond au nombre de ligne du terrain à générer et sur lequel faire les simulations
     * @param c : Correspond au nombre de colonne du terrain à générer et sur lequel faire les simulations
     */
    public Simulation(Terrain ter1, String[][] tab,String[] tabnom){
        this.T=ter1;
        this.tabInitRessource=tab;
        this.tabnom=tabnom;
    }

    public void phaseInit(){
        
        System.out.println("PHASE 1:Initialisation de l'environnement:");

        // PHASE Initialisation : 
        // Génére aléatoirement des cases sur lesquelles placer les ressources à partir d'un tableau de ressource
        initRandomRessources(this.tabInitRessource) ;
        // Créer les villageois à partir d'un tableau de nom et créer un tableau de villageois
        initVillageois(this.tabnom);
        // Affichage du terrain avec les ressources ajoutées
        System.out.println("Informations sur le terrain:\n"+T);
        T.affiche();
       
        // information sur les listes
        System.out.println("\nCONTENU LIST DE RESSOURCE\n");
        for (Ressource r: this.tabRessource){
            System.out.print(r +"\n");
        }
        System.out.println("\nCONTENU LIST DE VILLAGEOIS\n");
        for (Villageois r: this.tabVillageois){
            System.out.print(r +"\n");
        }
        System.out.print("\n");
    }


    /** Initialisation des villageois:
     * <ul>
     * <li> Créer les villageois à partir d'un tableau de nom
     * <li> Créer un tableau d'objet:Villageois
     * </ul>
     *
     * @param arrayName Correspond a un tableau de nom à attribuer aux villageois
     */
    private void initVillageois(String[] arrayName){
        int taille = arrayName.length;
        this.tabVillageois = new Villageois[taille];
        for (int i=0; i<taille;i++){
            this.tabVillageois[i] = new Villageois(arrayName[i]);
            System.out.println(this.tabVillageois[i].toString());
        }
        
        // Affichage du nombre de villageois créé
        System.out.println(Villageois.getCpt()+" villageois on été créé.");
    }


    /** Permet de placer aléatoirement un nombre donné d'un type de ressource sur un Terrain.
     *
     * @param tabR Correspond au tableau de String de deux dimensions permettant d'initialiser un type ainsi qu'un
     * nombre de ressource donné.Pour se faire il est composé de la manière suivante:
     * <ul>
     * <li> tabR[O][i] : correspondent aux noms des i-ressources.
     * <li> tabR[i][1] : correspondent aux quantités q des i-ressource.
     * </ul>
     */
    private void initRandomRessources(String[][] tabR){
        int taille = Bao.NbrRessourceTotale(tabR);
        this.tabRessource = new Ressource[taille];
        int cptR = 0;                                     // Compteur du nombre de ressource/objet créé(e)s
        for (int i =0; i<tabR.length; i++){
            String nom = tabR[i][0];
            int m = Integer.parseInt(tabR[i][1]);
            int cptBoucle = 0;                            // Compteur de boucle
            while (cptBoucle < m) {
                // Génération aléatoire des coordonnées et de la quantité des Arbres à créer
                int x = Bao.NbrAleatoire(0,T.nbLignes);   // Valeur aléatoire d'abscisse comprise entre 0 et m
                int y = Bao.NbrAleatoire(0,T.nbColonnes); // Valeur aléatoire d'ordonnée comprise entre 0 et m
                int q = Bao.NbrAleatoire(1,4);            // Valeur aléatoire de quantité comprise entre 1 et 3
                System.out.println("TIRÉ AU SORT:"+nom+".x."+x+".y."+y+".q."+q);

                // Vérification si Vide, alors 
                if (T.caseEstVide(x,y)){
                    Ressource res1 = new Ressource(nom,q);
                    T.setCase(x,y,res1);                   // Place la ressource sur le terrain
                    this.tabRessource[cptR] = res1;   // Ajoute la ressource au tableau de ressource
                    System.out.println(" AJOUT :"+this.tabRessource[i].toString());
                    cptR++;                                // incrémentation du compteur de ressource
                    cptBoucle++ ;                          // incrémentation du compteur de boucle
                }
                else{
                    System.out.println("...Case non vide, recherche d'un autre emplacement...");
                }
            }
            System.out.println("..."+m+" ressources "+nom+" ont été ajoutées...");
        }
    }
}
