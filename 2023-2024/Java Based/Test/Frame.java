import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame extends JFrame{
    private Person panel = new Person();
    public Frame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        add(panel);
        setSize(screenSize);
    }
}
