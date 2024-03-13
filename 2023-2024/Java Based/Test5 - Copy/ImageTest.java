import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class ImageTest extends JPanel{
    MainFrame mainFrame = new MainFrame();

    private int state = 0;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    BufferedImage iowa;
    BufferedImage national;
    int beginCash = mainFrame.getCash();

    private int[] iowaMoney = new int[6];
    private int[] nationalMoney = new int[5];
    private JLabel instructions = new JLabel("Money Remaining: " + beginCash);
    private JLabel money = null;
    private JLabel district1 = new JLabel("District 1:");
    private JLabel district2 = new JLabel("District 2:");
    private JLabel district3 = new JLabel("District 3:");
    private JLabel district4 = new JLabel("District 4:");
    private JLabel district5 = new JLabel("District 5:");
    private JLabel district6 = new JLabel("District 6:");
    private JTextField tf1 = new JTextField();
    private JTextField tf2 = new JTextField();
    private JTextField tf3 = new JTextField();
    private JTextField tf4 = new JTextField();
    private JTextField tf5 = new JTextField();
    private JTextField tf6 = new JTextField();
    {
        try {
            iowa = ImageIO.read(new File("Iowa.png"));
            national = ImageIO.read(new File("national.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    class TimerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int cash = beginCash;
            if(!tf1.getText().equals("")){
                cash -= Integer.parseInt(tf1.getText());
            }
            if(!tf2.getText().equals("")){
                cash -= Integer.parseInt(tf2.getText());
            }
            if(!tf3.getText().equals("")){
                cash -= Integer.parseInt(tf3.getText());
            }
            if(!tf4.getText().equals("")){
                cash -= Integer.parseInt(tf4.getText());
            }
            if(!tf5.getText().equals("")){
                cash -= Integer.parseInt(tf5.getText());
            }
            if(!tf6.getText().equals("")){
                cash -= Integer.parseInt(tf6.getText());
            }

            instructions.setText("Money Remaining: " + cash);
            repaint();
        }

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //iowa.
        int iowaX = (this.getWidth()/2 - iowa.getWidth(null)/2)/2;
        int iowaY = (this.getHeight() - iowa.getHeight(null)/2)/2;
        if(state == 0){
            g.drawImage(iowa, iowaX, iowaY, iowa.getWidth()/2,iowa.getHeight()/2, this);
        }

    }
    JLabel nationalLabel = new JLabel(new ImageIcon("national.png"));


    public ImageTest(int state){
        this.state = state;
        setLayout(null);
        if(state == 0){
            drawIowa();
        }
        else if(state == 1){
            //drawNational();
        }
        setSize(screenSize);
        TimerListener listener = new TimerListener();
        Timer timer = new Timer(1, listener);
        timer.start();
    }
    public void drawIowa(){
        instructions.setBounds((int)screenSize.getWidth()/2, 0, 1000, 100);
        instructions.setFont(new Font("Serif", Font.PLAIN, 30));
        district1.setBounds((int)screenSize.getWidth()/2, (int) screenSize.getHeight()*1/8, 1000, 100);
        district1.setFont(new Font("Serif", Font.PLAIN, 25));
        district2.setBounds((int)screenSize.getWidth()/2, (int) screenSize.getHeight()*2/8, 1000, 100);
        district2.setFont(new Font("Serif", Font.PLAIN, 25));
        district3.setBounds((int)screenSize.getWidth()/2, (int) screenSize.getHeight()*3/8, 1000, 100);
        district3.setFont(new Font("Serif", Font.PLAIN, 25));
        district4.setBounds((int)screenSize.getWidth()/2, (int) screenSize.getHeight()*4/8, 1000, 100);
        district4.setFont(new Font("Serif", Font.PLAIN, 25));
        district5.setBounds((int)screenSize.getWidth()/2, (int) screenSize.getHeight()*5/8, 1000, 100);
        district5.setFont(new Font("Serif", Font.PLAIN, 25));
        district6.setBounds((int)screenSize.getWidth()/2, (int) screenSize.getHeight()*6/8, 1000, 100);
        district6.setFont(new Font("Serif", Font.PLAIN, 25));
        tf1.setBounds((int)screenSize.getWidth()/2 + 250, (int) screenSize.getHeight()*1/8 + 25, 250, 50);
        tf1.setFont(new Font("Serif", Font.PLAIN, 25));
        tf2.setBounds((int)screenSize.getWidth()/2 + 250, (int) screenSize.getHeight()*2/8 + 25, 250, 50);
        tf2.setFont(new Font("Serif", Font.PLAIN, 25));
        tf3.setBounds((int)screenSize.getWidth()/2 + 250, (int) screenSize.getHeight()*3/8 + 25, 250, 50);
        tf3.setFont(new Font("Serif", Font.PLAIN, 25));
        tf4.setBounds((int)screenSize.getWidth()/2 + 250, (int) screenSize.getHeight()*4/8 + 25, 250, 50);
        tf4.setFont(new Font("Serif", Font.PLAIN, 25));
        tf5.setBounds((int)screenSize.getWidth()/2 + 250, (int) screenSize.getHeight()*5/8 + 25, 250, 50);
        tf5.setFont(new Font("Serif", Font.PLAIN, 25));
        tf6.setBounds((int)screenSize.getWidth()/2 + 250, (int) screenSize.getHeight()*6/8 + 25, 250, 50);
        tf6.setFont(new Font("Serif", Font.PLAIN, 25));
        add(tf1);
        add(tf2);
        add(tf3);
        add(tf4);
        add(tf5);
        add(tf6);
        //tf1.setVisible(true);
        add(instructions);
        add(district1);
        add(district2);
        add(district3);
        add(district4);
        add(district5);
        add(district6);
    }
}