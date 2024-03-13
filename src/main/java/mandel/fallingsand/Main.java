package mandel.fallingsand;


public class Main {
    public static void main(String[] args) {
        Sand sand = new Sand(50, 10);
        sand.randomSand(50);
        boolean keepFalling = true;
        while (keepFalling) {
            String before = sand.toString();
            sand.fall();
            System.out.println(sand.toString());
            if (before.equals(sand.toString())) {
                keepFalling = false;
            }
        }
    }
}
