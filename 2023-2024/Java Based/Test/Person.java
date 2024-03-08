import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import javax.swing.JPanel;

public class Person extends JPanel{
    private Assets[] personArr;
    class TimerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            for(var i = 0; i < personArr.length; i++){
                personArr[i].translate(1, 0);
            }
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
        personArr[0] = new Assets(50, 50, 5, 1);
        personArr[1] = new Assets(50, 130, 5, 1);
        add(personArr[0]);
        add(personArr[1]);
        final int DELAY = 2;
        var listener = new TimerListener();
        var timer = new Timer(DELAY, listener);
        timer.start();

    }
}