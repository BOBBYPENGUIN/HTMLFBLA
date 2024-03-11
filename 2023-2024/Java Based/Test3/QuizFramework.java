import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

class QuizFramework extends JFrame{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int state = 1;
    int type;
    String text;
    class myListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            drawQuestion();
        }
        
    }
    ArrayList<String> questions = new ArrayList<>();
    ArrayList<ArrayList<String>> answers = new ArrayList<ArrayList<String>>();
    ArrayList<Integer> realAnswers = new ArrayList<>();
    private JPanel panel = new JPanel();
    private int questionNum = getRandomQuestion();
    private JButton button1 = new JButton(answers.get(questionNum).get(0));
    private JButton button2 = new JButton(answers.get(questionNum).get(1));
    private JButton button3 = new JButton(answers.get(questionNum).get(2));
    private JButton button4 = new JButton(answers.get(questionNum).get(3));
    private JLabel question = new JLabel(questions.get(questionNum));
    myListener listen = new myListener();
    public QuizFramework(int type, String text){
        this.type = type;
        this.text = text;
        panel.setLayout(null);
        drawQuestion();
        add(panel);
        setSize(screenSize);
    }
    public void drawQuestion(){

    }
    public void addQuestion(String question, ArrayList<String> answers, int realAnswer){
        questions.add(question);
        this.answers.add(answers);
        this.realAnswers.add(realAnswer);
    }
    public void addQuestion(String question, String a1, String a2, String a3, String a4, int realAnswer){
        questions.add(question);
        ArrayList<String> tempAns = new ArrayList<>();
        tempAns.add(a1);
        tempAns.add(a2);
        tempAns.add(a3);
        tempAns.add(a4);
        this.answers.add(tempAns);
        this.realAnswers.add(realAnswer);
    }
    public void addQuestions(){
        addQuestion("When was FBLA founded?", "2020", "1999", "1956", "1937", 4);
    }
    public int getRandomQuestion(){
        Random rand = new Random();
        return rand.nextInt(questions.size());
    }

}