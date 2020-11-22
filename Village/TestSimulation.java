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
        System.out.print("Il y a "+ressourceDispo+" pépites d'or sur le terrain\n");
        while (ressourceDispo>0){
            System.out.print("tour "+t+":\n");
            ressourceDispo=S1.qTotRessource();
            for (Mineur M: Simulation.tabMineur){
                S1.rechercheRecolte(M);
            }
            t++;
            System.out.print("----\n");

        // ##########PHASE BILAN ##############
        }
        System.out.print("Il a fallut "+t+" tour pour récolter l'intégralité des pépites d'or\n");
        for (Mineur M: S1.tabMineur){
            System.out.print(M.toString()+"\n");
        }
    }
}
