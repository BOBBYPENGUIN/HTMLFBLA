import java.awt.Button;
import java.awt.*;

import javax.swing.JFrame;

public class ButtonFrame extends JFrame{
    ButtonTest myButton = new ButtonTest(0, "getName()");
    public ButtonFrame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        add(myButton);
    }
    
}
