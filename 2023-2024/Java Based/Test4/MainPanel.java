import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainPanel extends JPanel{
    private int state = 1;
    private boolean keyIsPressed;
    private boolean[] keyStatus = new boolean[525];
    Background background = new Background();
    Person person = new Person(200, 200, 5);
    class myTimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(keyIsPressed){
                if(keyStatus[87]){
                    person.setMoving(true);
                    person.setDirection(4);
                    background.translate(0, 5);
                }
                if(keyStatus[83]){
                    person.setMoving(true);
                    person.setDirection(1);
                    background.translate(0, -5);
                }
                if(keyStatus[68]){
                    person.setMoving(true);
                    person.setDirection(2);
                    background.translate(-5, 0);
                }
                if(keyStatus[65]){
                    person.setMoving(true);
                    person.setDirection(3);
                    background.translate(5, 0);
                }
            } else {
                person.setMoving(false);
                person.setType(2);
            }
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
            System.out.println(keyCode);
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
    public MainPanel(){
        setFocusable(true);
        requestFocus();
        add(background);
        add(person);
        MyKeyListener theKeyListener = new MyKeyListener();
        addKeyListener(theKeyListener);
        myTimerListener listen = new myTimerListener();
        int DELAY = 1;
        Timer myTimer = new Timer(DELAY, listen);
        myTimer.start();
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        background.draw(g2);
        person.draw(g2);
    }
}
