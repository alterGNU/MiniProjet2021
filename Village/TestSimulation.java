/**
 * @author Laurent GRONDIN
 * 
 */
public class TestSimulation {
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        // CONFIGURATION STANDART 
        Terrain T= new Terrain(10,10);
        String[][] ressource={{"Arbre","7"},{"Roche","3"},{"Or","1"}};
        String[] nom={"Bob","Sam","Thierry"};

        // PETITE CONFIGUE POUR LES TEST
        //Terrain T= new Terrain(2,2);
        //String[][] ressource={{"Arbre","1"}};
        //String[] nom={"Bob"};

        Simulation S1 = new Simulation(T,ressource,nom);
        S1.phaseInit();
        //System.out.print(Simulation.tabRessource[0].toString());
        //System.out.print(Simulation.tabRessource[0].getQuantite());

        // #########TEST Fonction calcule
        //System.out.print("Il y a actuellement "+S1.qTotRessource()+"matières sur le terrain");

        // #########PHASE RECOLTE#############
        int t = 0; // Compteur de temps
        boolean simu=true;
        int ressourceDispo=10;
        while (ressourceDispo > 0){
            //int ressourceDispo=S1.qTotRessource();
            for (int i=0; i<S1.tabVillageois.length; i++){
                System.out.print("..."+S1.tabVillageois[i].getName()+" est en cour de recherche!\n");
                ressourceDispo--;
            }
            t++;
        }

        //tabVillageois;
        //tabRessource;
        // information sur les listes
//        System.out.println("\nCONTENU LIST DE RESSOURCE\n");
//        for (Ressource r: Simulation.tabRessource){
//            System.out.print(r +"\n");
//        }
//        System.out.print("La première ressource du tableau est :"+Simulation.tabRessource[0].toString()+"\n");
//        System.out.print("Son abscisse X=:"+Simulation.tabRessource[0].getX()+"\n");
//        System.out.print("Son ordonnée X=:"+Simulation.tabRessource[0].getY()+"\n");
//        System.out.print("Il se trouve à "+Bao.distVillage(Simulation.tabRessource[0].getY(),Simulation.tabRessource[0].getY())+" case du village\n");
//        System.out.print("Il faut un minimum de "+Bao.distVillageOpti(Simulation.tabRessource[0].getY(),Simulation.tabRessource[0].getY())+" case pour s'y rendre\n");
//
        // ######### Afficher contenu de tableau d'objet
        //System.out.println("\nCONTENU LIST DE RESSOURCE\n");
        //for (Ressource r: this.tabRessource){
        //    System.out.print(r +"\n");
        //}

        //System.out.print("\n");
        //System.out.println("\nCONTENU LIST DE VILLAGEOIS\n");
        //for (Villageois r: Simulation.tabVillageois){
        //    System.out.print(r +"\n");
        //}
        //System.out.print("\n");
    //}
}
}
