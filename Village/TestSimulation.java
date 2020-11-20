import java.util.ArrayList; // pour faire des tableaux à taille variable

/**
 * @author Laurent GRONDIN
 * 
 */
public class TestSimulation {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String[][] tab1 = {{"fer",3},{"arbre",3]}};
        List
        Simulation S1 = new Simulation(tab1,);
        S1.phaseInit();

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
    }
    }
}
