import java.awt.Button;
import java.awt.*;

import javax.swing.JFrame;

public class ButtonFrame extends JFrame{
    QuizFramework myButton = new QuizFramework(0, "getName()");
    public ButtonFrame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        add(myButton);
    }
    
}
