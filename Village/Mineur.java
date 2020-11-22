/** Classe Mineur 
 *
 * @param nom : Correspond au nom du Mineur
 * @param px : abscisse initiale d'un Mineur à sa création
 * @param py : ordonnée initiale d'un Mineur à sa création
 * @param cpt : Compteur du nombre de Mineur crée
 * @param sac : Affiche le nombre de pépite d'or contenu dans le sac du mineur
 */
public class Mineur{
    // Tout Mineur à pour coordonnée de départ la case village (0:0)
    private String nom ; 
    private int px = -1; 
    private int py = -1;
    private static int cpt = 0;
    private int sac = 0;

    /** Constructeur de Mineur.
     * Chaque villeagois nés au village(point de coordonnée 0.0) ainsi à sa création, seul son nom est demandé
     *
     * @param name : Correspond au nom du Mineur
     */
    public Mineur(String name){
        this.nom=name;
        cpt++; // Incrémentation du compteur de Mineur
    }

    /** Récupère le nom du Mineur */
    public String getName(){ return nom;}
    /** Récupère la coordonnée d'abscisse de Mineur */
    public int getX(){ return px;}
    /** Récupère la coordonnée d'abscisse de Mineur */
    public int getY(){ return py;}
    /** Récupère la valeur de cpt : nombre de Mineur créé */
    public static int getCpt(){ return cpt;}
    /** Récupère le contenue du sac du Mineur */
    public int getSac(){ return sac;}
    /** Modifie le contenu du sac du Mineur par l'entier passé en paramètre */
    public void setSac(int newsac){ 
        sac = newsac;
    }
    /** Retourne la nom et la position du Mineur sur le terrain */
    public String toString(){
        return "Mineur "+nom+" est dans la case ("+px+":"+py+") et à dans son sac "+sac+" pépites d'Or.";
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

    /** Retourne la distance minimale de case séparant un objet présent sur le terrain de la position actuelle de Mineur
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
