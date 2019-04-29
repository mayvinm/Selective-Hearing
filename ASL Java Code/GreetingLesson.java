import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Created by Cameron on April 4th
 * Edited by Cameron on April 5th
 */
public class GreetingLesson{
    private JFrame frame = new JFrame("Greetings Lesson");
    private JPanel panel = new JPanel();
    private JLabel message = new JLabel("<html><font size='4'><center>Learn the following greetings.</center><br/>" +
        "Click the button at the bottom when you are done.</font></html>");
    private JLabel hello = new JLabel("<html><font size='6'>Hello</font></html>");
    private JLabel thanks = new JLabel("<html><font size='6'>Thank You</font></html>");
    private JLabel welcome = new JLabel("<html><font size='6'>You're Welcome</font></html>");
    private JLabel bye = new JLabel("<html><font size='6'>Bye</font></html>");
    private JLabel please = new JLabel("<html><font size='6'>Please</font></html>");
    private JButton endButton = new JButton("<html><font size='5'>Done</font></html>");
    public GreetingLesson(){
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(65, 131, 126));
        endButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                JOptionPane.showMessageDialog(null, "Lesson Completed!");
                frame.dispose();
                new Lesson();
            }
        });
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        
        panel.add(message, gbc);
        
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Greetings/helloSign.png")), gbc);
        panel.add(hello, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Greetings/thankSign.png")), gbc);
        panel.add(thanks, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Greetings/welcomeSign.jpg")), gbc);
        panel.add(welcome, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Greetings/pleaseSign.png")), gbc);
        panel.add(please, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Greetings/byeSign.jpg")), gbc);
        panel.add(bye, gbc);
        panel.add(endButton, gbc);
        
        JScrollPane scrPanel = new JScrollPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(scrPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
