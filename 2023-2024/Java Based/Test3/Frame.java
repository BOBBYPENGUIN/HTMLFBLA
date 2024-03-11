import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Frame extends JFrame {
    class TimerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }
    BufferedImage myPicture;

    {
        try {
            myPicture = ImageIO.read(new File("Iowa.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    JLabel picLabel = new JLabel(new ImageIcon(myPicture));

    //private Person panel = new Person();
    public Frame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        add(picLabel);
        setSize(screenSize);
    }
}
