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
    class myListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(state == 0){
                if(iowa.getRGB((int)getMousePosition().getX(),(int)getMousePosition().getY()) == (0,0,0)){

                }
                        getMousePosition())
            } else {
                drawMainScene();
                repaint();
            }
        }

    }
}
