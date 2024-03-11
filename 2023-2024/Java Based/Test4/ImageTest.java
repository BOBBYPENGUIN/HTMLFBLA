import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageTest {
    BufferedImage iowa;
    BufferedImage national;

    {
        try {
            iowa = ImageIO.read(new File("Iowa.png"));
            nati
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    JLabel picLabel = new JLabel(new ImageIcon(myPicture));
    public ImageTest(int x, int y, int state){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        add(picLabel);
        setSize(screenSize);
    }
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    add(picLabel);
    setSize(screenSize);

}
