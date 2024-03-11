import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
    private Person panel = new Person(200, 50, 5);
    private Background background = new Background();
    public MainFrame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        add(background);
        add(panel);
        setSize(screenSize);
    }
}
