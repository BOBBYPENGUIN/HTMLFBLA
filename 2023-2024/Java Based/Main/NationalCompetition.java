import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class NationalCompetition extends JPanel{


    public int state = 0;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    BufferedImage national;
    int cash;
    int newCash;
    int difficulty;
    private int[] nationalMoney = new int[5];
    private JLabel instructions = new JLabel("Money Remaining: " + cash);
    private JLabel district1 = new JLabel("Eastern Region (Purple):");
    private JLabel district2 = new JLabel("Mountain Plains Region (Red):");
    private JLabel district3 = new JLabel("North Central Region (Blue):");
    private JLabel district4 = new JLabel("Southern Region (Green):");
    private JLabel district5 = new JLabel("Western Region (Orange):");
    private JTextField tf1 = new JTextField();
    private JTextField tf2 = new JTextField();
    private JTextField tf3 = new JTextField();
    private JTextField tf4 = new JTextField();
    private JTextField tf5 = new JTextField();
    private JButton submit = new JButton("Submit");
    private JLabel bossMoney = new JLabel("Competitor Money:");


    {
        try {
            national = ImageIO.read(new File("national.png"));
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
                    } else if((tf1.getText().equals("")||tf2.getText().equals("")||tf3.getText().equals("")||tf4.getText().equals("")||tf5.getText().equals(""))){
                        JOptionPane.showMessageDialog(new JFrame(),"One or more districts unanswered");
                    } else{
                        nationalMoney[0] = Integer.parseInt(tf1.getText());
                        nationalMoney[1] = Integer.parseInt(tf2.getText());
                        nationalMoney[2] = Integer.parseInt(tf3.getText());
                        nationalMoney[3] = Integer.parseInt(tf4.getText());
                        nationalMoney[4] = Integer.parseInt(tf5.getText());
                        //CHANGE STATE
                        state = -1;
                        drawResults();
                        repaint();
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
            instructions.setText("Money Remaining: " + newCash);
            repaint();
        }
    }
    buttonListener buttonL = new buttonListener();
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //iowa.
        int nationalX = (this.getWidth()/2 - national.getWidth(null)/2)/2;
        int nationalY = (this.getHeight() - national.getHeight(null)/2)/2;
        if(state == 0){
            g.drawImage(national, nationalX + 100, nationalY, (int)screenSize.getWidth()*3/7,(int)screenSize.getHeight()*3/7, this);
        }
    }
    JLabel nationalLabel = new JLabel(new ImageIcon("national.png"));


    public NationalCompetition(int cash, int difficulty){
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
    public void drawResults(){
        removeAll();
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
        tf1.setBounds((int)screenSize.getWidth()/2 + 325, (int) screenSize.getHeight()*1/8 + 25, 250, 50);
        tf1.setFont(new Font("Serif", Font.PLAIN, 25));
        tf2.setBounds((int)screenSize.getWidth()/2 + 325, (int) screenSize.getHeight()*2/8 + 25, 250, 50);
        tf2.setFont(new Font("Serif", Font.PLAIN, 25));
        tf3.setBounds((int)screenSize.getWidth()/2 + 325, (int) screenSize.getHeight()*3/8 + 25, 250, 50);
        tf3.setFont(new Font("Serif", Font.PLAIN, 25));
        tf4.setBounds((int)screenSize.getWidth()/2 + 325, (int) screenSize.getHeight()*4/8 + 25, 250, 50);
        tf4.setFont(new Font("Serif", Font.PLAIN, 25));
        tf5.setBounds((int)screenSize.getWidth()/2 + 325, (int) screenSize.getHeight()*5/8 + 25, 250, 50);
        tf5.setFont(new Font("Serif", Font.PLAIN, 25));
        submit.setBounds((int)screenSize.getWidth()/2 + 400, 25, 150, 50);
        submit.addActionListener(buttonL);
        bossMoney.setBounds(50,0,1000,100);
        if(difficulty == 1){
            bossMoney.setText("Competitor Money: " + 10000);
        }else if(difficulty == 2){
            bossMoney.setText("Competitor Money: " + 20000);
        }else if(difficulty == 3){
            bossMoney.setText("Competitor Money: " + 30000);
        }
        bossMoney.setFont(new Font("Serif", Font.PLAIN, 25));
        add(submit);
        add(tf1);
        add(tf2);
        add(tf3);
        add(tf4);
        add(tf5);
        //tf1.setVisible(true);
        add(instructions);
        add(district1);
        add(district2);
        add(district3);
        add(district4);
        add(district5);
    }
    public int[] getMoney(){
        return nationalMoney;
    }
}