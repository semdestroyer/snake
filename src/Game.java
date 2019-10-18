package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Game extends JComponent implements KeyListener
{



    int speed = 50; // 1 fastest   ++slow
    public static int score = 0;
    Snake s = new Snake();
    public static List<Food> lf = new ArrayList<Food>();
    public Game()
    {
        lf.add(new Food());
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        if(s.alive == true)
        {

            s.render(g2d);
            g2d.setColor(Color.BLACK);
            g2d.drawString("Score:" + String.valueOf(score), Main.width - 100, Main.height - 100);
            try {
                s.move();
                s.collisonCheck();
                TimeUnit.MILLISECONDS.sleep(speed);
            } catch (InterruptedException e) {

            }
            for (Food f : lf) {
                f.render(g2d);
            }

        }
        else
        {
            g2d.setColor(Color.BLACK);
            g2d.drawString("Game Over", Main.width/2, Main.height/2);
        }
        repaint();
    }


    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            if(s.direction != Dir.Left)
            {
                s.direction = Dir.Right;
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            if(s.direction != Dir.Right)
            {
                s.direction = Dir.Left;
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            if(s.direction != Dir.Down)
            {
                s.direction = Dir.Up;
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            if(s.direction != Dir.Up)
            {
                s.direction = Dir.Down;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}
