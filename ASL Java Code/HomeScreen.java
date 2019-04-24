import javax.swing.*; //JButton, Jlabel, Jpanel
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*; //actionlistener
/**
 * Started by Cameron on March 5th
 * Edited by Cameron on March 25th
 */
public class HomeScreen{
    private JButton login = new JButton("Click to Log In");
    private JButton register = new JButton("Click to Register");
    private JButton freeTrial = new JButton("Click for Free Trail");
    private JFrame frame = new JFrame("ASL - American Sign Language");
    private JLabel message = new JLabel("<html><font size='5'><center>This application is owned and operated by MCRO Industeries. Any copying of the code </br>" 
        + "without written consent from owner will result in legal consquences and a possible fine of up to $10,000 depending on residency." + 
        "</br> Copyright 2019</center></font></html>");
    public HomeScreen(){
        //When button clicked, moves to login, register or
        //to alphabet lesson screen
        login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new LoginScreen();
            }
        });
        
        register.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new RegisterScreen();
            }
        });
        //using alphabet for free trail 
        freeTrial.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                //new GreetingLesson();
            }
        });
        
        //components in the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MenuPane());
        frame.add(message, BorderLayout.SOUTH);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //size of the frame/phone
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new HomeScreen();
    }
    
    private class MenuPane extends JPanel{
        public MenuPane(){
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;

            add(new JLabel("<html><font size='15'>Welcome to the ASL App!</font></html>"), gbc);
            add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/ASL_Logo.png")), gbc);
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            
            JPanel buttons = new JPanel(new GridBagLayout());
            buttons.add(login, gbc);
            buttons.add(register, gbc);
            buttons.add(freeTrial, gbc);

            gbc.weighty = 1;
            add(buttons, gbc);
        }
    }
}
