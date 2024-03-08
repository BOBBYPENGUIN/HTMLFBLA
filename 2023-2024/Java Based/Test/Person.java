import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Person extends JPanel{
    private Assets[] personArr;
    private ArrayList<ArrayList<Assets>> background;
    class TimerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            for(var i = 0; i < personArr.length; i++){
                personArr[i].translate(-1, 0);
            }
            Rectangle dirty = new Rectangle(personArr[0].x, personArr[0].y, personArr[0].scale*16, personArr[0].scale*16*2);
            repaint(dirty);
        }
        
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(var row : background){
            for(var tile : row){
                tile.draw(g2);
            }
        }
        for(var tile : personArr){
            tile.draw(g2);
        }
    }
    public Person(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        background = new ArrayList<>();
        for(var i = 0; i < 20; i++){
            ArrayList<Assets> row = new ArrayList<>();
            for(var j = 0; j < 20; j++){
                row.add(new Assets(i*5*16, j*5*16, 5, 4));
            }
            background.add(row);
        }
        personArr = new Assets[2];
        personArr[0] = new Assets(2000, 50, 5, 2);
        personArr[1] = new Assets(2000, 130, 5, 3);
        for(var row : background){
            for(var tile : row){
                //add(tile);
            }
        }
        //add(personArr[0]);
        //add(personArr[1]);
        final int DELAY = 1;
        var listener = new TimerListener();
        var timer = new Timer(DELAY, listener);
        timer.start();

    }
}