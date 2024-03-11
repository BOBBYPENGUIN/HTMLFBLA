import javax.swing.*;
import java.util.*;
public class Background extends JComponent{
    private ArrayList<ArrayList<Assets>> background = new ArrayList<>();
    public void createBackground(){
        for(var i = 0; i < 20; i++){
            ArrayList<Assets> tempList = new ArrayList<>();
            for(var j = 0; j < 20; j++){
                tempList.add(new Assets(i*16*5, j*16*5, 5, 1));
            }
            background.add(tempList);
        }
    }
}
