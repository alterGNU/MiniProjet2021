/**
 * TODO 
 * - Classe Agent () : Définis par sa position sur le terrain
 * - Variables/Attribu
 *     - [X] : coordonnée (int,int) : correspond à sa position sur le terrain
 * - Méthodes
 *     - [X] : distance(x,y) : retourne la distance séparant l'agent de la ressource
 *     - [X] : seDeplacer(xnew,ynew) : change la position de l'objet se déplaçant sur le terrain
 */

/** Classe agent 
 *
 * @param px : abscisse initiale d'un agent à sa création
 * @param py : ordonnée initiale d'un agent à sa création
 */
public class Agent{
     private int x = 0;
     private int y = 0;
     
     /** Récupère la coordonnée d'abscisse de l'agent
     */
     public int getX(){
         return this.x;
     }

     /** Récupère la coordonnée d'abscisse de l'agent
     */
     public int getY(){
         return this.y;
     }

     /** Affiche la position de l'agent sur le terrain!
      *
      * @param t : correspond au terrain sur lequel afficher les déplacements
     */
     public void affiche_position(Terrain t){
         System.out.println("L'agent créé est dans la case : ("+this.x+":"+this.y+")");
         Ressource spe = new Ressource("O",0);
         t.setCase(this.x,this.y,spe);
         t.affiche();
     }

     /** Déplace agent
      *
      * @param xnew Nouvelle abscisse de la position de l'agent
      * @param ynew Nouvelle ordonnée de la position de l'agent
      */
     public void seDeplacer(int xnew,int ynew){
         this.x=xnew;
         this.y=ynew;
     }

     /** Retourne la distance séparant un objet présent sur le terrain et la position actuelle de l'agent
      *
      * @param x Nouvelle abscisse de la position de l'agent
      * @param y Nouvelle ordonnée de la position de l'agent
      */
     public double distance(int x,int y){
         int xlong = Math.abs(this.x - x);    
         int ylong = Math.abs(this.y - y);
         double distance = Math.sqrt((xlong)*(xlong) +(ylong)*(ylong));
         return distance;
     }
}


