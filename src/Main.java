package main;

import javax.swing.*;
import java.awt.*;

public class Main
{
    public static int width = 640;
    public static int height= 640;

    static public void main(String[] args)
    {
       JFrame wind = new JFrame("Snake");
       Game g = new Game();
       wind.setResizable(false);
       wind.setSize(width,height);
       wind.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       wind.add(g);
       wind.addKeyListener(g);
       wind.setVisible(true);
    }
}
