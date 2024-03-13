import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

class BossFight extends JPanel{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    String text;
    int difficulty;
    private JLabel result;
    int cash;
    public BossFight(int difficulty){
        removeAll();
        if(difficulty == 1){
            cash = 5000;
        } else if(difficulty == 2){
            cash = 10000;
        } else {
            cash = 15000;
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

    }

}