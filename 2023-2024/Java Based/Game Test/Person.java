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
    private boolean keyIsPressed;
    private boolean[] keyStatus = new boolean[128];
    class TimerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            for(var i = 0; i < personArr.length; i++){
                personArr[i].translate(0, 0);
            }
            Rectangle dirty = new Rectangle(personArr[0].x, personArr[0].y, personArr[0].scale*16, personArr[0].scale*16*2);
            repaint();
        }
        
    }
    class MyKeyListener implements KeyListener {

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
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(var tile : personArr){
            tile.draw(g2);
        }
    }
    public Person(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        personArr = new Assets[2];
        personArr[0] = new Assets(200, 50, 5, 6);
        personArr[1] = new Assets(200, 130, 5, 7);
        //add(personArr[0]);
        //add(personArr[1]);
        final int DELAY = 1;
        var listener = new TimerListener();
        var timer = new Timer(DELAY, listener);
        timer.start();

    }
}