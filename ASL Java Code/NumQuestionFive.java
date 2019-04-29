import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 * Created by Cameron on April 20th
 * Edited by Cameron on April 22nd
 */
public class NumQuestionFive{
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String value;
    private Timer timer;
    private int counter = 0;
    private JFrame frame = new JFrame("Numbers Quiz: Question Five");
    private JPanel panel = new JPanel();
    private final JLabel TIME = new JLabel("0" + " seconds");
    //html and br tags put the second part of the message on a new line
    private JLabel message = new JLabel("<html><html><font size='4'><center>Answer the question." + 
        "<br/>You have 1 minute to complete it." + "<br/>Click 'Finish' once your answer is selected.</font></center></html>");
    private JLabel questionFive = new JLabel("Solve the following problem: __ + 10 = 15");
    private JButton optionA = new JButton("A.", new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Numbers/numberSix.jpg"));
    private JButton optionC = new JButton("C.", new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Numbers/numberFive.jpg"));
    private JButton optionB = new JButton("B.", new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Numbers/numberThree.jpg"));
    private JButton optionD = new JButton("D.", new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Numbers/numberTwo.jpg"));
    private JButton quitButton = new JButton("Quit Quiz");
    public NumQuestionFive(){
        frame();
        //1000 milliseconds = 1 second
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TIME.setText(String.valueOf(counter + "  seconds"));
                counter++;
                //number must be 2 digits higher than time you want
                if (counter == 62) {
                    JOptionPane.showMessageDialog(null, "You are out of time! You must retake the quiz!", "Warning", JOptionPane.WARNING_MESSAGE);
                    frame.dispose();
                    new Quiz();
                }
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
        panel.setBackground(new Color(65, 131, 126));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5, 0, 5, 0);
        
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
        
        JPanel button = new JPanel(new GridBagLayout());
        button.setBackground(new Color(65, 131, 126));
        button.add(quitButton, gbc);

        gbc.weighty = 1;
        panel.add(button, gbc);
        
        //JScrollPane scrPanel = new JScrollPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
}