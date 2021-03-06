/** Classe Mineur 
 *
 * @param nom : Correspond au nom du Mineur
 * @param px : abscisse initiale d'un Mineur à sa création
 * @param py : ordonnée initiale d'un Mineur à sa création
 * @param cpt : Compteur du nombre de Mineur crée, commence à -1 car le premier mineur est le chef du village!!
 * @param sac : Affiche le nombre de pépite d'or contenu dans le sac du mineur
 */
public class Mineur{
    // Tout Mineur à pour coordonnée de départ la case village (0:0)
    private String nom ; 
    private int px ; 
    private int py ;
    private static int cpt = -1; // static car à chaque création d'un mineur, Incrémentation de cette variable.
    private int sac;

    /** Constructeur de Mineur.
     * Chaque mineur nés au village(point de coordonnée 0.0) ainsi à sa création, seul son nom est demandé
     *
     * @param name : Correspond au nom du Mineur
     * @param posx : abscisse d'un Mineur
     * @param posy : ordonnée d'un Mineur
     * @param saccoche : Correspond au nombre de pépite d'or contenu dans le sac du mineur
     */
    public Mineur(String name,int posx,int posy,int saccoche){
        nom=name;
        px=posx;
        py=posy;
        sac=saccoche;
        cpt++; // Incrémentation du compteur de Mineur
    }

    /** Constructeur de Mineur par copie
     * Permet de créer une copie d'un mineur
     *
     * @param mineur : Correspond au nom du Mineur
     */
    public Mineur(Mineur autreMineur){
        this.nom = autreMineur.nom;
        this.px = autreMineur.px;
        this.py = autreMineur.py;
        this.sac = autreMineur.sac;
        cpt++; // Incrémentation du compteur de Mineur
    }

    // GETTER/SETTER
    /** Récupère le nom du Mineur */
    public String getName(){ return nom;}
    /** Modifie le nom du Mineur */
    public void setName(String newname){ 
        nom = newname;
    }
    /** Récupère la coordonnée d'abscisse de Mineur */
    public int getX(){ return px;}
    /** Récupère la coordonnée d'abscisse de Mineur */
    public int getY(){ return py;}
    /** Récupère la valeur de cpt : nombre de Mineur à créé */
    public static int getCpt(){ return cpt;}
    /** Récupère le contenue du sac du Mineur */
    public int getSac(){ return sac;}
    /** Modifie le contenu du sac du Mineur par l'entier passé en paramètre */
    public void setSac(int newsac){ 
        sac = newsac;
    }
    /** Retourne la nom et la position du Mineur sur le terrain */
    public String toString(){
        return "Mineur "+nom+" est dans la case ("+px+":"+py+") et a dans son sac "+sac+" pépites d'Or.";
    }

    /** Déplace Mineur
     *
     * @param xnew Nouvelle abscisse de la position de Mineur
     * @param ynew Nouvelle ordonnée de la position de Mineur
     */
    public void seDeplacer(int xnew,int ynew){
        this.px=xnew;
        this.py=ynew;
    }

    /** Retourne la distance minimale séparant un mineur d'un objet présent sur le terrain 
     *
     * @param x Nouvelle abscisse de la position de Mineur
     * @param y Nouvelle ordonnée de la position de Mineur
     */
    public int distance(int x,int y){
        int xlong = Math.abs(this.px - x);    
        int ylong = Math.abs(this.py - y);
        int distance =(int) Math.sqrt((xlong)*(xlong) +(ylong)*(ylong));
        return distance;
    }
}
