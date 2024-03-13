import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

class InfoPanel extends JPanel{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    String text;
    private JLabel result;
    public InfoPanel(String text){
        removeAll();
        this.text = text;
        setLayout(null);
        setSize(screenSize);
        result = new JLabel(text, SwingConstants.CENTER);
        result.setBounds((int) screenSize.getWidth()/5, (int) screenSize.getHeight ()/10, (int) screenSize.getWidth()*3/5, (int) screenSize.getHeight()/5);
        result.setFont(new Font("Serif", Font.PLAIN, 50));
        //System.out.println(result.getText());
        add(result);
        //repaint();
        
    }

}