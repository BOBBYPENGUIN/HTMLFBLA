import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainPanel extends JPanel{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int state = 1;
    private boolean keyIsPressed;
    private boolean[] keyStatus = new boolean[525];
    Background background = new Background();
    Person person;
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
            for(var i : keyStatus){
                if(i == true){
                    keyIsPressed = true;
                }
            }
            repaint();
        }
    }
    MyKeyListener theKeyListener = new MyKeyListener();
    public MainPanel(){
        reset();
    }
    public void addKeyListener(){
        removeKeyListener(theKeyListener);
        setFocusable(true);
        addKeyListener(theKeyListener);
        requestFocus();
        reset();
        repaint();    
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        background.draw(g2);
        person.draw(g2);
    }
    public void reset(){
        person = new Person((int)screenSize.getWidth()/2, (int)screenSize.getHeight()/2, 5);
        setFocusable(true);
        requestFocus();
        add(background);
        add(person);
        addKeyListener(theKeyListener);
        myTimerListener listen = new myTimerListener();
        int DELAY = 1;
        Timer myTimer = new Timer(DELAY, listen);
        myTimer.start();
    }
}
