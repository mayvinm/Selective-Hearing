import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 * Started by Cameron on March 23rd
 * Edited by Cameron on April 1st
 * 
 */
public class greetingQuiz{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private JFrame frame = new JFrame("Greetings Quiz");
    private JPanel panel = new JPanel();
    private JLabel message = new JLabel("Enter the word/phrase of the sign being done.");
    private JLabel questionOne = new JLabel("Question 1");
    private JLabel questionTwo = new JLabel("Question 2");
    private JButton endButton = new JButton("Finish");
    private JTextField questionOneInput = new JTextField(10);
    private JTextField questionTwoInput = new JTextField(10);
    private JTextField questionThreeInput = new JTextField(10);
    private JTextField questionFourInput = new JTextField(10);
    public greetingQuiz(){  
        //connect();
        endButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new Quiz();
            }
        });
        
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        
        panel.add(message, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/helloSign.png")), gbc);
        panel.add(questionOne, gbc);
        panel.add(questionOneInput, gbc);
        //more quiz questions in the above order
        //image here
        panel.add(questionTwo, gbc);
        panel.add(questionTwoInput, gbc);
        
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
    //A. Hello  B. Bye  C. How are you?  D.
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
