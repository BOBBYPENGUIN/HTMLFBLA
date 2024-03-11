 import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;

public class Person extends JPanel{
    private Assets[] personArr;
    private boolean moving;
    private int direction;
    private int counter = 0;
    private int type = 8;
    private final int BASELINE = 80;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int x, y, scale;
    class TimerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(moving){
                if(direction == 1){
                    if(counter < BASELINE/4 || (counter >= BASELINE/2 && counter < BASELINE*3/4)){
                        setType(2);
                    } else if(counter >= BASELINE/4 && counter < BASELINE/2){
                        setType(4);
                    } else {
                        setType(6);
                        //System.out.println(personArr[1].type);
                    }
                }
                if(direction == 2){
                    if(counter < BASELINE/4 || (counter >= BASELINE/2 && counter < BASELINE*3/4)){
                        setType(8);
                    } else if(counter >= BASELINE/4 && counter < BASELINE/2){
                        setType(10);
                    } else {
                        setType(12);
                    }
                }
                if(direction == 3){
                    if(counter < BASELINE/4 || (counter >= BASELINE/2 && counter < BASELINE*3/4)){
                        setType(14);
                    } else if(counter >= BASELINE/4 && counter < BASELINE/2){
                        setType(16);
                    } else {
                        setType(18);
                        //System.out.println(personArr[1].type);
                    }
                }
                if(direction == 4){
                    if(counter < BASELINE/4 || (counter >= BASELINE/2 && counter < BASELINE*3/4)){
                        setType(20);
                    } else if(counter >= BASELINE/4 && counter < BASELINE/2){
                        setType(22);
                    } else {
                        setType(24);
                        //System.out.println(personArr[1].type);
                    }
                }
            }
            for(var i = 0; i < personArr.length; i++){
                personArr[i].translate(0, 0);
            }
            Rectangle dirty = new Rectangle(personArr[0].x, personArr[0].y, personArr[0].scale*16, personArr[0].scale*16*2);
            counter = counter + 1;
            counter = counter % BASELINE;
            repaint();
        }
        
    }
    /*class MyKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            keyIsPressed = true;
            var keyStroke = KeyStroke.getKeyStrokeForEvent(e).toString();
            char keyChar = keyStroke.charAt(keyStroke.length()-1);
            int keyCode = (int) keyChar;
            keyStatus[keyCode] = true;
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            keyIsPressed = false;
            var keyStroke = KeyStroke.getKeyStrokeForEvent(e).toString();
            char keyChar = keyStroke.charAt(keyStroke.length()-1);
            int keyCode = (int) keyChar;
            keyStatus[keyCode] = false;
            repaint();
        }
    }*/
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(var tile : personArr){
            tile.draw(g2);
        }
    }
    public Person(int x, int y, int scale){
        this.x = x;
        this.y = y;
        this.scale = scale;
        moving = true;
        direction = 3;
        personArr = new Assets[2];
        personArr[0] = new Assets(x, y, scale, type);
        personArr[1] = new Assets(x, y+16*scale, scale, type+1);
        add(personArr[0]);
        add(personArr[1]);
        final int DELAY = 1;
        var listener = new TimerListener();
        var timer = new Timer(DELAY, listener);
        timer.start();
    }
    public void setType(int newType){
        type = newType;
        personArr[0].changeType(newType);
        personArr[1].changeType(newType+1);
    }
    public void setDirection(int direction){
        this.direction = direction;
    }
    public void setMoving(boolean isMoving){
        this.moving = isMoving;
    }
}