import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

class QuizFramework extends JPanel{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int state = 1;
    String text;
    private int questionNum;
    class myListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String questionSelected  = e.getActionCommand();
            if(questionSelected.equals(answers.get(questionNum).get(realAnswers.get(questionNum)))){
                state = 2;
            } else {
                state = 3;
            }
            drawAnswer();
        }
        
    }
    ArrayList<String> questions = new ArrayList<>();
    ArrayList<ArrayList<String>> answers = new ArrayList<ArrayList<String>>();
    ArrayList<Integer> realAnswers = new ArrayList<>();
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel question;
    private JLabel result;
    myListener listen = new myListener();
    public QuizFramework(){
        addQuestions();
        questionNum = getRandomQuestion();
        button1 = new JButton(answers.get(questionNum).get(0));
        button2 = new JButton(answers.get(questionNum).get(1));
        button3 = new JButton(answers.get(questionNum).get(2));
        button4 = new JButton(answers.get(questionNum).get(3));
        question = new JLabel(questions.get(questionNum), SwingConstants.CENTER);
        result = new JLabel("Correct!", SwingConstants.CENTER);
        setLayout(null);
        drawQuestion();
        setSize(screenSize);
    }
    public void drawQuestion(){
        removeAll();
        state = 1;
        question.setBounds((int) screenSize.getWidth()/5, (int) screenSize.getHeight ()/10, (int) screenSize.getWidth()*3/5, (int) screenSize.getHeight()/5);
        question.setFont(new Font("Serif", Font.PLAIN, 20));
        add(question);
        button1.setBounds((int) screenSize.getWidth()/10, (int) screenSize.getHeight ()/3, (int) screenSize.getWidth()*3/10, (int) screenSize.getHeight()/5);
        button1.addActionListener(listen);
        add(button1);
        button2.setBounds((int) screenSize.getWidth()*6/10, (int) screenSize.getHeight ()/3, (int) screenSize.getWidth()*3/10, (int) screenSize.getHeight()/5);
        button2.addActionListener(listen);
        add(button2);
        button3.setBounds((int) screenSize.getWidth()/10, (int) (screenSize.getHeight()*2/3), (int) screenSize.getWidth()*3/10, (int) screenSize.getHeight()/5);
        button3.addActionListener(listen);
        add(button3);
        button4.setBounds((int) screenSize.getWidth()*6/10, (int) (screenSize.getHeight ()*2/3), (int) screenSize.getWidth()*3/10, (int) screenSize.getHeight()/5);
        button4.addActionListener(listen);
        add(button4);
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
    public void addQuestions() {
        addQuestion("When was FBLA founded?", "2020", "1999", "1956", "1937", 3);
        addQuestion("Which one of the following statements is part of the FBLA Code of Ethics?", "I will facilitate the transition from school to work.", "I will assist students in the establishment of occupational goals.", "I will promote business education to every person.", "I will willingly accept responsibilities and duties.", 3);
        addQuestion("Which one of the following statements is part of the FBLA Code of Ethics?", "I will abide by the rules and regulations of my school.", "I will practice efficient money management.", "I will create more interest in and understanding of American business enterprise.", "I will facilitate the transition from school to work.", 0);
        addQuestion("One of the FBLA goals is to:", "develop the qualities necessary in becoming a responsible business leader", " create more interest in and understanding of American business enterprise", "cooperate with my employer and fellow workers", "facilitate the transition from school to post secondary education", 1);
        addQuestion("Which event can be taken by 11th and 12th grade FBLA members?", "Introduction to Business", "Business Calculations", "Introduction to Financial Math", "Introduction to Business Presentation", 1);
        addQuestion("If your local FBLA chapter has over 100 members, how many voting delegates is it given at the FBLA National Leadership Conference?", "5", "8", "10", "4", 3);
        addQuestion("In February of 1942, the first high school chapter of FBLA was chartered in:", "Dubuque, IA", "New York City, NY", "Kansas City, MO", "Johnson City, TN", 3);
        addQuestion("The FBLA goal is to strengthen the confidence of students in themselves and their:", "work", "school", "leadership", "careers", 0);
        addQuestion("According to FBLA Creed, education is the right of:", "every FBLA member and adviser", "every person", "every FBLA member", "every student", 1);
        addQuestion("Which one of the following is included in the FBLA code of conduct?", "avoid conduct conductive to an educational conference", "observe most of the curfews", "obey all local and federal laws", "behave in a courteous and respectful matter", 3);
        addQuestion("Which of the following is a stanza of the FBLA Creed?", "I will do my best to uphold the aims and responsibilities of Future Business Leaders of America", "I believe education is the right of every person", "I promise to bring business and education together in a positive working relationship", "I shall strive to develop the qualities necessary in becoming a responsible business leader", 1);
        addQuestion("Which one of the following is not a goal of FBLA-PBL?", "Facilitate the transition from school to work", "Create more interest in and understanding of the American business enterprise", "Encourage and practice efficient money management", "Encourage the development of proper time management skills", 3);
        addQuestion("Which of the following is not included in the goals of FBLA-PBL?", "Develop strong business ethics", "Promote school loyalty", "Foster patriotism", "Develop competent business leadership", 0);
        addQuestion("Which state was the first FBLA state chapter?", "North Carolina",  "Virginia", "Arkansas", "Iowa",3);
        addQuestion("The FBLA-Middle Level Division was formed in what year?", "1989", "1992", "1994", "1998",2);
        addQuestion("The name Future Business Leaders of America was selected in what year?", "1937", "1942", "1940", "1946",2)  ;
    }
    public int getRandomQuestion(){
        Random rand = new Random();
        return rand.nextInt(questions.size());
    }
    public void drawAnswer(){
        removeAll();
        result.setBounds((int) screenSize.getWidth()/5, (int) screenSize.getHeight ()/10, (int) screenSize.getWidth()*3/5, (int) screenSize.getHeight()/5);
        result.setFont(new Font("Serif", Font.PLAIN, 50));
        if(state == 2){
            result.setText("Correct!");
        } else {
            result.setText("Incorrect. The answer is " + answers.get(questionNum).get(realAnswers.get(questionNum)));
        }
        //System.out.println(result.getText());
        add(result);
        repaint();
    }

}