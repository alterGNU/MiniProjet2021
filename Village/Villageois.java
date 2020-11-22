/** Classe Villageois 
 *
 * @param nom : Correspond au nom du villageois
 * @param px : abscisse initiale d'un villageois à sa création
 * @param py : ordonnée initiale d'un villageois à sa création
 * @param cpt : Compteur du nombre de Villageois crée
 */
public class Villageois{
    // Tout villageois à pour coordonnée de départ la case village (0:0)
    private String nom ; 
    private int px = -1; 
    private int py = -1;
    private static int cpt = 0;
    private int sac = 0;

    /** Constructeur de Villageois.
     * Chaque villeagois nés au village(point de coordonnée 0.0) ainsi à sa création, seul son nom est demandé
     *
     * @param name : Correspond au nom du villageois
     */
    public Villageois(String name){
        this.nom=name;
        cpt++; // Incrémentation du compteur de villageois
    }

    /** Récupère le nom du villageois */
    public String getName(){ return nom;}
    /** Récupère la coordonnée d'abscisse de villageois */
    public int getX(){ return px;}
    /** Récupère la coordonnée d'abscisse de villageois */
    public int getY(){ return py;}
    /** Récupère la valeur de cpt : nombre de villageois créé */
    public static int getCpt(){ return cpt;}
    /** Récupère le contenue du sac du villageois */
    public int getSac(){ return sac;}
    /** Retourne la nom et la position du Villageois sur le terrain */
    public String toString(){
        return "Villageois "+nom+" est dans la case ("+px+":"+py+") et à dans son sac "+sac+" pierre précieuse";
    }

    /** Déplace villageois
     *
     * @param xnew Nouvelle abscisse de la position de villageois
     * @param ynew Nouvelle ordonnée de la position de villageois
     */
    public void seDeplacer(int xnew,int ynew){
        this.px=xnew;
        this.py=ynew;
    }

    /** Retourne la distance minimale de case séparant un objet présent sur le terrain de la position actuelle de villageois
     *
     * @param x Nouvelle abscisse de la position de villageois
     * @param y Nouvelle ordonnée de la position de villageois
     */
    public int distance(int x,int y){
        int xlong = Math.abs(this.px - x);    
        int ylong = Math.abs(this.py - y);
        int distance =(int) Math.sqrt((xlong)*(xlong) +(ylong)*(ylong));
        return distance;
    }

    /** Récolte les ressources (les places dans le sac du villageois
     *
     * @param ress ressource à recolter
     */
    public void recolte(Ressource ress){
        this.sac += ress.getQuantite();
        ress.setQuantite(0);
    }

}
