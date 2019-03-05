//import java.*;
import javax.swing.*; //JButton, Jlabel, Jpanel
import java.awt.*;
import java.awt.event.*; //actionlistener
/**
 * Started by Cameron
 * Edited by Cameron on March 5th
 */
public class homeScreen{
    private JPanel keyPanel;
    private JLabel greeting; //text in the frame
    private JButton login, register;
    private JFrame frame = new JFrame("ASL - American Sign Language");

    public homeScreen(){
        keyPanel.setLayout(new BorderLayout());
        keyPanel = new JPanel(new GridLayout(4, 3));
        greeting = new JLabel("Welcome to the ASL App!");//message at top of screen

        //creates buttons 
        login = new JButton("Click to Log In");
        register = new JButton("Click to Register");
        
        //adds buttons to the panel display
        keyPanel.add(login);
        keyPanel.add(register);
        
        // When button clicked, moves to login or register screen
        login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new loginScreen();
            }
        });
        
        register.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new registerScreen();
            }
        });
        
        //components in the frame
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.add(greeting, BorderLayout.NORTH);
        frame.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/ASL_Logo.png")), BorderLayout.CENTER);
        frame.add(keyPanel, BorderLayout.SOUTH);
        frame.setSize(300, 400); //size of the frame/phone
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new homeScreen();
    }
}
