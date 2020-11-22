/** Lance les différentes phase composant la simulation:
 * <ul>
 * <li> Phase d'initialisation
 * <li> Phase de recherche, de transformation puis de récolte
 * </ul>
 *
 * @param T : Correspond au terrain sur lequel effectuer la simulation
 * @param tabInitRessource : Tableau contenant le nom et le nombre de ressources à ajouter au terrain
 * @param tabnom : Tableau contenant les noms (et donc le nombre) des Mineur à créer
 * @param tabMineur : Tableau d'objet:Mineur
 * @param tabRessource : Tableau d'objet:Ressource
 * @param orTot : Variable contenant le nombre de pépites d'or total présentes sur le terrain.
 */
public class Simulation {

    //private final Terrain T = new Terrain(10,10);
    private Terrain T ;
    private String[][] tabInitRessource;
    private String[] tabnom;
    private static int orTot;
    static Mineur[] tabMineur; // A REMETTRE EN PRIVATE!!!!
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

    /** Récupère la valeur de orTot : nombre de Mineur créé */
    public static int getorTot(){ return orTot;}

    /** Redéfinie la valeur de orTot : nombre de Mineur créé */
    public static void setorTot(int newVal){
        orTot = newVal;
    }

    /** Calcul la quantité totale de ressource disponible sur le terrain
    */
    public int qTotRessource(){
        int total=0;
        for (Ressource r: this.tabRessource){ total+=r.getQuantite(); }
        return total;
    }

    /** Methode de lancement de la phase d'initialisation de l'environnement
     *
     * <li> Initialise les ressources via à la méthode initRandomRessources
     * <li> Initialise les Mineur via la méthode initMineur
     */
    public void phaseInit(){
        
        System.out.println("PHASE 1:Initialisation de l'environnement:");

        // PHASE Initialisation : 
        // Génére aléatoirement des cases sur lesquelles placer les ressources à partir d'un tableau de ressource
        initRandomRessources(this.tabInitRessource) ;
        // Créer les Mineur à partir d'un tableau de nom et créer un tableau de Mineur
        initMineur(this.tabnom);
        // Affichage du terrain avec les ressources ajoutées
        System.out.println("Informations sur le terrain:\n"+T);
        T.affiche();
       
    }


    /** Initialisation des Mineur:
     * <ul>
     * <li> Créer les Mineur à partir d'un tableau de nom
     * <li> Créer un tableau d'objet:Mineur
     * </ul>
     * @param arrayName Correspond a un tableau de nom à attribuer aux Mineur
     */
    private void initMineur(String[] arrayName){
        int taille = arrayName.length;
        this.tabMineur = new Mineur[taille];
        for (int i=0; i<taille;i++){
            this.tabMineur[i] = new Mineur(arrayName[i]);
            System.out.println(this.tabMineur[i].toString());
        }
        
        // Affichage du nombre de Mineur créé
        System.out.println(Mineur.getCpt()+" Mineur on été créé.");
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
        int taille = Bao.nbrRessourceTotal(tabR);
        this.tabRessource = new Ressource[taille];
        int cptR = 0;                                     // Compteur du nombre de ressource/objet créé(e)s
        for (int i =0; i<tabR.length; i++){
            String nom = tabR[i][0];
            int m = Integer.parseInt(tabR[i][1]);
            int cptBoucle = 0;                            // Compteur de boucle
            while (cptBoucle < m) {
                // Génération aléatoire des coordonnées et de la quantité des Arbres à créer
                int x = Bao.nbrAleatoire(0,T.nbLignes);   // Valeur aléatoire d'abscisse comprise entre 0 et m
                int y = Bao.nbrAleatoire(0,T.nbColonnes); // Valeur aléatoire d'ordonnée comprise entre 0 et m
                int q = Bao.nbrAleatoire(1,4);            // Valeur aléatoire de quantité comprise entre 1 et 3

                // Vérification si Vide, alors 
                if (T.caseEstVide(x,y)){
                    Ressource res1 = new Ressource(nom,q);
                    T.setCase(x,y,res1);                   // Place la ressource sur le terrain
                    this.tabRessource[cptR] = res1;   // Ajoute la ressource au tableau de ressource
                    //System.out.println(" AJOUT :"+this.tabRessource[cptR].toString());
                    cptR++;                                // incrémentation du compteur de ressource
                    cptBoucle++ ;                          // incrémentation du compteur de boucle
                }
            }
            System.out.println("..."+m+" ressources "+nom+" ont été ajoutées...");
        }
    }

    public void recolte(Ressource ress){
    }

    public void recherchePiocheRecolte(Mineur Min1){
        int posx = Min1.getX();
        int posy = Min1.getY();
        System.out.println(Min1.getName()+" est en ("+posx+","+posy+")");
        if ( posx == -1 && posy == -1){
            System.out.println(Min1.getName()+" est au Village...il en sort!");
            Min1.seDeplacer(0,0);
            System.out.println(Min1.getName()+" s'est déplacé en ("+Min1.getX()+","+Min1.getY()+")");
        }else if ( ! T.caseEstVide(posx,posy)){        // Si la case sur laquelle il se trouve est non vide...
            System.out.println(Min1.getName()+" est tombé sur ("+T.getCase(posx,posy)+", il pioche!");
            Ressource ress=T.getCase(posx,posy);       // Mettre dans le sac Min1lagedu Mineur la ressource...
            Min1.setSac(Min1.getSac() + ress.getQuantite());
            orTot-= ress.getQuantite();
            ress.setQuantite(0);
            System.out.println(Min1.getName()+" à récolté "+T.getCase(posx,posy).getQuantite()+" or en ("+posx+","+posy+") "+Min1.getSac()+"");
            T.videCase(posx,posy);                   // Vider la case
            //T.affiche();
        }
        else{
            do{
                int xalea = (Bao.nbrAleatoire(0,3)-1);
                int yalea = (Bao.nbrAleatoire(0,3)-1);
                System.out.println("LOOP xalea :"+xalea+", yalea:"+yalea);
                if ((xalea != 0 || yalea != 0) && (T.sontValides(posx + xalea ,posy + yalea))){
                    System.out.println("VALIDE xalea :"+xalea+", yalea:"+yalea);
                    Min1.seDeplacer(posx + xalea,posy + yalea);
                    System.out.println(Min1.getName()+" s'est déplacé en ("+Min1.getX()+","+Min1.getY()+")");
                }
            }while(Min1.getX()==posx && Min1.getY()==posy);
        }
    }
}
