package mandel.fallingsand;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SandComponent extends JComponent {

    private final Sand sand;
    private Random random;

    public SandComponent(Sand sand) {
        this.sand = sand;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw the sand
        sand.fall();
        repaint();

        for (int y = 0; y < sand.getHeight(); y++) {
            for (int x = 0; x < sand.getWidth(); x++) {
                if (sand.get(x, y) == 1) {
                    g.fillRect(x * 2, y, 2, 2);
                }
            }
        }
    }
}