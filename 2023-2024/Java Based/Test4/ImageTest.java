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

    private int state = 0;

    private JTextField textField = new JTextField();

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    BufferedImage iowa;
    BufferedImage national;
    myListener listen = new myListener();

    private int[] iowaMoney = new int[6];
    private int[] nationalMoney = new int[5];
    private JLabel instructions = new JLabel("Enter money in districts: ");
    private JLabel money = null;
    private JLabel district1 = new JLabel("District 1:");
    private JLabel district2 = new JLabel("District 2:");
    private JLabel district3 = new JLabel("District 3:");
    private JLabel district4 = new JLabel("District 4:");
    private JLabel district5 = new JLabel("District 5:");
    private JLabel district6 = new JLabel("District 6:");

    {
        try {
            iowa = ImageIO.read(new File("Iowa.png"));
            national = ImageIO.read(new File("national.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
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
        textField.setBounds((int)screenSize.getWidth()/2,(int)screenSize.getHeight()/2,(int)screenSize.getWidth()/6, (int)screenSize.getHeight()/10);
        setLayout(null);
        if(state == 0){
            drawIowa();
        }
        else if(state == 1){
            //drawNational();
        }
        setSize(screenSize);
    }
    class myListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                String butSrcTxt = e.getActionCommand();
                if (butSrcTxt.equals("Submit")) {
                    //drawResults();
                    repaint();
                }
            }
        }
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
        add(instructions);
        add(district1);
        add(district2);
        add(district3);
        add(district4);
        add(district5);
        add(district6);
    }
}
