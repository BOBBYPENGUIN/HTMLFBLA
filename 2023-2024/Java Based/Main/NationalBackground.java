import javax.swing.*;

import java.awt.*;
import java.util.*;
public class NationalBackground extends JComponent{
    private ArrayList<ArrayList<Assets>> background = new ArrayList<>();
    ArrayList<Assets> extras = new ArrayList<>();
    private int width, height;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public void createBackground(){
        for(var i = 0; i < width; i++){
            ArrayList<Assets> tempList = new ArrayList<>();
            for(var j = 0; j < height; j++){
                Assets tile = new Assets(i*16*5, j*16*5, 10, 1);
                tempList.add(tile);
                add(tile);
            }
            background.add(tempList);
        }
        extras.add(new Assets(3*16*20, 2*16*20, 20, 30));
        extras.add(new Assets(4*16*20, 2*16*20, 20, 31));
        extras.add(new Assets(3*16*20, 3*16*20, 20, 32));
        extras.add(new Assets(4*16*20, 3*16*20, 20, 33));
        background.add(extras);
    }
    public NationalBackground(int width, int height){
        this.width = width;
        this.height = height;
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