package org.canyonsdistrict.chapter10;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;
public class Snowflake extends JComponent {
    private double x, y, radius, tinyRadius, screenWidth, screenHeight;
    private Ellipse2D body;
    private ArrayList<Ellipse2D> tinyCircles = new ArrayList<>();
    public Snowflake(double x, double y, double radius, double tinyRadius, double numOfTinyCircles){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = (int) Math.round(screenSize.getWidth());
        screenHeight = (int) Math.round(screenSize.getHeight());
        this.x = x+radius;
        this.y = y+radius;
        this.radius = radius;
        this.tinyRadius = tinyRadius;
        body = new Ellipse2D.Double(this.x, this.y, radius, radius);
        for(var i = 0; i < numOfTinyCircles; i++){
            tinyCircles.add(new Ellipse2D.Double(0, 0, 0, 0));
        }
        this.body = getCircle(x, y, radius);
        for(var i = 0; i < tinyCircles.size(); i++){
            double theta = i*Math.PI*2/tinyCircles.size();
            double deltaX = radius*Math.cos(theta);
            double deltaY = radius*Math.sin(theta);
            tinyCircles.set(i, getCircle(deltaX + x, deltaY + y, tinyRadius));
        }
    } 
    public Ellipse2D.Double getCircle(double x, double y, double radius){
        return(new Ellipse2D.Double(x-radius, y-radius, radius*2, radius*2));
    }
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(body);
        for(var tinyCircle : tinyCircles){
            g2.draw(tinyCircle);
        }
    }
    public void fall(double dy){
        if(body.getY() > screenHeight){
            dy = - screenHeight - radius*2;
        }
        double bodyY = body.getY() + dy;
        body.setFrame(body.getX(), bodyY, body.getWidth(), body.getHeight());
        for(var tinyCircle : tinyCircles){
            double newX = tinyCircle.getX();
            double newY = tinyCircle.getY() + dy;
            tinyCircle.setFrame(newX, newY, tinyCircle.getWidth(), tinyCircle.getHeight());
        }
        repaint();
    }
    public double getTheY(){
        return this.y;
    }
}
