import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class ButtonTest extends JFrame{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int type;
    String text;
    class myListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(type == 1){
                
            }
        }
        
    }
    private JPanel panel = new JPanel();
    private JButton button1 = new JButton("Test1");
    private JButton button2 = new JButton("Test2");
    private JLabel title = new JLabel("Title");
    public ButtonTest(int type, String text){
        this.type = type;
        this.text = text;
        panel.setLayout(null);
        myListener listen = new myListener();
        button1.setBackground(new Color(0, 255, 255));
        button1.setBounds(500, 500, 500, 500);
        title.setBounds(200, 100, 600, 200);
        //panel.setLayout(getLayout());
        panel.add(button1); 
        panel.add(button2);
        panel.add(title);
        Dimension testDimention = new Dimension(40,49);
        //panel.setPreferredSize(testDimention);
        add(panel);
        setSize(screenSize);
    }

}