package main;

import java.awt.*;

public class Snake_part
{

    public int x;
    public int y;
    public void render(Graphics2D g2d)
    {
        g2d.setColor(Color.GREEN);
        g2d.fillRect(x,y,Snake.siz,Snake.siz);

    }

}
