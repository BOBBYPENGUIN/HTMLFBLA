package src;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class GameFrame extends JFrame{
    private ArrayList<Assets> tiles = new ArrayList<>();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    boolean[] keyStatus = new boolean[128];
    boolean keyIsPressed = false;
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
        }

        @Override
        public void keyReleased(KeyEvent e) {
            keyIsPressed = false;
            var keyStroke = KeyStroke.getKeyStrokeForEvent(e).toString();
            char keyChar = keyStroke.charAt(keyStroke.length()-1);
            int keyCode = (int) keyChar;
            keyStatus[keyCode] = false;
        }
        
    }

    public GameFrame(){
        var listener = new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true);
        tiles.add(new Assets(5, 5, 5, 1));
        for(var tile : tiles){
            add(tile);
        }
        if(keyStatus[87] == true){
            tiles.get(0).grabFocus();
            tiles.get(0).translate(0, 1);
            System.out.println("Son");
        }
        if(keyIsPressed){
            System.out.println("TE");
        }
        requestFocus();
    }
}
