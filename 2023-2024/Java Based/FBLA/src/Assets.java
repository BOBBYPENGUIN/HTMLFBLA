package src;
import javax.swing.*;
import java.awt.*;

public class Assets extends JComponent{
    private int x, y, scale, type;
    private Rectangle[][] pixelArr;
    public Assets(int x, int y, int scale, int type){
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.type = type;
    }
    private Color[][] getColorsByType(){
        if(this.type == 1){
            return getRedSquare();
        } else if(this.type == 2){
            return getPlayerHead();
        } else if(this.type == 3){
            return getPlayerTorso();
        } else if(this.type == 4){
            return getPlayerLegs();
        } else if(this.type == 5){
            return getGrass();
        }
        return null;
    }
    private int[][][] getCoordinates(){
        var positions = new int[16][16][2];
        for(var row = 0; row < 16; row++){
            for(var column = 0; column < 16; column++){
                positions[row][column][0] = this.x + row * this.scale;
                positions[row][column][1] = this.y + column * this.scale;
            }
        }
        return positions;
    }
    //Defines the colors
    private Color REDDD = new Color(255,0,0);
    private Color GREEN = new Color(0,255,0);
    private Color DARKG = new Color(12, 89, 34);
    private Color GREE2 = new Color(79,164,70);
    private Color GREE3 = new Color(148,200,63);
    private Color GREE4 = new Color(75,153,69);
    private Color BLACK = new Color(0,0,0);
    private Color WHITE = new Color(255,255,255);
    private Color CLEAR = new Color(255,255,255,0);
    private Color SANDD = new Color(194,178,128);
    private Color CYANN = new Color(0,255,255);
    private Color MOUTH = new Color(239,192,182);
    private Color SHIRT = new Color(100,255,100);

    private Color[][] getRedSquare(){
        Color[][] colors = {
            {REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD},
            {REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD},
            {REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD},
            {REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD},
            {REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD},
            {REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD},
            {REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD},
            {REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD},
            {REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD},
            {REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD},
            {REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD},
            {REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD},
            {REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD},
            {REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD},
            {REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD},
            {REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD, REDDD}
        };
        return colors;
    }
   private Color[][] getPlayerHead(){
       Color[][] colors = {
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR},
            {CLEAR, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, CLEAR},
            {CLEAR, BLACK, BLACK, BLACK, BLACK, SANDD, SANDD, SANDD, SANDD, SANDD, BLACK, BLACK, BLACK, BLACK, BLACK, CLEAR},
            {CLEAR, BLACK, SANDD, BLACK, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, BLACK, BLACK, SANDD, BLACK, CLEAR},
            {CLEAR, BLACK, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, BLACK, CLEAR},
            {CLEAR, BLACK, SANDD, SANDD, SANDD, WHITE, WHITE, SANDD, SANDD, WHITE, WHITE, SANDD, SANDD, SANDD, BLACK, CLEAR},
            {CLEAR, BLACK, SANDD, SANDD, SANDD, WHITE, CYANN, SANDD, SANDD, WHITE, CYANN, SANDD, SANDD, SANDD, BLACK, CLEAR},
            {CLEAR, BLACK, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, BLACK, CLEAR},
            {CLEAR, BLACK, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, BLACK, CLEAR},
            {CLEAR, BLACK, SANDD, SANDD, SANDD, MOUTH, SANDD, SANDD, SANDD, SANDD, MOUTH, SANDD, SANDD, SANDD, BLACK, CLEAR},
            {CLEAR, CLEAR, BLACK, SANDD, SANDD, SANDD, MOUTH, MOUTH, MOUTH, MOUTH, SANDD, SANDD, SANDD, BLACK, CLEAR, CLEAR},
            {CLEAR, CLEAR, BLACK, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, BLACK, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, BLACK, BLACK, SANDD, SANDD, SANDD, SANDD, SANDD, SANDD, BLACK, BLACK, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR},
           
           };
        return colors;
    }
    private Color[][] getPlayerTorso(){
        Color[][] colors = {
            {CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR},
            {CLEAR, BLACK, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, BLACK, CLEAR},
            {BLACK, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, BLACK},
            {BLACK, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, BLACK},
            {BLACK, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, BLACK},
            {BLACK, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, BLACK},
            {BLACK, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, BLACK},
            {BLACK, SHIRT, BLACK, BLACK, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, BLACK, BLACK, SHIRT, BLACK},
            {BLACK, SHIRT, CLEAR, BLACK, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, BLACK, CLEAR, SHIRT, BLACK},
            {BLACK, SHIRT, CLEAR, BLACK, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, BLACK, CLEAR, SHIRT, BLACK},
            {BLACK, SHIRT, CLEAR, BLACK, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, BLACK, CLEAR, SHIRT, BLACK},
            {BLACK, SHIRT, CLEAR, BLACK, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, BLACK, CLEAR, SHIRT, BLACK},
            {BLACK, SHIRT, CLEAR, BLACK, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, BLACK, CLEAR, SHIRT, BLACK},
            {BLACK, SHIRT, CLEAR, BLACK, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, BLACK, CLEAR, SHIRT, BLACK},
            {BLACK, SHIRT, CLEAR, BLACK, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, BLACK, CLEAR, SHIRT, BLACK},
            {SANDD, SANDD, CLEAR, BLACK, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, BLACK, CLEAR, SANDD, SANDD}
        };
        return colors;
    }
    private Color[][] getPlayerLegs(){
        Color[][] colors = {
            {CLEAR, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, CLEAR},
        };
        return colors;
    }
    private Color[][] getGrass(){
        Color[][] colors = {
            {GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2},
            {GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2},
            {GREE2, GREE2, GREE2, GREE3, GREE2, GREE2, GREE2, GREE2, GREE2, GREE4, GREE2, GREE2, GREE3, GREE2, GREE4, GREE2},
            {GREE2, GREE2, GREE3, GREE2, GREE2, GREE2, GREE2, GREE3, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2},
            {GREE2, GREE2, GREE2, GREE2, GREE2, GREE4, GREE2, GREE2, GREE3, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2},
            {GREE2, GREE2, GREE4, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE3, GREE2},
            {GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE4, GREE2, GREE2, GREE3, GREE2, GREE2},
            {GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE4, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2},
            {GREE2, GREE2, GREE3, GREE2, GREE2, GREE2, GREE3, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2},
            {GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE3, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2},
            {GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE4, GREE2, GREE2},
            {GREE2, GREE2, GREE2, GREE4, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE4, GREE2, GREE2, GREE2, GREE2},
            {GREE2, GREE2, GREE2, GREE2, GREE2, GREE3, GREE2, GREE2, GREE3, GREE2, GREE2, GREE2, GREE2, GREE3, GREE2, GREE2},
            {GREE2, GREE3, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE3, GREE2, GREE3, GREE2},
            {GREE2, GREE2, GREE3, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE4, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2},
            {GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2, GREE2},
        };
        return colors;
    }
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Color[][] tileGridColors = getColorsByType();
        for(var row = 0; row < 16; row++){
            for(var column = 0; column < 16; column++){
                g2.setColor(tileGridColors[row][column]);
                Rectangle rect = new Rectangle(getCoordinates()[row][column][0], getCoordinates()[row][column][1], scale, scale);
                g2.fill(rect);
            }
        }
    }
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Color[][] tileGridColors = getColorsByType();
        for(var row = 0; row < 16; row++){
            for(var column = 0; column < 16; column++){
                g2.setColor(tileGridColors[row][column]);
                Rectangle rect = new Rectangle(getCoordinates()[row][column][0], getCoordinates()[row][column][1], scale, scale);
                g2.draw(rect);
            }
        }
    }
    public void translate(int dx, int dy){
        this.x += dx;
        this.y += dy;
        repaint();
    }
}
