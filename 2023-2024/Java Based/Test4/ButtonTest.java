import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class ButtonTest extends JFrame{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int state = 1;
    int type;
    String text;
    class myListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(state == 1){
                drawInstructions();
                repaint();
            } else {
                drawMainScene();
                repaint();
            }
        }
        
    }
    private JPanel panel = new JPanel();
    private JButton button1 = new JButton("Test1");
    private JButton button2 = new JButton("Enter Game");
    private JButton backButton = new JButton("Back");
    private JLabel title = new JLabel("Title");
    private JLabel directions = new JLabel("Lorem ipsum");
    myListener listen = new myListener();
    public ButtonTest(int type, String text){
        this.type = type;
        this.text = text;
        panel.setLayout(null);
        drawMainScene();
        add(panel);
        setSize(screenSize);
    }
    public void drawMainScene(){
        state = 1;
        panel.remove(backButton);
        panel.remove(directions);
        button1.setBackground(new Color(0, 255, 255));
        button1.setBounds(10, 500, 500, 500);
        button1.addActionListener(listen);
        title.setBounds(100, 100, 200, 200);
        title.setFont(new Font("Serif", Font.PLAIN, 50));
        button2.setBounds(550, 500, 500, 500);
        panel.add(button1); 
        panel.add(button2);
        panel.add(title);
    }
    public void drawInstructions(){
        state = 2;
        panel.remove(title);
        panel.remove(button1);
        backButton.setBounds(1000, 500, 500, 500);
        backButton.addActionListener(listen);
        directions.setBounds(100, 100, 1000, 100);
        directions.setFont(new Font("Serif", Font.PLAIN, 50));
        panel.add(backButton);
        panel.add(directions);
    }

}