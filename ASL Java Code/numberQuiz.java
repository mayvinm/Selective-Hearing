import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 * Started by Cameron on March 23rd
 * Edited by Cameron on April 1st and April 3rd
 * Make a specific class for the free trail
 */
public class numberQuiz{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private JFrame frame = new JFrame("Numbers Quiz");
    private JPanel panel = new JPanel();
    //html and br tags put the second part of the message on a new line
    private JLabel message = new JLabel("<html>Answer the questions for each image." + 
        "<br/>Click 'Finish' once your answers are inputted.</html>");
    private JLabel questionOne = new JLabel("What number is this?");
    private JLabel questionTwo = new JLabel("This means '5'. True or False?");
    private JLabel questionThree = new JLabel("What number is this?");
    private JLabel questionFour = new JLabel("What number is this?");
    private JButton endButton = new JButton("Finish");
    private JTextField questionOneInput = new JTextField(10);
    private JTextField questionTwoInput = new JTextField(10);
    public numberQuiz(){
        //connect();
        panel.setLayout(new GridBagLayout());
        endButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new Quiz();
            }
        });
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        
        panel.add(message, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberTen.gif")), gbc);
        panel.add(questionOne, gbc);
        panel.add(questionOneInput, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/moreSign.png")), gbc);
        panel.add(questionTwo, gbc);
        panel.add(questionTwoInput, gbc);
        //more quiz questions in the above order
        //panel.add(password, gbc);
        //panel.add(passInput, gbc);
        
        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.add(endButton, gbc);

        gbc.weighty = 1;
        panel.add(buttons, gbc);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
    
    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/asl", "root", "");
            stmt = conn.createStatement();
            //conn.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
