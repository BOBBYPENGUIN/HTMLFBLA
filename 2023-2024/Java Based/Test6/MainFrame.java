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
    private boolean initStatus[] = {false};
    private long questionDelay;
    private InfoPanel cashLabel;
    Random rand = new Random();
    int state = 0;
    int questionStatus = 0;
    int cash = 0;
    private MainPanel thePanel;
    class myListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(state == 0){
                if(homepage.getState() != 0){
                    initWorld();
                }
            } else if(state == 1){
                if(System.currentTimeMillis()/1000 > questionDelay){
                    System.out.println(thePanel.dx);
                    System.out.println(thePanel.background.extras.get(0).x);
                    System.out.println(thePanel.background.extras.get(3).y);
                    System.out.println(thePanel.dy);
                    initQuestion();
                } if(thePanel.background.extras.get(0).x-screenSize.getWidth()/2 +16*5< Math.abs(thePanel.dx) && thePanel.background.extras.get(0).x-screenSize.getWidth()/2 +16*5+5*16*10> Math.abs(thePanel.dx)){
                    if(thePanel.background.extras.get(0).y-screenSize.getWidth()/2 +3*16*5< Math.abs(thePanel.dy) && thePanel.background.extras.get(0).y-screenSize.getWidth()/2 +2*16*5+5*16*10> Math.abs(thePanel.dy)){
                        System.out.println("Transition");
                    }
                } 
            } else if(state == 2){
                if(question.state != 1){
                    if(question.state == 2){
                        cash = cash + 1000 + Math.abs(Math.abs(thePanel.dx)-Math.abs(600)) + Math.abs(Math.abs(thePanel.dy)-Math.abs(880));
                    }
                    repaint();
                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException b) {
                        // TODO Auto-generated catch block
                        b.printStackTrace();
                    }
                    state = 3;
                    drawCashLabel();

                }
            } else if(state == 3){
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException b) {
                    // TODO Auto-generated catch block
                    b.printStackTrace();
                }
                initWorld();
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
    public void drawCashLabel(){
        cashLabel = new InfoPanel("You currently have: $" + Integer.toString(cash));
        setContentPane(cashLabel);
        revalidate();
        repaint(); 
    }
}
