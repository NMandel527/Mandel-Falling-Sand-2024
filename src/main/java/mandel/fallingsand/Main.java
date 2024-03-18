package mandel.fallingsand;


public class Main {
    public static void main(String[] args) {
        Sand sand = new Sand(50, 10);
        sand.randomSand(50);
        boolean keepFalling = true;
        while (keepFalling) {
            new SandFrame().setVisible(true);
            String before = sand.toString();
            sand.fall();
            String after = sand.toString();
            System.out.println(after);
            if (before.equals(after)) {
                keepFalling = false;
            }
        }
    }
}
