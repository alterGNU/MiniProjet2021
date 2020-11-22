/**
 * @author Laurent GRONDIN
 * 
 */
public class TestSimulation {
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        //// CONFIGURATION STANDART 
        //Terrain T= new Terrain(10,10);
        //String[][] ressource={{"Caillou","7"},{"Roche","7"},{"Cobalt","6"},{"Terre","4"}};
        //String[] nom={"Bob","Sam","Thierry"};

        // PETITE CONFIGUE POUR LES TEST
        Terrain T= new Terrain(4,4);
        String[][] ressource={{"Roche","7"}};
        String[] nom={"Bob","Sam"};

        Simulation S1 = new Simulation(T,ressource,nom);
        S1.phaseInit();

        // #########PHASE RECOLTE
        int t = 0; // Compteur de tour
        int ressourceDispo=S1.qTotRessource();
        System.out.print("Il y a "+ressourceDispo+" pierres précieuses sur le terrain\n");
        while (ressourceDispo>0){
            ressourceDispo=S1.qTotRessource();
            for (Villageois V: Simulation.tabVillageois){
                S1.rechercheRecolte(V);
            }
            System.out.print("tour "+t+":\t");
            t++;

        // ##########PHASE BILAN ##############
        }
        System.out.print("Il a fallut "+t+" tour pour récolter l'intégralité des ressources\n");
        for (Villageois V: S1.tabVillageois){
        System.out.print(V.toString()+"\n");
        }
    }
}
