import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 * Created by Cameron on April 20th
 */
public class NumQuestionFive{
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String value;
    private Timer timer;
    private long startTime = -1;
    private long duration = -1;
    private JFrame frame = new JFrame("Numbers Quiz: Question Five");
    private JPanel panel = new JPanel();
    //html and br tags put the second part of the message on a new line
    private JLabel message = new JLabel("<html><center>Answer the questions for each image.</center>" + 
        "<br/><center>You have 1 minute to complete the quiz.</center>" + "<br/>Click 'Finish' once your answers are inputted.</html>");
    private JLabel questionFive = new JLabel("Solve the following problem: __ + 10 = 15");
    private JButton optionA = new JButton("A.", new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberSix.jpg"));
    private JButton optionC = new JButton("C.", new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberFive.jpg"));
    private JButton optionB = new JButton("B.", new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberThree.jpg"));
    private JButton optionD = new JButton("D.", new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberTwo.jpg"));
    //private JButton submitButton = new JButton("<html><font size='4'>Submit and Check</font></html>");
    private JButton quitButton = new JButton("Quit Quiz");
    public NumQuestionFive(){
        frame();
        //1000 milliseconds = 1 second
        timer = new Timer(60000, new ActionListener(){//60 seconds
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
                //submitButton.doClick();
                frame.dispose();
                new Quiz();
            }
        });
        timer.start();
        //stops the timer, disposes the frame and opens the quiz class
        quitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                try{
                    timer.stop();
                    frame.dispose();
                    new Quiz();
                }catch(Exception e){ 
                }
            }
        });
        
        //action listeners for the fifth question
        optionA.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "A";
                submitAnswer();
                checkAnswer();
            }
        });
        //correct answer
        optionC.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "C";
                submitAnswer();
                checkAnswer();
            }
        });
        
        optionB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "B";
                submitAnswer();
                checkAnswer();
            }
        });
        
        optionD.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "D";
                submitAnswer();
                checkAnswer();
            }
        });
    }
    
    private void submitAnswer(){
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
    
    private void checkAnswer(){
        try{
            String showQuery = "Select value From compare Order By tableID DESC limit 1";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/asl", "root", "");
            stmt = conn.prepareStatement(showQuery);
            rs = stmt.executeQuery();
            if(rs.next()){
                String show = rs.getString("value");
                JOptionPane.showMessageDialog(null, "Your answer is " + show, "Information", JOptionPane.PLAIN_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, "You have completed this quiz.");
            conn.close();
            frame.dispose();
            new Quiz();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void frame(){
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        
        panel.add(message, gbc);
        //Question Five
        //aligns the text in the button to the left of the icon
        optionA.setHorizontalTextPosition(SwingConstants.LEFT);
        optionC.setHorizontalTextPosition(SwingConstants.LEFT);
        optionB.setHorizontalTextPosition(SwingConstants.LEFT);
        optionD.setHorizontalTextPosition(SwingConstants.LEFT);
        //adds question and options to the panel
        panel.add(questionFive, gbc);
        panel.add(optionA, gbc);
        panel.add(optionB, gbc);
        panel.add(optionC, gbc);
        panel.add(optionD, gbc);
        
        JPanel buttons = new JPanel(new GridBagLayout());
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
}