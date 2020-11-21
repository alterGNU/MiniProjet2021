/**
 * @author Laurent GRONDIN
 * 
 */
public class TestSimulation {
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        Terrain T= new Terrain(5,5);
        String[][] ressource={{"Arbre","2"},{"Roche","4"},{"Caillou","6"}};
        String[] nom={"Bob","Sam","Thierry"};

        Simulation S1 = new Simulation(T,ressource,nom);
        S1.phaseInit();
        //S1.phaseRecolte();


        /* Ensemble de test à supprimer par la suite
        // ########TEST BAO ########
        // Test Bao.NrbAlea
        for (int i=0; i<25;i++){
            System.out.println(Bao.NbrAlea(1,4));
        }

        // Test Bao.SommeTabEntier
        int[] tab1={1,2,3,4};
        
        // Test Bao.NbrRessourceTotale
        System.out.println("Le tableau de ressource doit contenir :"+ Bao.NbrRessourceTotale(ressource) +" cases");
       
        // ########TEST VILLAGEOIS######
        System.out.println("La somme du contenu du tableau tab1 est :"+ Bao.SommeTabEntier(tab1));
        // Test des methodes public de villageois
        System.out.println("Il y a actuellement "+Villageois.getCpt()+" Villageois");
        Villageois v1 = new Villageois("bob");
        Villageois v2 = new Villageois("sam");
        System.out.println(v1.toString());
        System.out.println(v2.toString());
        System.out.println("Il y a actuellement "+Villageois.getCpt()+" Villageois");
        v1.seDeplacer(v1.getX()+1,v1.getY()+4);
        v2.seDeplacer(v2.getX()+5,v2.getY()+1);
        System.out.println(v1.toString());
        System.out.println(v2.toString());
        System.out.println("La distance séparant "+v1.getName()+" et "+v2.getName()+" vaut: "+v1.distance(v2.getX(),v2.getY()));
        // Création d'un troisième villagois
        Villageois v3 = new Villageois("Octave");
        System.out.println(v3.toString());
        v3.seDeplacer(v3.getX()+12,v3.getY()+12);
        System.out.println(v3.toString());
        System.out.println("Il y a actuellement "+Villageois.getCpt()+" Villageois");
        System.out.println("La distance séparant "+v1.getName()+" et "+v3.getName()+" vaut: "+v1.distance(v3.getX(),v3.getY()));
        */
    }
}
