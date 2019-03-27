import javax.swing.*; //JButton, Jlabel, Jpanel
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*; //actionlistener
/**
 * Started by Cameron
 * Edited by Cameron on March 25th
 */
public class homeScreen{
    private JButton login = new JButton("Click to Log In");
    private JButton register = new JButton("Click to Register");
    private JButton freeTrial = new JButton("Click for Test");
    private JFrame frame = new JFrame("ASL - American Sign Language");
    public homeScreen(){
        //When button clicked, moves to login, register or
        //to alphabet lesson screen
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
        //using number lesson just for free trail code right now
        freeTrial.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new numberLesson();
            }
        });
        
        //components in the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MenuPane());
        frame.setSize(300, 450); //size of the frame/phone
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new homeScreen();
    }
    
    public class MenuPane extends JPanel{
        public MenuPane(){
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;

            add(new JLabel("Welcome to the ASL App!"), gbc);
            add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/ASL_Logo.png")), gbc);
            gbc.anchor = GridBagConstraints.CENTER;
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