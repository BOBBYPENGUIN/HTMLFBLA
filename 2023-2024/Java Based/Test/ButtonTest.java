import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class ButtonTest extends JFrame{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
    class myListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("STuff");                            
        }
        
    }
    private JPanel panel = new JPanel();
    private JButton button1 = new JButton("Test1");
    private JButton button2 = new JButton("Test2");
    public ButtonTest(){
        panel.setLayout(null);
        myListener listen = new myListener();
        button1.setBackground(new Color(0, 255, 255));
        button1.setBounds(500, 500, 500, 500);
        //panel.setLayout(getLayout());
        panel.add(button1); 
        panel.add(button2);
        Dimension testDimention = new Dimension(40,49);
        //panel.setPreferredSize(testDimention);
        add(panel);
        setSize(screenSize);
    }
}