import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageTest extends JComponent{
    private int x, y;
    private int state = 0;
    private JTextField textField = new JTextField();


    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    BufferedImage iowa;
    BufferedImage national;

    private int[] iowaMoney = new int[6];
    private int[] nationalMoney = new int[5];
    {
        try {
            iowa = ImageIO.read(new File("Iowa.png"));
            national = ImageIO.read(new File("national.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    JLabel iowaLabel = new JLabel(new ImageIcon("Iowa.png"));
    JLabel nationalLabel = new JLabel(new ImageIcon("national.png"));
    public class ImageText(){
        public static void main(String[] args) {
            textField.setBounds(50,50,150,20);
        }

    }
    class myListener implements MouseListener{

        int color = iowa.getRGB((int)getMousePosition().getX(),(int)getMousePosition().getY());

        // Components will be in the range of 0..255:
        int blue = color & 0xff;
        int green = (color & 0xff00) >> 8;
        int red = (color & 0xff0000) >> 16;
        @Override
        public void mouseClicked(MouseEvent e) {
            if(state == 0){
                if(red ==  37 && green == 55 && blue == 123){
                    iowaMoney[0] = Integer.parseInt(textField.getText());
                }else if(red == 46 && green == 88 && blue == 167){
                    iowaMoney[1] = Integer.parseInt(textField.getText());
                }else if(red == 245 && green == 171 && blue == 27){
                    iowaMoney[2] = Integer.parseInt(textField.getText());
                }else if(red == 154 && green == 149 && blue == 149){
                    iowaMoney[3] = Integer.parseInt(textField.getText());
                }else if(red == 60 && green == 106 && blue == 179){
                    iowaMoney[4] = Integer.parseInt(textField.getText());
                }else if(red == 85 && green == 81 && blue == 80){
                    iowaMoney[5] = Integer.parseInt(textField.getText());
                }
            } else if(state == 1){

            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
