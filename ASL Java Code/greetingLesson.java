import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Created by Cameron on April 4th
 * Edited by Cameron on April 5th
 */
public class greetingLesson{
    private JFrame frame = new JFrame("Greetings Lesson");
    private JPanel panel = new JPanel();
    private JLabel message = new JLabel("<html>Learn the following greetings.<br/>" +
        "Must finish lesson before leaving.</html>");
    private JLabel hello = new JLabel("Hello");
    private JLabel thanks = new JLabel("Thank You");
    private JLabel welcome = new JLabel("You're Welcome");
    private JLabel bye = new JLabel("Bye");
    private JLabel please = new JLabel("Please");
    private JButton endButton = new JButton("Done");
    public greetingLesson(){
        panel.setLayout(new GridBagLayout());        
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
        
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/helloSign.png")), gbc);
        panel.add(hello, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/thankSign.png")), gbc);
        panel.add(thanks, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/welcomeSign.jpg")), gbc);
        panel.add(welcome, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/pleaseSign.png")), gbc);
        panel.add(please, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/byeSign.jpg")), gbc);
        panel.add(bye, gbc);
        //panel.add(questionTwoInput, gbc);
        //more quiz questions in the above order
        //panel.add(password, gbc);
        //panel.add(passInput, gbc);
        panel.add(endButton, gbc);
        JScrollPane scrPanel = new JScrollPane(panel);
        //JPanel buttons = new JPanel(new GridBagLayout());
        //buttons.add(endButton, gbc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(scrPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
