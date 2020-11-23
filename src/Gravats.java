/** Classe Gravats 
 *
 * @param nom : nom de l'objet gravat
 * @param x : abscisse des gravats sur le terrain
 * @param y : ordonnée des gravats sur le terrain
 * @param q : quantité
 */
public class Gravats extends Ressource{
    private String nom = "Gravats"; // Les gravats n'ont pas besoin d'être dissossiable
    private int x ; 
    private int y ;
    private final int q = 0; // final car on ne s'interesse pas à la quantité de gravats qu'on considére donc comme null

    /** Constructeur de Gravats
     */
    public Gravats(){
        super(" .°. ",0);
    }

    /** Constructeur de Gravats avec coordonées explicites 
     * Permet ainsi dès la création de l'objet gravat, de lui affecter des coordonnées précises
     * @param posx : abscisse à laquelle placer les gravats sur le terrain
     * @param posy : ordonnée à laquelle placer les gravats sur le terrain
     */
    public Gravats(int posx, int posy){
        this();
        this.x=posx;
        this.y=posy;
    }

    /** Constructeur de Gravats avec coordonées et terrain en paramètre ( pour le placement sur le terrain à la création!)
     * Permet ainsi dès la création de l'objet gravat, de le placer sur le terrain aux coordonnées passées en paramètres
     * si ces dernières sont sur le terrain.
     * @param posx : abscisse à laquelle placer les gravats sur le terrain
     * @param posy : ordonnée à laquelle placer les gravats sur le terrain
     * @param T : Terrain sur lequel placer l'objet
     */
    public Gravats(int posx, int posy, Terrain T){
        this(posx,posy);
        if(T.sontValides(posx,posy)){T.setCase(this.x,this.y,this);}
    }

    // GETTER SPETCIALE
    /** Retourne les informations de l'objet Gravats */
    public String toString(){
        return nom;
    }

    /** Retourne les informations de l'objet Gravats */
    public String phraseOcc(){
        return "Des "+nom+" encombre maintenant la case ("+x+":"+y+")";
    }
    
}
