import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
    private Person panel = new Person(200, 50, 5);
    private MainPanel thePanel = new MainPanel();
    class myTimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
        
    }
    public MainFrame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //setLayout(null);
        add(thePanel);
        //add(panel);
        setSize(screenSize);
        myTimerListener listen = new myTimerListener();
        int DELAY = 1;
        Timer myTimer = new Timer(DELAY, listen);
        myTimer.start();
    }
}
