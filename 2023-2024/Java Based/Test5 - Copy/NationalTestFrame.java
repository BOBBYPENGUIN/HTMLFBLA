import java.awt.Button;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NationalTestFrame extends JFrame{
    NationalTest image = new NationalTest(0, 1000);
    class myListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }
    public NationalTestFrame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        add(image);
        myListener listener = new myListener();
        Timer myTimer = new Timer(1, listener);
        myTimer.start();
    }

}
