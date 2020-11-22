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
    private Terrain T;
    private String[][] tabInitRessource;
    private String[] tabnom;
    private static int orTot;
    static Mineur[] tabMineur; // A REMETTRE EN PRIVATE!!!!
    private Ressource[] tabRessource;

    /** Constructeur de Simulation.
     *
     * @param ter1 : Correspond au terrain de la simulation
     * @param tab : Tableau de String associant les noms des ressources à créer ainsi que leurs nombres
     * @param tabnom : Tableau de nom des Mineurs à utiliser dans la simulation
     */
    public Simulation(Terrain ter1, String[][] tab,String[] tabnom){
        this.T=ter1;
        this.tabInitRessource=tab;
        this.tabnom=tabnom;
    }

    // GETTEUR/SETTEUR
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
        System.out.println("PHASE 1:INITIALISATION DE L'ENVIRONNEMENT:\nInformations sur les mineurs:");
        initMineur(this.tabnom);
        System.out.println("\nInformations sur les ressources:");
        initRandomRessources(this.tabInitRessource) ;   // Place aléatoirement les ressources sur le terrain
        orTot=qTotRessource();                          // Calcul le nombre de pépites cachées et l'affecte à orTot
        System.out.print("Il y a en tout "+orTot+" pépites d'or caché sur le terrain suivant : \n");
        System.out.println(T);
        T.affiche();                                    // Affiche le terrain avec le ressources qu'il contient
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

    private void recolte(Mineur Min1){
        int x = Min1.getX();
        int y = Min1.getY();
        Ressource R=T.getCase(x,y);       // Mettre dans le sac Min1lagedu Mineur la ressource...
        System.out.println(Min1.getName()+" est tombé sur ("+T.getCase(x,y)+", il pioche!");
        Min1.setSac(Min1.getSac() + R.getQuantite());
        orTot-= R.getQuantite();
        System.out.println(Min1.getName()+" à récolté "+T.getCase(x,y).getQuantite()+" pépites d'or en ("+x+","+y+"), ce qui lui fait un total de "+Min1.getSac()+" pépites d'or!");
        R.setQuantite(0);
        T.videCase(x,y);                   // Vider la case
    }

    public void recherchePiocheRecolte(){
        // parcour tout les mineurs de la liste
        for (Mineur M: tabMineur){
            if (orTot<=0){
                System.out.print("Désolé pour les autres mineurs de ce tour mais...");
                break;
            }else{
                int posx = M.getX();
                int posy = M.getY();
                System.out.println(M.getName()+" est en ("+posx+","+posy+")");
                if ( posx == -1 && posy == -1){
                    System.out.println(M.getName()+" est au Village...il en sort!");
                    M.seDeplacer(0,0);
                    System.out.println(M.getName()+" s'est déplacé en ("+M.getX()+","+M.getY()+")");
                }else if ( ! T.caseEstVide(posx,posy)){        // Si la case sur laquelle il se trouve est non vide...
                    recolte(M);
                }
                else{
                    do{
                        int xalea = (Bao.nbrAleatoire(0,3)-1);
                        int yalea = (Bao.nbrAleatoire(0,3)-1);
                        if ((xalea != 0 || yalea != 0) && (T.sontValides(posx + xalea ,posy + yalea))){
                            M.seDeplacer(posx + xalea,posy + yalea);
                            System.out.println(M.getName()+" s'est déplacé en ("+M.getX()+","+M.getY()+")");
                        }
                    }while(M.getX()==posx && M.getY()==posy);
                }
            }
        }
    }

    public void afficheTabMineur(){
        for (Mineur M: tabMineur){
            System.out.print(M.toString()+"\n");
        }
    }
}
