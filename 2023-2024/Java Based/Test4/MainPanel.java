import java.awt.*;

import javax.swing.JPanel;

public class MainPanel extends JPanel{
    Background background = new Background();
    Person person = new Person(200, 200, 5);
    public MainPanel(){
        add(background);
        add(person);
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        background.draw(g2);
        person.draw(g2);
    }
}
