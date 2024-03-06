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
        } else {
            return getRedSquare();
        }
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
                g2.fillRect(getCoordinates()[row][column][0], getCoordinates()[row][column][1], scale, scale);
            }
        }

    }
    
}
