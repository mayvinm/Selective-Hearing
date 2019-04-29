import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Started by Cameron on April 3rd
 * Edited by Cameron on April 5th and 8th and 28th
 */
public class NumberLesson{
    private JFrame frame = new JFrame("Numbers Lesson");
    private JPanel panel = new JPanel();
    private JLabel message = new JLabel("<html><font size='4'><center>Learn the numbers 0 to 10.</center><br/>" +
        "Click the button at the bottom when you are done.</font></html>");
    private JLabel zero = new JLabel("<html><font size='6'>Number 0</font></html>");
    private JLabel one = new JLabel("<html><font size='6'>Number 1</font></html>");
    private JLabel two = new JLabel("<html><font size='6'>Number 2</font></html>");
    private JLabel three = new JLabel("<html><font size='6'>Number 3</font></html>");
    private JLabel four = new JLabel("<html><font size='6'>Number 4</font></html>");
    private JLabel five = new JLabel("<html><font size='6'>Number 5</font></html>");
    private JLabel six = new JLabel("<html><font size='6'>Number 6</font></html>");
    private JLabel seven = new JLabel("<html><font size='6'>Number 7</font></html>");
    private JLabel eight = new JLabel("<html><font size='6'>Number 8</font></html>");
    private JLabel nine = new JLabel("<html><font size='6'>Number 9</font></html>");
    private JLabel ten = new JLabel("<html><font size='6'>Number 10</font></html>");
    private JButton endButton = new JButton("<html><font size='5'>Done</font></html>");
    public NumberLesson(){
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
        
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Numbers/numberZero.png")), gbc);
        panel.add(zero, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Numbers/numberOne.jpg")), gbc);
        panel.add(one, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Numbers/numberTwoLesson.jpg")), gbc);
        panel.add(two, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Numbers/numberThreeLesson.jpg")), gbc);
        panel.add(three, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Numbers/numberFour.jpg")), gbc);
        panel.add(four, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Numbers/numberFiveLesson.jpg")), gbc);
        panel.add(five, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Numbers/numberSixLesson.jpg")), gbc);
        panel.add(six, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Numbers/numberSeven.jpg")), gbc);
        panel.add(seven, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Numbers/numberEight.jpg")), gbc);
        panel.add(eight, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Numbers/numberNine.jpg")), gbc);
        panel.add(nine, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Numbers/numberTen.gif")), gbc);
        panel.add(ten, gbc);
        panel.add(endButton, gbc);
        
        JScrollPane scrPanel = new JScrollPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(scrPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
