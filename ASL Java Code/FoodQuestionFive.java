import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class FoodQuestionFive{
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String value;
    private Timer timer;
    private int counter = 0;
    private JFrame frame = new JFrame("Food Quiz: Question Five");
    private JPanel panel = new JPanel();
    private final JLabel TIME = new JLabel("0" + " seconds");
    //html and br tags put the second part of the message on a new line
    private JLabel message = new JLabel("<html><html><font size='4'><center>Answer the question." + 
        "<br/>You have 1 minute to complete it." + "<br/>Click 'Finish' once your answer is selected.</font></center></html>");
    private JLabel questionFive = new JLabel("What is the man signing?");
    private JRadioButton watermelon = new JRadioButton("Watermelon");
    private JRadioButton meat = new JRadioButton("Meat");
    private JRadioButton lemon = new JRadioButton("Lemon");
    private JRadioButton apple = new JRadioButton("Apple");
    private JButton submitButton = new JButton("<html><font size='5'>Submit and Check</font></html>");
    private JButton quitButton = new JButton("<html><font size='5'>Quit Quiz</font></html>");
    public FoodQuestionFive(){
        frame();
        //1000 milliseconds = 1 second
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TIME.setText(String.valueOf(counter + "  seconds"));
                counter++;
                //number must be 2 digits higher than time you want
                if (counter == 62) {
                    JOptionPane.showMessageDialog(null, "You are out of time! Answer being submitted.", "Warning", JOptionPane.WARNING_MESSAGE);
                    submitButton.doClick();
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
        
        
        submitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                submitAnswer();
                checkAnswer();
            }
        });
        
        meat.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "Meat";
            }
        });
        
        lemon.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "Lemon";
            }
        });
        
        apple.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "Apple";
            }
        });
        
        watermelon.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                value = "Watermelon";
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
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Food/meat.gif")), gbc);
        panel.add(questionFive, gbc);
        panel.add(watermelon, gbc);
        panel.add(meat, gbc);
        panel.add(lemon, gbc);
        panel.add(apple, gbc);
        panel.add(submitButton, gbc);
        
        JPanel button = new JPanel(new GridBagLayout());
        button.setBackground(new Color(65, 131, 126));
        button.add(quitButton, gbc);

        gbc.weighty = 1;
        panel.add(button, gbc);
        
        //JScrollPane scrPanel = new JScrollPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(panel);
        frame.pack(); //for if the window is minimized
        frame.setVisible(true);
    }
}