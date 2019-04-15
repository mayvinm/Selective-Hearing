import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 * Started by Cameron on April 3rd
 * Edited by Cameron on April 5th and 8th
 * make a timer so button unclickable for amount of time
 * maybe use if statement wih it
 */
public class numberLesson{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private JFrame frame = new JFrame("Numbers Lesson");
    private JPanel panel = new JPanel();
    private JLabel message = new JLabel("<html>Learn the numbers 0 to 10.<br/>" +
        "Must finish lesson before leaving.</html>");
    private JLabel zero = new JLabel("Number 0");
    private JLabel one = new JLabel("Number 1");
    private JLabel two = new JLabel("Number 2");
    private JLabel three = new JLabel("Number 3");
    private JLabel four = new JLabel("Number 4");
    private JLabel five = new JLabel("Number 5");
    private JLabel six = new JLabel("Number 6");
    private JLabel seven = new JLabel("Number 7");
    private JLabel eight = new JLabel("Number 8");
    private JLabel nine = new JLabel("Number 9");
    private JLabel ten = new JLabel("Number 10");
    private JButton endButton = new JButton("Done");
    public numberLesson(){
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
        
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberZero.png")), gbc);
        panel.add(zero, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberOne.jpg")), gbc);
        panel.add(one, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberTwo.jpg")), gbc);
        panel.add(two, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberThree.jpg")), gbc);
        panel.add(three, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberFour.jpg")), gbc);
        panel.add(four, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberFive.jpg")), gbc);
        panel.add(five, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberSix.jpg")), gbc);
        panel.add(six, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberSeven.jpg")), gbc);
        panel.add(seven, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberEight.jpg")), gbc);
        panel.add(eight, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberNine.jpg")), gbc);
        panel.add(nine, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/numberTen.gif")), gbc);
        panel.add(ten, gbc);
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
