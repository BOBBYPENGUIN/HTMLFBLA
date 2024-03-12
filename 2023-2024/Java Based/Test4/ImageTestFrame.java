import java.awt.Button;
import java.awt.*;

import javax.swing.JFrame;

public class ImageTestFrame extends JFrame{
    ImageTest image = new ImageTest(0);
    public ImageTestFrame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        add(image);
    }

}
