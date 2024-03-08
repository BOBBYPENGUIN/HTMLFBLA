import javax.swing.*;
import java.awt.*;

public class Assets extends JComponent{
    public int x, y, scale, type;
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
        }else if(this.type == 2){
            return getUpperPlayerBody();
        } else if(this.type == 3){
            return getLowerPlayerBody();
        } else if(this.type == 4){
            return getGrass();
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
    private Color DARKB = new Color(69,42,33);
    private Color SKINN = new Color(255,202,148);
    private Color BROWN = new Color(119,48,18);
    private Color BROW1 = new Color(89,51,40);
    private Color WHIT1 = new Color(229,197,198);
    private Color OUTLI = new Color(103,10,54);
    private Color ROSEE = new Color(223,113,114);
    private Color GRAYY = new Color(56,58,63);

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
    private Color[][] getUpperPlayerBody(){
        Color[][] colors = {
                {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR},
                {CLEAR, CLEAR, CLEAR, CLEAR, BLACK, BLACK, DARKB, DARKB, DARKB, DARKB, BLACK, BLACK, CLEAR, CLEAR, CLEAR, CLEAR},
                {CLEAR, CLEAR, CLEAR, BLACK, DARKB, DARKB, DARKB, DARKB, DARKB, DARKB, DARKB, DARKB, BLACK, CLEAR, CLEAR, CLEAR},
                {CLEAR, CLEAR, BLACK, DARKB, DARKB, DARKB, DARKB, DARKB, DARKB, DARKB, DARKB, DARKB, DARKB, BLACK, CLEAR, CLEAR},
                {CLEAR, CLEAR, BLACK, DARKB, DARKB, DARKB, DARKB, SKINN, SKINN, SKINN, DARKB, DARKB, DARKB, BLACK, CLEAR, CLEAR},
                {CLEAR, CLEAR, BLACK, DARKB, DARKB, SKINN, SKINN, SKINN, SKINN, SKINN, SKINN, DARKB, DARKB, BLACK, CLEAR, CLEAR},
                {CLEAR, CLEAR, BLACK, DARKB, BLACK, BLACK, BLACK, SKINN, SKINN, BLACK, BLACK, BLACK, DARKB, BLACK, CLEAR, CLEAR},
                {CLEAR, CLEAR, CLEAR, BLACK, BLACK, WHIT1, BROW1, SKINN, SKINN, BROW1, WHIT1, BLACK, BLACK, CLEAR, CLEAR, CLEAR},
                {CLEAR, CLEAR, CLEAR, BLACK, SKINN, WHITE, BROWN, SKINN, SKINN, BROWN, WHITE, SKINN, BLACK, CLEAR, CLEAR, CLEAR},
                {CLEAR, CLEAR, CLEAR, CLEAR, BLACK, SKINN, SKINN, SKINN, SKINN, SKINN, SKINN, BLACK, CLEAR, CLEAR, CLEAR, CLEAR},
                {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, BLACK, SKINN, SKINN, SKINN, SKINN, BLACK, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR},
                {CLEAR, CLEAR, CLEAR, CLEAR, BLACK, BLACK, CYANN, ROSEE, ROSEE, CYANN, BLACK, BLACK, CLEAR, CLEAR, CLEAR, CLEAR},
                {CLEAR, CLEAR, CLEAR, BLACK, GRAYY, GRAYY, GRAYY, REDDD, REDDD, GRAYY, GRAYY, GRAYY, BLACK, CLEAR, CLEAR, CLEAR},
                {CLEAR, CLEAR, BLACK, GRAYY, GRAYY, GRAYY, GRAYY, BLACK, BLACK, GRAYY, GRAYY, GRAYY, GRAYY, BLACK, CLEAR, CLEAR},
                {CLEAR, CLEAR, BLACK, GRAYY, BLACK, GRAYY, GRAYY, REDDD, REDDD, GRAYY, GRAYY, BLACK, GRAYY, BLACK, CLEAR, CLEAR},
                {CLEAR, CLEAR, BLACK, GRAYY, BLACK, GRAYY, GRAYY, REDDD, REDDD, GRAYY, GRAYY, BLACK, GRAYY, BLACK, CLEAR, CLEAR},
        };
        return colors;
    }
    private Color[][] getLowerPlayerBody(){
        Color[][] colors = {
                {CLEAR, CLEAR, BLACK, GRAYY, BLACK, GRAYY, GRAYY, REDDD, REDDD, GRAYY, GRAYY, BLACK, GRAYY, BLACK, CLEAR, CLEAR},
                {CLEAR, CLEAR, BLACK, GRAYY, BLACK, GRAYY, GRAYY, REDDD, REDDD, GRAYY, GRAYY, BLACK, GRAYY, BLACK, CLEAR, CLEAR},
                {CLEAR, CLEAR, BLACK, GRAYY, BLACK, GRAYY, GRAYY, GRAYY, GRAYY, GRAYY, GRAYY, BLACK, GRAYY, BLACK, CLEAR, CLEAR},
                {CLEAR, CLEAR, SKINN, SKINN, SKINN, GRAYY, GRAYY, GRAYY, GRAYY, GRAYY, GRAYY, SKINN, SKINN, SKINN, CLEAR, CLEAR},
                {CLEAR, CLEAR, SKINN, SKINN, SKINN, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, SKINN, SKINN, SKINN, CLEAR, CLEAR},
                {CLEAR, CLEAR, CLEAR, CLEAR, BLACK, GRAYY, GRAYY, GRAYY, GRAYY, GRAYY, GRAYY, BLACK, CLEAR, CLEAR, CLEAR, CLEAR},
                {CLEAR, CLEAR, CLEAR, CLEAR, BLACK, GRAYY, GRAYY, GRAYY, GRAYY, GRAYY, GRAYY, BLACK, CLEAR, CLEAR, CLEAR, CLEAR},
                {CLEAR, CLEAR, CLEAR, CLEAR, BLACK, GRAYY, BLACK, BLACK, BLACK, BLACK, GRAYY, BLACK, CLEAR, CLEAR, CLEAR, CLEAR},
                {CLEAR, CLEAR, CLEAR, CLEAR, BLACK, GRAYY, BLACK, CLEAR, CLEAR, BLACK, GRAYY, BLACK, CLEAR, CLEAR, CLEAR, CLEAR},
                {CLEAR, CLEAR, CLEAR, CLEAR, BLACK, GRAYY, BLACK, CLEAR, CLEAR, BLACK, GRAYY, BLACK, CLEAR, CLEAR, CLEAR, CLEAR},
                {CLEAR, CLEAR, CLEAR, CLEAR, BLACK, GRAYY, BLACK, CLEAR, CLEAR, BLACK, GRAYY, BLACK, CLEAR, CLEAR, CLEAR, CLEAR},
                {CLEAR, CLEAR, CLEAR, CLEAR, BLACK, GRAYY, BLACK, CLEAR, CLEAR, BLACK, GRAYY, BLACK, CLEAR, CLEAR, CLEAR, CLEAR},
                {CLEAR, CLEAR, CLEAR, CLEAR, BLACK, GRAYY, BLACK, CLEAR, CLEAR, BLACK, GRAYY, BLACK, CLEAR, CLEAR, CLEAR, CLEAR},
                {CLEAR, CLEAR, CLEAR, CLEAR, BLACK, GRAYY, BLACK, CLEAR, CLEAR, BLACK, GRAYY, BLACK, CLEAR, CLEAR, CLEAR, CLEAR},
                {CLEAR, CLEAR, CLEAR, CLEAR, BLACK, GRAYY, BLACK, CLEAR, CLEAR, BLACK, GRAYY, BLACK, CLEAR, CLEAR, CLEAR, CLEAR},
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
                g2.fill(pixelArr[column][row]);
            }
        }
    }
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Color[][] tileGridColors = getColorsByType();
        for(var row = 0; row < 16; row++){
            for(var column = 0; column < 16; column++){
                g2.setColor(tileGridColors[row][column]);
                g2.fill(pixelArr[column][row]);
            }
        }
    }
    public void translate(int dx, int dy){
        x += dx;
        y += dy;
        for(var row = 0; row < 16; row++){
            for(var column = 0; column < 16; column++){
                pixelArr[row][column].translate(dx, dy);
            }
        }
        repaint();
    }
}