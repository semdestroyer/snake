package main;

import java.awt.*;
import java.util.Random;

public class Food
{
    public int lenghtAdd = 1;
    public int y;
    public int x;
    public Food()
    {
        Random r = new Random();
        x = (Main.width-25) - r.nextInt(Main.width-50);
        y = (Main.height-50) - r.nextInt(Main.height-100);

    }
    void render(Graphics2D g2d)
    {
        g2d.setColor(Color.BLACK);

        g2d.fillOval(x,y,10,10);
    }

}
