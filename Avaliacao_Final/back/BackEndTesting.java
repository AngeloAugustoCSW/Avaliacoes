package back;


public class BackEndTesting {
    public static void main(String[] args) {
        // ADD CAGE
        Cage cageUm = new Cage(1, "savana");
        Cage cageDois = new Cage(2, "oceano");
        // ADD LEAO
        Leao leaoUm = new Leao(1, "Tigor", 1, 1, "savana");
        // ADD GOLFINHO
        Golfinho golfinhoUm = new Golfinho(2, "Ecco", 1, "oceano");
        // PRINT
        System.out.println(leaoUm);
        System.out.println(golfinhoUm);
        System.out.println(cageUm);
        System.out.println(cageDois);
    }
}
