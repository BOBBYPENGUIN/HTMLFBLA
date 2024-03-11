import javax.swing.*;

import java.awt.*;
import java.util.*;
public class Background extends JComponent{
    private ArrayList<ArrayList<Assets>> background = new ArrayList<>();
    public void createBackground(){
        for(var i = 0; i < 20; i++){
            ArrayList<Assets> tempList = new ArrayList<>();
            for(var j = 0; j < 20; j++){
                Assets tile = new Assets(i*16*5, j*16*5, 5, 1);
                tempList.add(tile);
                add(tile);
            }
            background.add(tempList);
        }
    }
    public Background(){
        createBackground();
    }
    public void translate(int dx, int dy){
        for(var i : background){
            for(var j : i){
                j.translate(dx, dy);
            }
        }
        repaint();
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(var row : background){
            for(var tile : row){
                tile.draw(g2);
            }
        }
    }
    public void draw(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(var row : background){
            for(var tile : row){
                tile.draw(g2);
            }
        }
    }
}
