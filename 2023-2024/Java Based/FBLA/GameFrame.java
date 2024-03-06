import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
    private ArrayList<Assets> tiles = new ArrayList<>();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public GameFrame(){
        tiles.add(new Assets(5, 5, 5, 1));
        for(var tile : tiles){
            add(tile);
        }
        setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
    }
}
