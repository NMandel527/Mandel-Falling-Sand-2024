package mandel.fallingsand;

public class Sand
{
    private int [][] field = new int[3][3];

    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (int y = 0; y < 3; y++)
        {
            for (int x = 0; x < 3; x++)
            {
                builder.append(field[y][x]);
            }
            builder.append("\n");
        }

        return builder.toString();

    }

    /**
     * @return the value in field
     */

    public int get(int x, int y)
    {
        return field[y][x];
    }

    /**
     * Sets the value in field to be 1
     */

    public void put(int x, int y)
    {
        field[y][x] = 1;
    }

    public void fall()
    {
        //moves all sand down one square

        //if sand is at the bottom it can't go down
        //if sand falls and there's sand below it, it can't go anywhere

        for (int i = field.length - 1; i > 0; i--)
        {
            for (int j = field[i].length - 1; j > 0; j--)
            {
                if (field[i][j] == 0 && field[i - 1][j] == 1)
                {
                    field[i][j] = 1;
                    field[i - 1][j] = 0;
                }
            }
        }
    }
}
