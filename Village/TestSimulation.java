/**
 * @author Laurent GRONDIN
 * 
 */
public class TestSimulation {
    /**
     * @param args
     */
    public static void main(String[] args) {
        
// -[ JEUX DE DONNÉES UTILISABLES ]------------------------------------------------------------------------------------
        // PETITE CONFIGUE POUR LES TEST
        Terrain T0= new Terrain(4,4);
        String[][] ressource0={{"Roche","10"}};
        String[] nom0={"Bob","Sam","Cat"};

        //// CONFIGURATION STANDART 
        Terrain T= new Terrain(10,10);
        String[][] ressource={{"Caillou","7"},{"Roche","7"},{"Cobalt","6"},{"Terre","4"}};
        String[] nom={"Bob","Sam","Thierry"};
// -[ LANCEMENT DES SIMULATIONS ]---------------------------------------------------------------------------------------
 
        lanceSimulationAvec(T0,ressource0,nom0);
        //lanceSimulationAvec(T,ressource,nom);
    }

    /** Lance une simulation avec le jeux de donnée passé en paramètre.
     *
     * @param T Correspond au terrain que l'on souhaite utiliser
     * @param ressource Correspond à la liste (String) permettant de définir les noms et les quantitées d'objet
     * ressource à placer sur le terrain
     * @param nom est une liste de String contenant les noms des mineurs à placer dans la simulation
     */
    private static void lanceSimulationAvec(Terrain T, String[][] ressource, String[] nom ) {
        // PHASE 1 INITIALISATION
        Simulation S1 = new Simulation(T,ressource,nom);
        S1.phaseInit();
        // PHASE 2 RECOLTE
        System.out.println("PHASE 2: RECHERCHE & RECOLTE");
        int t = 0;                                          // Compteur de tour
        while (S1.getorTot()>0){                            // tant qu'il reste des pépites d'or sur le terrain faire:
            System.out.print("-----\nTOUR "+t+":\n");
            S1.recherchePiocheRecolte();
            t++;                                            // incrémentation de la variable de tour
        }
        System.out.print("Il n'y a plus de pépites d'or disponible sur le terrain!\nFIN DE LA RECOLTE\n\n");
        // PHASE 3 BILAN
        System.out.println("PHASE 3: BILAN");
        T.toString();
        T.affiche();
        System.out.print("Il a fallut "+t+" tour pour récolter l'intégralité des pépites d'or\n");
        S1.afficheTabMineur();
    }
} 
