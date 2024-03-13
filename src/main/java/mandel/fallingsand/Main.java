package mandel.fallingsand;


public class Main {
    public static void main(String[] args) {
        Sand sand = new Sand(50, 10);
        sand.randomSand(50);
        boolean keepFalling = true;
        while (keepFalling) {
            for (int y = 1; y < 10; y++) {
                for (int x = 1; x < 49; x++) {
                    if (sand.get(x, y) == 1) {
                        continue;
                    }
                    if (sand.get(x, y) == 0 && sand.get(x, y - 1) == 0 && sand.get(x - 1, y - 1) == 0 && sand.get(x + 1, y - 1) == 0) {
                        if (y == 9 && x == 48) {
                            keepFalling = false;
                            break;
                        }
                    } else {
                        sand.fall();
                        System.out.println(sand.toString());
                    }
                }
            }
        }
    }
}
