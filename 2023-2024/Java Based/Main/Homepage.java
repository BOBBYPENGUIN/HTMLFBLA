import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * Creates and allows interaction of the homepage
 */
class Homepage extends JPanel{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int type;
    String text;
    public int state = 0;
    class myListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof JButton){
                String butSrcTxt = e.getActionCommand();
                if(butSrcTxt.equals("Instructions")){
                    drawInstructions();
                    repaint();
                } else if(butSrcTxt.equals("About")){
                    drawAbout();
                    repaint();
                } else if(butSrcTxt.equals("Leaderboard")){
                    drawLeaderboard();
                    repaint();
                } else if(butSrcTxt.equals("Back")){
                    drawMainScene();
                    repaint();
                } else if(butSrcTxt.equals("Easy")){
                    state = 1;
                }else if(butSrcTxt.equals("Medium")){
                    state = 2;
                }else if(butSrcTxt.equals("Hard")){
                    state = 3;
                }
            }
        }
        
    }
    private JButton buttonEasy = new JButton("Easy");
    private JButton buttonMedium = new JButton("Medium");
    private JButton buttonHard = new JButton("Hard");
    private JButton buttonAbout = new JButton("About");
    private JButton buttonInstructions = new JButton("Instructions");
    private JButton buttonLeaderboard = new JButton("Leaderboard");
    private JButton button2 = new JButton("Enter Game");
    private JButton backButton = new JButton("Back");
    private JLabel title = new JLabel("Journey", SwingConstants.CENTER);
    private JTextArea directions = new JTextArea("Lorem ipsum");
    myListener listen = new myListener();
    public Homepage(int type, String text){
        this.type = type;
        this.text = text;
        setLayout(null);
        drawMainScene();
        setSize(screenSize);
    }
    public void drawMainScene(){
        state = 0;
        removeAll();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        title.setText("Journey");
        buttonEasy.setBounds((int) width / 6, (int) height * 3 / 9, (int) width / 6,  (int) height / 9);
        buttonEasy.addActionListener(listen);
        buttonMedium.setBounds((int) (width* 2.5 / 6), (int) height * 3 / 9, (int) width / 6,  (int) height / 9);
        buttonMedium.addActionListener(listen);
        buttonHard.setBounds((int) (width* 4 / 6), (int) height * 3 / 9, (int) width / 6,  (int) height / 9);
        buttonHard.addActionListener(listen);
        buttonAbout.setBounds((int) width / 6, (int) height * 5 / 9, (int) width / 6,  (int) height / 9);
        buttonAbout.addActionListener(listen);
        buttonInstructions.setBounds((int) (width* 2.5 / 6), (int) height * 5 / 9, (int) width / 6,  (int) height / 9);
        buttonInstructions.addActionListener(listen);
        buttonLeaderboard.setBounds((int) (width* 4 / 6), (int) height * 5 / 9, (int) width / 6,  (int) height / 9);
        buttonLeaderboard.addActionListener(listen);
        title.setBounds(0, 0, (int) screenSize.getWidth(), (int)  screenSize.getHeight()/3);
        title.setFont(new Font("Serif", Font.PLAIN, 50));
        button2.setBounds(550, 500, 500, 500);
        add(buttonEasy); 
        add(buttonMedium);
        add(buttonHard);
        add(buttonAbout); 
        add(buttonInstructions);
        add(buttonLeaderboard);
        add(title);
    }
    public void drawInstructions(){
        removeAll();
        backButton.setBounds((int)(screenSize.getWidth()*4/5), (int)(screenSize.getHeight()*7/10), (int)(screenSize.getWidth()*3/20), (int)(screenSize.getWidth()*2/20));
        backButton.addActionListener(listen);
        directions.setBounds(100, (int) screenSize.getHeight()/3, 1000, 300);
        directions.setText("Welcome, Player. Your dream of creating a coalition of business competitions is coming to fruition, but faces harsh opposition from your competitors. Your first goal is to unite Iowa. Wander around, answer questions, and when ready, enter the building. Answering questions further away from the convention center gives more money. There, you decide how to invest your money among Iowa's districts to win at least three of them. Should you unite Iowa, your next step is our country. Good luck.\nNote that the difficulty decides how much money your competitor has. On easy, they have $5000, but on hard, they have $15000. Manage your time carefully. Your final score is determined by the amount of time it took to beat the game, modified by your difficulty level");
        directions.setWrapStyleWord(true);
        directions.setLineWrap(true);
        directions.setFont(new Font("Serif", Font.PLAIN, 25));
        title.setText("Instructions");
        add(backButton);
        add(directions);
        add(title);
    }
    public void drawAbout(){
        removeAll();
        backButton.setBounds((int)(screenSize.getWidth()*4/5), (int)(screenSize.getHeight()*7/10), (int)(screenSize.getWidth()*3/20), (int)(screenSize.getWidth()*2/20));
        backButton.addActionListener(listen);
        directions.setBounds(100, (int) screenSize.getHeight()/3, 1000, 100);
        directions.setText("Created by Alex Liu and Brian Wei");
        directions.setFont(new Font("Serif", Font.PLAIN, 25));
        title.setText("About");
        add(backButton);
        add(directions);
        add(title);
    }
    public void drawLeaderboard(){
        removeAll();
        backButton.setBounds((int)(screenSize.getWidth()*4/5), (int)(screenSize.getHeight()*7/10), (int)(screenSize.getWidth()*3/20), (int)(screenSize.getWidth()*2/20));
        backButton.addActionListener(listen);
        directions.setBounds(100, (int) screenSize.getHeight()/3, 1000, 100);
        directions.setText("1. 13 Minutes, 45 Seconds");
        directions.setFont(new Font("Serif", Font.PLAIN, 25));
        title.setText("Leaderboard");
        add(backButton);
        add(directions);
        add(title);
    }
    public int getState(){
        return state;
    }
}