import java.awt.Button;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ImageTestFrame extends JFrame{
    ImageTest image = new ImageTest(0);
    class myListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }
    public ImageTestFrame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        add(image);
        myListener listener = new myListener();
        Timer myTimer = new Timer(1, listener);
        myTimer.start();
    }

}
