import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 * Created by Cameron on April 20th
 */
public class GreetQuestionOne{
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String value;
    private Timer timer;
    private int counter = 0;
    private JFrame frame = new JFrame("Greetings Quiz: Question One");
    private JPanel panel = new JPanel();
    private final JLabel TIME = new JLabel("0" + " seconds");
    //html and br tags put the second part of the message on a new line
    private JLabel message = new JLabel("<html><center>Answer the questions for each image.</center>" + 
        "<br/><center>You have 1 minute to complete the quiz.</center>" + "<br/>Click 'Submit and Check' once your answers are inputted.</html>");
    private JLabel questionOne = new JLabel("What greeting is this?");
    private JRadioButton welcome = new JRadioButton("You're Welcome");
    private JRadioButton bye = new JRadioButton("Bye");
    private JRadioButton hello = new JRadioButton("Hello");
    private JRadioButton eight = new JRadioButton("8");
    private JButton submitButton = new JButton("<html><font size='4'>Submit and Check</font></html>");
    private JButton quitButton = new JButton("Quit Quiz");
    /**
     * Constructor for objects of class GreetQuestionOne
     */
    public GreetQuestionOne(){
        frame();
        //1000 milliseconds = 1 second
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TIME.setText(String.valueOf(counter + "  seconds"));
                counter++;
                //number must be 2 digits higher than time you want
                if (counter == 62) {
                    //timer.removeActionListener(this);
                    JOptionPane.showMessageDialog(null, "You are out of time! Answer being submitted.", "Warning", JOptionPane.WARNING_MESSAGE);
                    submitButton.doClick();
                    frame.dispose();
                }
            }
        });
        timer.start();
        //closes the database connection then disposes the frame and opens the quiz class
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
        
        welcome.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "You're Welcome";
            }
        });
        
        bye.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "bye";
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
        
        submitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
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
            conn.close();
            frame.dispose();
            new GreetQuestionTwo();
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
        //Question One
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Greetings/helloSign.png")), gbc);
        panel.add(questionOne, gbc);
        panel.add(welcome, gbc);
        panel.add(bye, gbc);
        panel.add(hello, gbc);
        panel.add(eight, gbc);
        panel.add(submitButton, gbc);
        
        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.add(quitButton, gbc);

        gbc.weighty = 1;
        panel.add(buttons, gbc);
        
        JScrollPane scrPanel = new JScrollPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(scrPanel);
        frame.pack(); //for if the window is minimized
        frame.setVisible(true);
    }
}
