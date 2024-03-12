package mandel.fallingsand;

import java.util.Random;

public class Sand {

    private final int[][] field;
    private final Random random;
    private int width;
    private int height;

    public Sand(int w, int h) {
        width = w;
        height = h;
        field = new int[h][w];
        this.random = new Random();
    }

    public Sand(int w, int h, Random random) {
        field = new int[h][w];
        this.random = random;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                builder.append(field[y][x]);
            }
            builder.append("\n");
        }

        return builder.toString();

    }

    /**
     * @return the value in field
     */

    public int get(int x, int y) {
        return field[y][x];
    }

    /**
     * Sets the value in field to be 1
     */

    public void put(int x, int y) {
        field[y][x] = 1;
    }

    public void fall() {
        //moves all sand down one square

        //if sand is at the bottom it can't go down
        //if sand falls and there's sand below it, it can't go anywhere

        for (int y = field.length - 2; y >= 0; y--) {
            for (int x = 0; x < field[y].length; x++) {
                if (field[y][x] == 1) {
                    // does the sand fall straight down?
                    if (field[y + 1][x] == 0) {
                        // does the sand fall straight down?
                        field[y][x] = 0;
                        field[y + 1][x] = 1;
                        continue;
                    }
                    boolean rightFirst = random.nextBoolean();
                    int direction1 = rightFirst ? +1 : -1;
                    int direction2 = rightFirst ? -1 : +1;

                    if (field[y + 1][x + direction1] == 0) {
                        field[y][x] = 0;
                        field[y + 1][x + direction1] = 1;
                    } else if (field[y + 1][x + direction2] == 0) {
                        field[y][x] = 0;
                        field[y + 1][x + direction2] = 1;
                    }
                }
            }
        }
    }

    public void randomSand(int n) {
        int x;
        int y;
        for (int i = 0; i < n; i++) {
            x = random.nextInt(field.length);
            y = random.nextInt(field[i].length);
            put(x, y);
        }
    }
}