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
       
        // PHASE INITIALISATION
        S1.phaseInit();
        S1.setorTot(S1.qTotRessource());

        // PHASE RECOLTE
        int t = 0; // Compteur de tour
        System.out.print("Il y a "+S1.getorTot()+" pépites d'or sur le terrain\n");
        while (S1.getorTot()>0){
            System.out.print("tour "+t+":\n");
            for (Mineur M: Simulation.tabMineur){
                if (S1.getorTot()<=0){
                    break;
                }else{
                    S1.recherchePiocheRecolte(M);
                }
                t++;
                System.out.print("----\n");

            }
            // PHASE BILAN
            System.out.print("Il a fallut "+t+" tour pour récolter l'intégralité des pépites d'or\n");
            for (Mineur M: S1.tabMineur){
                System.out.print(M.toString()+"\n");
            }
        }
    }
} 
