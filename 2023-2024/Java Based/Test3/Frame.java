import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Frame extends JFrame{
    class TimerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
    private Person panel = new Person();
    public Frame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        add(panel);
        setSize(screenSize);
    }
}
