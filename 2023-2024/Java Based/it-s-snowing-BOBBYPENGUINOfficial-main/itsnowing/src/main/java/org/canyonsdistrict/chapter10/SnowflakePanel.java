package org.canyonsdistrict.chapter10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class SnowflakePanel extends JPanel{
    private ArrayList<Snowflake> snowflakes;
    private int screenWidth, screenHeight;
    class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for(Snowflake snowflake : snowflakes){
                snowflake.fall(5);
            }
        }
    }
    private Random rand = new Random();
    public SnowflakePanel(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = (int) Math.round(screenSize.getWidth());
        screenHeight = (int) Math.round(screenSize.getHeight());
        snowflakes = new ArrayList<>();
        for(var i = 0; i < 100; i++){
            addRandomSnowflake();
        }

        var listener = new TimerListener();
        final int DELAY = 1;
        var timer = new Timer(DELAY, listener);
        timer.start();
    }
    private void addRandomSnowflake(){
        Snowflake newSnowflake = new Snowflake(rand.nextInt(screenWidth), rand.nextInt(screenHeight), 25, 10, 6);
        //System.out.println(newSnowflake.getY());
        snowflakes.add(newSnowflake);
        add(snowflakes.get(snowflakes.size()-1));
    }
    private void moveSnowflakes(){

    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for(var snowflake : snowflakes){
            snowflake.draw(g2);
        }
        repaint();
    }
}
