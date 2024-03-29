package mandel.fallingsand;

import java.util.Random;

public class Sand {

    private final int[][] field;
    private final Random random;
    private int width;
    private int height;

    public Sand(int width, int height) {
        this.width = width;
        this.height = height;
        field = new int[height][width];
        this.random = new Random();
    }

    public Sand(int width, int height, Random random) {
        this.width = width;
        this.height = height;
        field = new int[height][width];
        this.random = random;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {
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

    public boolean position(int x, int y) {
        return field[y][x] == 1;
    }

    public int[][] getField() {
        return field;
    }

    public void fall() {
        //moves all sand down one square

        //if sand is at the bottom it can't go down
        //if sand falls and there's sand below it, it can't go anywhere

        for (int y = field.length - 2; y >= 0; y--) {
            for (int x = 0; x < field[y].length; x++) {
                if (field[y][x] == 1) {
                    if (field[y + 1][x] == 0) {
                        // does the sand fall straight down?
                        field[y][x] = 0;
                        field[y + 1][x] = 1;
                        continue;
                    }

                    boolean rightFirst = random.nextBoolean();
                    int direction1 = rightFirst ? +1 : -1;
                    int direction2 = rightFirst ? -1 : +1;

                    //make sure it doesn't go out of bounds
                    if (x + direction1 >= 0 && x + direction1 < field[y].length
                            && field[y + 1][x + direction1] == 0) {
                        field[y][x] = 0;
                        field[y + 1][x + direction1] = 1;
                    } else if (x + direction2 >= 0 && x + direction2 < field[y].length
                            && field[y + 1][x + direction2] == 0) {
                        field[y][x] = 0;
                        field[y + 1][x + direction2] = 1;
                    }
                }
            }
        }
    }

    public void randomSand(int n) {
        for (int i = 0; i < n; i++) {
            int length = field.length;
            int y = random.nextInt(length);
            int x = random.nextInt(field[y].length);
            put(x, y);
        }
    }
}