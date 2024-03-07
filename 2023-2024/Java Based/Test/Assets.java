import javax.swing.*;
import java.awt.*;

public class Assets extends JComponent{
    private int x, y, scale, type;
    private Rectangle[][] pixelArr = new Rectangle[16][16];
    public Assets(int x, int y, int scale, int type){
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.type = type;
        setTile();
    }
    private Color[][] getColorsByType(){
        if(this.type == 1){
            return getRedSquare();
        }
        return null;
    }
    private void setTile(){
        for(var row = 0; row < 16; row++){
            for(var column = 0; column < 16; column++){
                pixelArr[row][column] = new Rectangle(this.x + row * this.scale, this.y + column * this.scale, scale, scale);
            }
        }
    }
    //Defines the colors
    private Color REDDD = new Color(255,0,0);
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
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Color[][] tileGridColors = getColorsByType();
        for(var row = 0; row < 16; row++){
            for(var column = 0; column < 16; column++){
                g2.setColor(tileGridColors[row][column]);
                g2.fill(pixelArr[row][column]);
            }
        }
    }
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Color[][] tileGridColors = getColorsByType();
        for(var row = 0; row < 16; row++){
            for(var column = 0; column < 16; column++){
                g2.setColor(tileGridColors[row][column]);
                g2.fill(pixelArr[row][column]);
            }
        }
    }
    public void translate(int dx, int dy){
        for(var row = 0; row < 16; row++){
            for(var column = 0; column < 16; column++){
                pixelArr[row][column].translate(dx, dy);
            }
        }
        repaint();
        super.repaint();
    }
}
