import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 * Started by Cameron on March 23rd
 * Edited by Cameron on April 1st, April 3rd, April 16th - 19th 
 * have the alphabet lesson be the free trail
 * has a serious logical error when submiting the answers trying to fix it
 */
public class numberQuiz{
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String value;
    private Timer timer;
    private long startTime = -1;
    private long duration = -1;
    private JFrame frame = new JFrame("Numbers Quiz");
    private JPanel panel = new JPanel();
    //html and br tags put the second part of the message on a new line
    private JLabel message = new JLabel("<html><center>Answer the questions for each image.</center>" + 
        "<br/><center>You have 1 minute to complete the quiz.</center>" + "<br/>Click 'Finish' once your answers are inputted.</html>");
    private JLabel questionOne = new JLabel("What number is this?");
    private JLabel questionTwo = new JLabel("This means '5'. True or False?");
    private JLabel questionThree = new JLabel("What number is being signed?");
    private JLabel questionFour = new JLabel("This means '7'. True or False?");
    private JLabel questionFive = new JLabel("Solve the following problem: __ + 10 = 15");
    private JRadioButton five = new JRadioButton("5");
    private JRadioButton ten = new JRadioButton("10");
    private JRadioButton hello = new JRadioButton("Hello");
    private JRadioButton eight = new JRadioButton("8");
    private JRadioButton one = new JRadioButton("1");
    private JRadioButton zero = new JRadioButton("0");
    private JRadioButton six = new JRadioButton("6");
    private JRadioButton two = new JRadioButton("2");
    private JRadioButton firstTrue, firstFalse, secondTrue, secondFalse;
    private JButton submitButton = new JButton("<html><font size='5'>Submit</font></html>");
    private JButton checkQuestionOneBtn = new JButton("Submit and Check");
    private JButton checkQuestionTwoBtn = new JButton("Submit and Check");
    private JButton checkQuestionThreeBtn = new JButton("Check");
    private JButton checkQuestionFourBtn = new JButton("Check");
    private JButton checkQuestionFiveBtn = new JButton("Check");
    private JButton quitButton = new JButton("Quit");
    public numberQuiz(){
        frame();
        //int delay = 10000; //30000 milliseconds = 30 seconds
        timer = new Timer(60000, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //code to automatically end quiz goes here
                JOptionPane.showMessageDialog(null, "You have run out of time! Answers being submitted.");
                if (startTime < 0) {
                      startTime = System.currentTimeMillis();
                }
                long now = System.currentTimeMillis();
                long clockTime = now - startTime;
                if (clockTime >= duration) {
                      //clockTime = duration;
                      timer.stop();
                }
                submitButton.doClick();
                //add the check buttons here
            }
        });
        timer.start();
        //closes the database connection then disposes the frame and opens the quiz class
        quitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                try{
                    conn.close();
                    frame.dispose();
                    new Quiz();
                }catch(Exception e){ 
                }
            }
        });
        //action listeners for choices for questions 1-4
        five.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "5";
            }
        });
        
        ten.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "10";
            }
        });
        
        hello.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "Hello";
            }
        });
        
        eight.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "8";
            }
        });
        
        one.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "1";
            }
        });
        
        zero.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "0";
            }
        });
        
        six.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "6";
            }
        });
        
        two.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "2";
            }
        });
        
        firstTrue.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "True";
            }
        });
        
        firstFalse.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "False";
            }
        });
        
        secondTrue.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "True";
            }
        });
        
        secondFalse.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "False";
            }
        });
        //when clicked, submits the answers to database
        submitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                submitAnswer();
            }
        });
        //action listeners that when clicked, 
        checkQuestionOneBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                checkAnswer();
            }
        });
        
        checkQuestionTwoBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                checkAnswer();
            }
        });
        
        checkQuestionThreeBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                checkAnswer();
            }
        });
        
        checkQuestionFourBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                checkAnswer();
            }
        });
        
        checkQuestionFiveBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                checkAnswer();
            }
        });
    }
    
    public void frame(){
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        
        panel.add(message, gbc);
        //Question One
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberTen.gif")), gbc);
        panel.add(questionOne, gbc);
        panel.add(five, gbc);
        panel.add(ten, gbc);
        panel.add(hello, gbc);
        panel.add(eight, gbc);
        panel.add(checkQuestionOneBtn, gbc);
        //Question Two
        firstTrue = new JRadioButton("True");
        firstFalse = new JRadioButton("False");
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/moreSign.png")), gbc);
        panel.add(questionTwo, gbc);
        panel.add(firstTrue, gbc);
        panel.add(firstFalse, gbc);
        panel.add(checkQuestionTwoBtn, gbc);
        //Question Three
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberOne.jpg")), gbc);
        panel.add(questionThree, gbc);
        panel.add(one, gbc);
        panel.add(zero, gbc);
        panel.add(six, gbc);
        panel.add(two, gbc);
        panel.add(checkQuestionThreeBtn, gbc);
        //Question Four
        secondTrue = new JRadioButton("True");
        secondFalse = new JRadioButton("False");
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberSeven.jpg")), gbc);
        panel.add(questionFour, gbc);
        panel.add(secondTrue, gbc);
        panel.add(secondFalse, gbc);
        panel.add(checkQuestionFourBtn, gbc);
        //Question Five
        GridBagConstraints firstNewGBC = new GridBagConstraints();
        firstNewGBC.gridwidth = GridBagConstraints.HORIZONTAL;
        firstNewGBC.gridx = 0;
        JButton optionA = new JButton("A.", new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberSix.jpg"));
        JButton optionC = new JButton("C.", new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberFive.jpg"));
        JButton optionB = new JButton("B.", new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberThree.jpg"));
        JButton optionD = new JButton("D.", new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberTwo.jpg"));
        //aligns the text in the button to the left of the icon
        optionA.setHorizontalTextPosition(SwingConstants.LEFT);
        optionC.setHorizontalTextPosition(SwingConstants.LEFT);
        optionB.setHorizontalTextPosition(SwingConstants.LEFT);
        optionD.setHorizontalTextPosition(SwingConstants.LEFT);
        panel.add(questionFive, gbc);
        panel.add(optionA, firstNewGBC);
        panel.add(optionC, firstNewGBC);
        panel.add(optionB, gbc);
        panel.add(optionD, gbc);
        panel.add(checkQuestionFiveBtn, gbc);
        
        //action listeners for the fifth question
        optionA.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "A";
            }
        });
        
        optionC.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "C";
            }
        });
        
        optionB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "B";
            }
        });
        
        optionD.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "D";
            }
        });
        
        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.add(submitButton, gbc);
        buttons.add(quitButton, gbc);

        gbc.weighty = 1;
        panel.add(buttons, gbc);
        
        JScrollPane scrPanel = new JScrollPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(scrPanel);
        frame.pack();
        frame.setVisible(true);
    }
    
    public void submitAnswer(){
        try{ 
            Class.forName("com.mysql.cj.jdbc.Driver");
            String submitQuery = "INSERT INTO submittedanswers(submitAnswer) VALUES (?)";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/asl", "root", "");
            stmt = conn.prepareStatement(submitQuery);
            stmt.setString(1, value);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Your answer has been submitted!");
            String extractQuery = "Select submittedanswers.submitAnswer, answers.correctAnswer From answers " +
                "Inner Join (Select submitAnswer From submittedanswers Order By tableID DESC limit 1) As submittedanswers "+
                "On submittedanswers.submitAnswer = answers.correctAnswer";
            stmt = conn.prepareStatement(extractQuery);
            rs = stmt.executeQuery();
            if(rs.next()){
                String valueQuery = "Insert Into compare(value) Values(?)";
                stmt = conn.prepareStatement(valueQuery);
                stmt.setString(1, "Correct");
                stmt.executeUpdate();
            }else{
                String valueQuery = "INSERT INTO compare(value) VALUES (?)";
                stmt = conn.prepareStatement(valueQuery);
                stmt.setString(1, "Incorrect");
                stmt.executeUpdate();
            }
            timer.stop();   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void checkAnswer(){
        try{
            String showQuery = "Select value From compare Order By tableID DESC limit 1";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/asl", "root", "");
            stmt = conn.prepareStatement(showQuery);
            rs = stmt.executeQuery();
            if(rs.next()){
                String show = rs.getString("value");
                JOptionPane.showMessageDialog(null, "Your answer is " + show, "Information", JOptionPane.PLAIN_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
