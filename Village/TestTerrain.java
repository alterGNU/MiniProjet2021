public class TestTerrain {
	public static void main(String[] args) {
		// Exemple de création de terrain
		Terrain t = new Terrain(10,10);
		
        Gravats g2 = new Gravats(4,6,t);
		//t.setCase(g2.getX(),g2.getY(),g2);
        System.out.println(g2.toString());
        System.out.println("getX:"+g2.getX()+"getY()"+g2.getY());
        if(t.caseEstVide(4,4)){
            System.out.println("La case 4,6 est vide");
        }else{
            System.out.println("La case 4,6 est pas vide");
        }

        System.out.println("getNom():"+g2.getNom());
		t.affiche();
    }
}
