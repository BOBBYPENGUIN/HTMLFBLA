import java.awt.Dimension;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.midi.MidiDevice.Info;
import javax.swing.*;

public class MainFrame extends JFrame{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private ButtonTest homepage;
    private QuizFramework question;
    private QuizFramework question2;
    private ImageTest iowaState;
    private NationalTest nationState;
    private BossFight iowaShowdown;
    private BossFightNation nationShowdown;
    private boolean initStatus[] = {false};
    private long questionDelay;
    private InfoPanel cashLabel;
    Random rand = new Random();
    int state = 0;
    int questionStatus = 0;
    int cash = 1000000;
    int difficulty;
    private MainPanel thePanel;
    private NationalPanel nationalPanel;
    class myListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(state == 0){
                if(homepage.getState() != 0){
                    difficulty = homepage.getState();
                    initWorld();
                }
            } else if(state == 1){
                if(System.currentTimeMillis()/1000 > questionDelay){
                    initQuestion();
                } if(thePanel.background.extras.get(0).x-screenSize.getWidth()/2 +16*5< Math.abs(thePanel.dx) && thePanel.background.extras.get(0).x-screenSize.getWidth()/2 +16*5+5*16*10> Math.abs(thePanel.dx)){
                    if(thePanel.background.extras.get(0).y-screenSize.getWidth()/2 +3*16*5< Math.abs(thePanel.dy) && thePanel.background.extras.get(0).y-screenSize.getWidth()/2 +2*16*5+5*16*10> Math.abs(thePanel.dy)){
                        initIowaMoney();
                    }
                } 
            } else if(state == 2){
                if(question.state != 1){
                    if(question.state == 2){
                        cash = (int) (cash + 1000 + Math.abs(thePanel.background.extras.get(0).x-screenSize.getWidth()/2 +16*5- Math.abs(nationalPanel.dx)));
                    }
                    repaint();
                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException b) {
                        b.printStackTrace();
                    }
                    state = 3;
                    drawCashLabel();

                }
            } else if(state == 3){
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException b) {
                    b.printStackTrace();
                }
                initWorld();
            } else if(state == 4){
                if(iowaState.state == -1){
                    initIowaShowdown();
                }
            } else if(state == 5){
                if(iowaShowdown.done){
                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException b) {
                        b.printStackTrace();
                    }
                    nationalPanel = new NationalPanel();
                    initNationalWorld();
                }
            } else if(state == 6){
                if(System.currentTimeMillis()/1000 > questionDelay){
                    initNationalQuestion();
                } if(nationalPanel.background.extras.get(0).x-screenSize.getWidth()/2 +16*5< Math.abs(nationalPanel.dx) && nationalPanel.background.extras.get(0).x-screenSize.getWidth()/2 +16*5+5*16*20> Math.abs(nationalPanel.dx)){
                    if(nationalPanel.background.extras.get(0).y-screenSize.getWidth()/2 +3*16*5< Math.abs(nationalPanel.dy) && nationalPanel.background.extras.get(0).y-screenSize.getWidth()/2 +5*16*20-16*10*2> Math.abs(nationalPanel.dy)){
                        initNationMoney();
                    }
                } 
            } else if(state == 7){
                if(question2.state != 1){
                    if(question2.state == 2){
                        cash = cash + 1000 + Math.abs(Math.abs(nationalPanel.dx)-Math.abs(600)) + Math.abs(Math.abs(nationalPanel.dy)-Math.abs(880));
                    }
                    repaint();
                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException b) {
                        b.printStackTrace();
                    }
                    state = 8;
                    drawCashLabel();
                }
            } else if(state == 8){
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException b) {
                    b.printStackTrace();
                }
                initNationalWorld();
            } else if(state == 9){
                if(nationState.state == -1){
                    initNationShowdown();
                }
            }
            repaint();
        }
        
    }
    public MainFrame(){
        homepage = new ButtonTest(0, "0");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        thePanel = new MainPanel();
        //setLayout(null);
        //add(thePanel);
        add(homepage);
        myListener listener = new myListener();
        Timer timer = new Timer(1, listener);
        timer.start();
    }
    public void initWorld(){
        state = 1;
        //removeAll();
        setContentPane(thePanel);
        revalidate();
        thePanel.addKeyListener();
        repaint();
        questionDelay = rand.nextInt(5)+ 5 + (long) System.currentTimeMillis()/1000;
        //thePanel.addKeyListener(thePanel.theKeyListener);
    }
    public void initQuestion(){
        state = 2;
        thePanel.keyIsPressed = false;
        for(var i = 0; i < thePanel.keyStatus.length; i++){
            thePanel.keyStatus[i] = false;
        }
        question = new QuizFramework();
        setContentPane(question);
        revalidate();
        repaint(); 
    }
    public void initNationalQuestion(){
        state = 7;
        nationalPanel.keyIsPressed = false;
        for(var i = 0; i < nationalPanel.keyStatus.length; i++){
            nationalPanel.keyStatus[i] = false;
        }
        question2 = new QuizFramework();
        setContentPane(question2);
        revalidate();
        repaint(); 
    }
    public void drawCashLabel(){
        cashLabel = new InfoPanel("You currently have: $" + Integer.toString(cash));
        setContentPane(cashLabel);
        revalidate();
        repaint(); 
    }
    public void initIowaMoney(){
        state = 4;
        iowaState = new ImageTest(cash);
        setContentPane(iowaState);
        revalidate();
        repaint(); 
    }
    public void initNationMoney(){
        state = 9;
        nationState = new NationalTest(cash);
        setContentPane(nationState);
        revalidate();
        repaint(); 
    }
    public void initIowaShowdown(){
        state = 5;
        iowaShowdown = new BossFight(difficulty, iowaState.getMoney());
        setContentPane(iowaShowdown);
        revalidate();
        repaint(); 
    }
    public void initNationalWorld(){
        state = 6;
        //removeAll();
        setContentPane(nationalPanel);
        revalidate();
        nationalPanel.addKeyListener();
        repaint();
        questionDelay = rand.nextInt(5)+ 5 + (long) System.currentTimeMillis()/1000;
        //thePanel.addKeyListener(thePanel.theKeyListener);
    }
    public void initNationShowdown(){
        state = 10;
        nationShowdown = new BossFightNation(difficulty, nationState.getMoney());
        setContentPane(nationShowdown);
        revalidate();
        repaint(); 
    }
}
