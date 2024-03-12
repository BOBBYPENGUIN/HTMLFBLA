import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class MainFrame extends JFrame{
    private ButtonTest homepage;
    private boolean initStatus[] = {false};
    class myListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(homepage.getState() != 0 && !initStatus[0]){
                initStatus[0] = true;
                initWorld();
            }
            repaint();
        }
        
    }
    private Person panel = new Person(200, 50, 5);
    private MainPanel thePanel = new MainPanel();
    public MainFrame(){
        homepage = new ButtonTest(0, "0");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        //setLayout(null);
        //add(thePanel);
        add(homepage);
        myListener listener = new myListener();
        Timer timer = new Timer(1, listener);
        timer.start();
    }
    public void initWorld(){
        remove(homepage);
        add(thePanel);
    }
}
