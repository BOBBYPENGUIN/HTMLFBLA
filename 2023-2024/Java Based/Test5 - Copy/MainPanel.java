import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainPanel extends JPanel{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int state = 1;
    boolean keyIsPressed;
    boolean[] keyStatus = new boolean[525];
    public int dx, dy;
    private int backgroundWidth = 60;
    private int backgroundHeight = 20;
    NationalBackground background = new NationalBackground(backgroundWidth, backgroundHeight);
    Person person = new Person((int)screenSize.getWidth()/2, (int)screenSize.getHeight()/2, 5);
    class myTimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(keyIsPressed){
                if(keyStatus[87]){
                    person.setMoving(true);
                    person.setDirection(4);
                    if(dy <= 0){
                        background.translate(0, 5);
                        dy += 5;
                    }
                }
                if(keyStatus[83]){
                    person.setMoving(true);
                    person.setDirection(1);
                    if(dy >= -(backgroundHeight-11)*16*5){
                        background.translate(0, -5);
                        dy += -5;
                    }
                }
                if(keyStatus[68]){
                    person.setMoving(true);
                    person.setDirection(2);
                    if(dx >= -(backgroundWidth-18)*16*5){
                        background.translate(-5, 0);
                        dx += -5;
                    }
                }
                if(keyStatus[65]){
                    person.setMoving(true);
                    person.setDirection(3);
                    if(dx <= 0){
                        background.translate(5, 0);
                        dx += 5;
                    }
                }
            } else {
                person.setMoving(false);
                person.setType(2);
            }
            repaint(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
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
        setFocusable(true);
        requestFocus();
        add(background);
        add(person);
        for(var i = 0; i < keyStatus.length; i++){
            keyStatus[i] = false;
        }
        keyIsPressed = false;
        addKeyListener(theKeyListener);
        myTimerListener listen = new myTimerListener();
        int DELAY = 1;
        Timer myTimer = new Timer(DELAY, listen);
        myTimer.start();
    }
}
