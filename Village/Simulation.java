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

    private Terrain T;
    private String[][] tabInitRessource;
    private String[] tabnom;
    private int orTot;
    private Mineur[] tabMineur;
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
    public int getorTot(){ return orTot;}
    /** Redéfinie la valeur de orTot : nombre de Mineur créé */
    public void setorTot(int newVal){
        orTot = newVal;
    }

    /** Methode de lancement de la phase d'initialisation de l'environnement
     *
     * <li> Initialise les ressources via à la méthode initRandomRessources
     * <li> Initialise les Mineurs via la méthode initMineur
     */
    public void phaseInit(){
        System.out.println("PHASE 1:INITIALISATION DE L'ENVIRONNEMENT:\nInformations sur les mineurs:");
        initMineur(this.tabnom);                        // Initialisation des mineurs
        System.out.println("\nInformations sur les ressources:");
        initRandomRessources(this.tabInitRessource) ;   // Place aléatoirement les ressources sur le terrain
        orTot=qTotRessource();                          // Calcul le nombre de pépites cachées et l'affecte à orTot
        System.out.print("Il y a en tout "+orTot+" pépites d'or caché sur le terrain suivant : \n");
        System.out.println(T);                          // Affiche les infos du tableau
        T.affiche();                                    // Affiche le terrain avec le ressources qu'il contient
    }

    /** Calcul la quantité totale de ressource disponible sur le terrain
    */
    private int qTotRessource(){
        int total=0;
        for (Ressource r: this.tabRessource){ total+=r.getQuantite(); }
        return total;
    }

    /** Initialisation des Mineurs, puis affiche une phrase indiquant le nombre de mineur actuellement créé
     * <ul>
     * <li> Créer les Mineurs à partir d'un tableau de nom
     * <li> Créer un tableau d'objet:Mineur
     * </ul>
     * @param arrayName Correspond au tableau contenant la liste des noms des mineurs
     */
    private void initMineur(String[] arrayName){
        int taille = arrayName.length;
        this.tabMineur = new Mineur[taille];
        for (int i=0; i<taille;i++){
            this.tabMineur[i] = new Mineur(arrayName[i]);
            System.out.println(this.tabMineur[i].toString());
        }
        // Affichage du nombre de Mineur créé
        System.out.println("En tout, "+Mineur.getCpt()+" mineurs ont été créés.");
    }


    /** Affiche les objets Mineurs contenus dans le tableau d'objet tabMineur d'une Simulation
     */
    public void afficheTabMineur(){
        for (Mineur M: tabMineur){
            System.out.print(M.toString()+"\n");
        }
    }

    /** Permet, à partir d'un tableau de String de deux dimensions associant noms et nombres de ressources à créer, de
     * placer aléatoirement ces ressources sur le tableau
     *
     * @param tabR Correspond au tableau de String de deux dimensions permettant d'initialiser un type ainsi qu'un
     * nombre de ressource donné.Pour se faire il est composé de la manière suivante:
     * <ul>
     * <li> tabR[O][i] : correspondent aux noms des i-ressources.
     * <li> tabR[i][1] : correspondent aux quantités q des i-ressources.
     * </ul>
     */
    private void initRandomRessources(String[][] tabR){
        int taille = Bao.nbrRessourceTotal(tabR);         // Donne nombre d'éléments totaux du tableaux.
        this.tabRessource = new Ressource[taille];        // Créer un tableau pouvant contenir tous les éléments
        int cptR = 0;                                     // Compteur du nombre de ressource/objet créé(e)s
        for (int i =0; i<tabR.length; i++){
            String nom = tabR[i][0];                      // Récupération de la donnée du "nom" de la ressource
            int m = Integer.parseInt(tabR[i][1]);         // Récupération de la donnée du "nbr" de ressource(converti int)
            int cptBoucle = 0;                            // Compteur de boucle
            while (cptBoucle < m) {
                // Génération aléatoire des coordonnées et de la quantité des Arbres à créer
                int x = Bao.nbrAleatoire(0,T.nbLignes);   // Valeur aléatoire d'abscisse comprise entre 0 et longueur max terrain
                int y = Bao.nbrAleatoire(0,T.nbColonnes); // Valeur aléatoire d'ordonnée comprise entre 0 et largeur max terrain
                int q = Bao.nbrAleatoire(1,4);            // Valeur aléatoire de quantité comprise entre 1 et 3

                if (T.caseEstVide(x,y)){                  // Vérification si Vide, alors 
                    Ressource res1 = new Ressource(nom,q);// Crée la ressource
                    T.setCase(x,y,res1);                  // La place sur le terrain
                    this.tabRessource[cptR] = res1;       // L'Ajoute au tableau de ressource
                    //System.out.println(" AJOUT :"+this.tabRessource[cptR].toString());
                    cptR++;                                // incrémentation du compteur de ressource
                    cptBoucle++ ;                          // incrémentation du compteur de boucle
                }
            }
            System.out.println("..."+m+" ressources "+nom+" ont été ajoutées...");
        }
    }

    /** Permet, pour un Mineur passé en paramètre, de faire les différents actions constituant la récolte
     *
     * @param Min1 Correspond au mineur recoltant
     */
    private void recolte(Mineur Min1){
        int x = Min1.getX();
        int y = Min1.getY();
        Ressource R=T.getCase(x,y);                        // Mettre dans le sac du Mineur la ressource...
        if (Bao.estEntre(R.getQuantite(),2,20)){           // Si la quantité est comprise entre [1;20]
        System.out.println(Min1.getName()+" est tombé sur ("+R.toString()+", il pioche!");
        Min1.setSac(Min1.getSac() + 1 );                   // Remplis le sac du mineur avec la quantité d'or trouvé
        R.setQuantite(R.getQuantite() - 1);                // Place la quantité de la ressource à zéro
        orTot--;                                           // Décrémente la var donnant le nombre d'or présent sur terrain
        System.out.println(Min1.getName()+" à récolté 1 pépite d'or en ("+x+","+y+"), ce qui lui fait un total de "+Min1.getSac()+" pépites d'or!");
        }else{                      // Quand c'est la dernière pépite alors...
            System.out.println(Min1.getName()+" est tombé sur ("+R.toString()+", il pioche!");
            Min1.setSac(Min1.getSac() + 1 );               // Remplis le sac du mineur avec la quantité d'or trouvé
            R.setQuantite(R.getQuantite() - 1);            // Place la quantité de la ressource à zéro
            orTot--;                                       // Décrémente la var donnant le nombre d'or présent sur terrain
            System.out.println(Min1.getName()+" à récolté 1 pépite d'or en ("+x+","+y+"), ce qui lui fait un total de "+Min1.getSac()+" pépites d'or!");
            T.videCase(x,y);                               // Vider la case +++ TRANSFORMER ++++ CLONE +++++
            Gravats g1 = new Gravats(x,y,T);               // Place l'objet Gravas sur le tableau
            System.out.println("il n'y a plus rien ici...hormis quelques gravats!");
        }
    }

    /** Définie l'ensemble des actions possible pour un mineur pendant un tour de la phase de recherche et recolte
     */
    public void recherchePiocheRecolte(){                  // parcours dans l'ordre le tableau des Mineurs
        for (Mineur M: tabMineur){                          
            if (orTot<=0){                                 // Stop le tour lorsq'un mineur autre que le dernier touve la dernière pépite
                System.out.print("Désolé pour les autres mineurs de ce tour mais...");
                break;
            }else{
                int posx = M.getX();
                int posy = M.getY();
                System.out.println(M.getName()+" est en ("+posx+","+posy+")");
                if ( posx == -1 && posy == -1){            // S'IL SE TROUVE AU VILLAGE-->ENTRE SUR LE TERRAIN EN 0:0
                    System.out.println(M.getName()+" est au Village...il en sort!");
                    M.seDeplacer(0,0);
                    System.out.println(M.getName()+" s'est déplacé en ("+M.getX()+","+M.getY()+")");
                // S'IL EST SUR UNE CASE NON VIDE QUI N'EST PAS UN GRAVATS --> RECOLTE
                }else if ((! T.caseEstVide(posx,posy))&&(T.getCase(posx,posy).toString()!="Gravats")){
                    recolte(M);
                }
                else{                                      // S'IL EST SUR UNE CASE VIDE-->SE DEPLACE DE 1 CASE
                    do{
                        int xalea = (Bao.nbrAleatoire(0,3)-1);
                        int yalea = (Bao.nbrAleatoire(0,3)-1);
                        if ((xalea != 0 || yalea != 0) && (T.sontValides(posx + xalea ,posy + yalea))){
                            M.seDeplacer(posx + xalea,posy + yalea);
                            System.out.println(M.getName()+" s'est déplacé en ("+M.getX()+","+M.getY()+")");
                        }
                    }while(M.getX()==posx && M.getY()==posy);// PERMET DE FORCER LE DEPLACEMENT EN EXCLUANT DU TIRAGE
                }                                            // LE SURPLACE!
            }
        }
    }
}
