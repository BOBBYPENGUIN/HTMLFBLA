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
    private int questionNum;
    class myListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String questionSelected  = e.getActionCommand();
            if(questionSelected.equals(answers.get(questionNum).get(realAnswers.get(questionNum)))){
                System.out.println("Correct");
            }
        }
        
    }
    ArrayList<String> questions = new ArrayList<>();
    ArrayList<ArrayList<String>> answers = new ArrayList<ArrayList<String>>();
    ArrayList<Integer> realAnswers = new ArrayList<>();
    private JPanel panel = new JPanel();
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel question;
    myListener listen = new myListener();
    public QuizFramework(int type, String text){
        addQuestions();
        questionNum = getRandomQuestion();
        button1 = new JButton(answers.get(questionNum).get(0));
        button2 = new JButton(answers.get(questionNum).get(1));
        button3 = new JButton(answers.get(questionNum).get(2));
        button4 = new JButton(answers.get(questionNum).get(3));
        question = new JLabel(questions.get(questionNum), SwingConstants.CENTER);
        this.type = type;
        this.text = text;
        panel.setLayout(null);
        drawQuestion();
        add(panel);
        setSize(screenSize);
    }
    public void drawQuestion(){
        question.setBounds((int) screenSize.getWidth()/5, (int) screenSize.getHeight ()/10, (int) screenSize.getWidth()*3/5, (int) screenSize.getHeight()/5);
        question.setFont(new Font("Serif", Font.PLAIN, 50));
        panel.add(question);
        button1.setBounds((int) screenSize.getWidth()/10, (int) screenSize.getHeight ()/3, (int) screenSize.getWidth()*3/10, (int) screenSize.getHeight()/5);
        button1.addActionListener(listen);
        panel.add(button1);
        button2.setBounds((int) screenSize.getWidth()*6/10, (int) screenSize.getHeight ()/3, (int) screenSize.getWidth()*3/10, (int) screenSize.getHeight()/5);
        button2.addActionListener(listen);
        panel.add(button2);
        button3.setBounds((int) screenSize.getWidth()/10, (int) (screenSize.getHeight()*2/3), (int) screenSize.getWidth()*3/10, (int) screenSize.getHeight()/5);
        button3.addActionListener(listen);
        panel.add(button3);
        button4.setBounds((int) screenSize.getWidth()*6/10, (int) (screenSize.getHeight ()*2/3), (int) screenSize.getWidth()*3/10, (int) screenSize.getHeight()/5);
        button4.addActionListener(listen);
        panel.add(button4);
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
        addQuestion("When was FBLA founded?", "2020", "1999", "1956", "1937", 3);
        addQuestion("Which one of the following statements is part of the FBLA Code of Ethics?", "I will facilitate the transition from school to work.", "I will assist students in the establishment of occupational goals.", "I will promote business education to every person.", "I will willingly accept responsibilities and duties.",3);
        addQuestion("Which one of the following statements is part of the FBLA Code of Ethics?", "I will abide by the rules and regulations of my school.", "I will practice efficient money management.", "I will create more interest in and understanding of American business enterprise.", "I will facilitate the transition from school to work.",0);
        addQuestion("One of the FBLA goals is to:", "develop the qualities necessary in becoming a responsible business leader", " create more interest in and understanding of American business enterprise", "cooperate with my employer and fellow workers", "facilitate the transition from school to post secondary education",1);
    }
    public int getRandomQuestion(){
        Random rand = new Random();
        return rand.nextInt(questions.size());
    }

}