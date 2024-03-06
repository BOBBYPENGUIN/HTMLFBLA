package src;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

public class Game {

    public static void main(String[] args) {
        var frame = new GameFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
