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

    public int state = 0;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    BufferedImage iowa;
    BufferedImage national;
    int cash;
    int newCash;
    int difficulty;

    private int[] iowaMoney = new int[6];
    private JLabel instructions = new JLabel("Money Remaining: " + cash);
    private JLabel district1 = new JLabel("District 1:");
    private JLabel district2 = new JLabel("District 2:");
    private JLabel district3 = new JLabel("District 3:");
    private JLabel district4 = new JLabel("District 4:");
    private JLabel district5 = new JLabel("District 5:");
    private JLabel district6 = new JLabel("District 6:");
    private JLabel bossMoney = new JLabel("Competitor Money:");
    private JTextField tf1 = new JTextField();
    private JTextField tf2 = new JTextField();
    private JTextField tf3 = new JTextField();
    private JTextField tf4 = new JTextField();
    private JTextField tf5 = new JTextField();
    private JTextField tf6 = new JTextField();
    private JButton submit = new JButton("Submit");

    {
        try {
            iowa = ImageIO.read(new File("Iowa.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    class buttonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                String butSrcTxt = e.getActionCommand();
                if (butSrcTxt.equals("Submit")) {
                    if(newCash < 0){
                        JOptionPane.showMessageDialog(new JFrame(),"Negative money remaining");
                    } else if((tf1.getText().equals("")||tf2.getText().equals("")||tf3.getText().equals("")||tf4.getText().equals("")||tf5.getText().equals("")||tf6.getText().equals(""))){
                        JOptionPane.showMessageDialog(new JFrame(),"One or more districts unanswered");
                    } else{
                        iowaMoney[0] = Integer.parseInt(tf1.getText());
                        iowaMoney[1] = Integer.parseInt(tf2.getText());
                        iowaMoney[2] = Integer.parseInt(tf3.getText());
                        iowaMoney[3] = Integer.parseInt(tf4.getText());
                        iowaMoney[4] = Integer.parseInt(tf5.getText());
                        iowaMoney[5] = Integer.parseInt(tf6.getText());
                        //CHANGE STATE
                        state = -1;
                    }
                }
            }
        }
    }
    class TimerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            newCash = cash;
            if(!tf1.getText().equals("")){
                newCash -= Integer.parseInt(tf1.getText());
            }
            if(!tf2.getText().equals("")){
                newCash -= Integer.parseInt(tf2.getText());
            }
            if(!tf3.getText().equals("")){
                newCash -= Integer.parseInt(tf3.getText());
            }
            if(!tf4.getText().equals("")){
                newCash -= Integer.parseInt(tf4.getText());
            }
            if(!tf5.getText().equals("")){
                newCash -= Integer.parseInt(tf5.getText());
            }
            if(!tf6.getText().equals("")){
                newCash -= Integer.parseInt(tf6.getText());
            }

            instructions.setText("Money Remaining: " + newCash);
            repaint();
        }

    }
    buttonListener buttonL = new buttonListener();
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


    public ImageTest(int cash, int difficulty){
        this.cash = cash;
        this.difficulty = difficulty;
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
        bossMoney.setBounds(0,0,1000,100);
        if(difficulty == 1){
            bossMoney.setText("Competitor Money: " + 10000);
        }else if(difficulty == 2){
            bossMoney.setText("Competitor Money: " + 20000);
        }else if(difficulty == 3){
            bossMoney.setText("Competitor Money: " + 300000);
        }
        bossMoney.setFont(new Font("Serif", Font.PLAIN, 25));
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
        submit.setBounds((int)screenSize.getWidth()/2 + 400, 25, 150, 50);
        submit.addActionListener(buttonL);
        add(bossMoney);
        add(submit);
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
    public int[] getMoney(){
        return iowaMoney;
    }
}