package main;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

enum Dir
{
    Left,Right,Down,Up;
}
public class Snake
{
    public  static int siz = 10;
    List<Snake_part> sp = new ArrayList<Snake_part>();
    public int x;
    public int y;
    public Dir direction;
    private int prevx;
    private int prevy;
    public boolean alive = true;
    int length = 3;
    public Snake()
    {
        direction = Dir.Down;
        for (int i = 1; i <= length;i++)
        {
            sp.add(new Snake_part());
        }
    }
    public void move()
    {

        switch (direction)
        {
            case Down:y+=siz;
                break;
            case Up:y-=siz;
                break;
            case Left:x-=siz;
                break;
            case Right:x+=siz;
                break;
        }
        if(x >= Main.width)
        {
            x =0;
        }
        if(y >= Main.height)
        {
            y = 0;
        }
        if(x <= -1)
        {
            x = Main.width;
        }
        if(y <= -1)
        {
            y = Main.height;
        }
        prevx = x;
        prevy = y;
        for (Snake_part s: sp)
        {

            int prvx = s.x;
            int prvy = s.y;
            s.x = prevx;
            s.y = prevy;
            prevx = prvx;
            prevy = prvy;
            if(prvx  >= x  && prvy >= y  && prvx + siz <= x + siz && prvy + siz <= y + siz)//improve self-collision
            {
                alive = false;
            }
        }
    }
    public void render(Graphics2D g2)
    {
        g2.setColor(Color.GREEN);
        g2.fillRect(x, y, siz, siz);
        for (Snake_part s: sp)
        {
            s.render(g2);
        }
    }
    public void collisonCheck()
    {
        for(Food fo:Game.lf)
        {

            if(x + siz >= fo.x && y + siz >= fo.y && x - siz <= fo.x && y - siz <= fo.y)
            {
                Game.lf.remove(0);
                Game.score++;
                Game.lf.add(new Food());
                sp.add(new Snake_part());
            }
        }
    }
}
