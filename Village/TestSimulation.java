/**
 * @author Laurent GRONDIN 2767308
 * 
 */
public class TestSimulation {
    /**
     * @param args
     */
    public static void main(String[] args) {
        
// -[ JEUX DE DONNÉES UTILISABLES ]------------------------------------------------------------------------------------
        // PETITE CONFIGURATION POUR LES TEST
        Terrain t0= new Terrain(5,5);
        String[][] ressource0={{"Roche","5"},{"Pierre","5"}};

        //// CONFIGURATION STANDART 
        Terrain t= new Terrain(15,15);
        String[][] ressource={{"Granite","7"},{"Roche","7"},{"Cobalt","7"},{"Terre","7"}};
// -[ LANCEMENT DES SIMULATIONS ]---------------------------------------------------------------------------------------
 
        //lanceSimulationAvec(t0,ressource0,3);
        lanceSimulationAvec(t,ressource,6);
    }

    /** Lance une simulation avec le jeux de donnée passé en paramètre.
     *
     * @param t Correspond au terrain que l'on souhaite utiliser
     * @param ressource Correspond à la liste (String) permettant de définir les noms et les quantitées d'objet
     * ressource à placer sur le terrain
     * @param nom est une liste de String contenant les noms des mineurs à placer dans la simulation
     */
    private static void lanceSimulationAvec(Terrain ter1, String[][] ressource, int nbr ) {
        // PHASE 1 INITIALISATION
        Simulation s1 = new Simulation(ter1,ressource,nbr);
        s1.phaseInit();
        // PHASE 2 RECOLTE
        System.out.println("PHASE 2: RECHERCHE & RECOLTE");
        int tps = 0;                                          // Compteur de tour
        while (s1.getorTot()>0){                              // tant qu'il reste des pépites d'or sur le terrain faire:
            System.out.print("-----\nTOUR "+tps+":\n");
            s1.recherchePiocheRecolte();
            tps++;                                            // incrémentation de la variable de tour
        }
        System.out.print("Il n'y a plus de pépites d'or disponible sur le terrain!\nFIN DE LA RECOLTE\n\n");
        // PHASE 3 BILAN
        System.out.println("PHASE 3: BILAN");
        ter1.toString();                                      // Affichage des infos du tableau 
        ter1.affiche();                                       // Affichage du tableau pour s'assurer qu'il soit vide
        System.out.print("Il a fallut "+tps+" tour pour récolter l'intégralité des pépites d'or:\n");
        s1.afficheTabMineur();
    }
} 
