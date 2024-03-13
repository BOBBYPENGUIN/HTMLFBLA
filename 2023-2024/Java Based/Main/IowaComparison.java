import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
/**
 * Creates a framework for creating and displaying your comparison with your opponent
 */
class IowaComparison extends JPanel{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    String text;
    boolean done = false;
    int difficulty;
    private JLabel resultBoss;
    private JLabel resultPlayer;
    private JLabel finalResult;
    int cash;
    int wonDistricts;
    int[] playerCash;
    public IowaComparison(int difficulty, int[] playerCash){
        this.playerCash = playerCash;
        removeAll();
        if(difficulty == 1){
            cash = 10000;
        } else if(difficulty == 2){
            cash = 20000;
        } else {
            cash = 30000;
        }
        ArrayList<Integer> values = new ArrayList<>();
        Random rand = new Random();
        values.add(0);
        for(int i = 0; i < 5; i++){
            values.add(rand.nextInt(cash + 1));
        }
        values.add(cash);
        ArrayList<Integer> cashVals = new ArrayList<>();
        Collections.sort(values);
        for(var i = 0; i < 6; i++){
            cashVals.add(values.get(i+1) - values.get(i));
        }
        Collections.shuffle(cashVals);
        resultBoss = new JLabel(String.format("Competitor distributions: %12d%12d%12d%12d%12d%12d", cashVals.toArray()), SwingConstants.CENTER);
        resultPlayer = new JLabel(String.format("    Player distributions: %12d%12d%12d%12d%12d%12d", playerCash[0], playerCash[1], playerCash[2], playerCash[3], playerCash[4], playerCash[5]),SwingConstants.CENTER);
        setLayout(null);
        setSize(screenSize);
        resultBoss.setBounds((int) screenSize.getWidth()/80, (int) screenSize.getHeight ()/10, (int) screenSize.getWidth()*39/40, (int) screenSize.getHeight()/5);
        resultBoss.setFont(new Font("Courier New", Font.PLAIN, 20));
        resultPlayer.setBounds((int) screenSize.getWidth()/80, (int) screenSize.getHeight ()/5, (int) screenSize.getWidth()*39/40, (int) screenSize.getHeight()/5);
        resultPlayer.setFont(new Font("Courier New", Font.PLAIN, 20));
        add(resultBoss);
        add(resultPlayer);
        wonDistricts = 0;
        for(var i = 0; i < 6; i++){
            if(cashVals.get(i) < playerCash[i]){
                wonDistricts += 1;
            }
        }
        if(wonDistricts >= 3){
            finalResult = new JLabel("You have won more than three districts, and\n have gained enough influence to compete at the national level!", SwingConstants.CENTER);
            finalResult.setBounds((int) screenSize.getWidth()/80, (int) screenSize.getHeight ()*4/10, (int) screenSize.getWidth()*39/40, (int) screenSize.getHeight()/5);
            finalResult.setFont(new Font("Courier New", Font.PLAIN, 15));
            done = true;
        } else {
            finalResult = new JLabel("You failed to garner the necessary support,and FBLA fell before it began. Try again!", SwingConstants.CENTER);
            finalResult.setBounds((int) screenSize.getWidth()/80, (int) screenSize.getHeight ()*4/10, (int) screenSize.getWidth()*39/40, (int) screenSize.getHeight()/5);
            finalResult.setFont(new Font("Courier New", Font.PLAIN, 15));
        }
        add(finalResult);

    }
    public int getDistricts(){
        return wonDistricts;
    }

}