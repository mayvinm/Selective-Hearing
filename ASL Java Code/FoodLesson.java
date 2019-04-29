import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Started by Omar on April 10th
 * Edited by Omar on April 18th and 20th
 * Edited by Cameron on April 20th
 */
public class FoodLesson{
    private JFrame frame = new JFrame("Food and Fruits Lesson");
    private JPanel panel = new JPanel();
    private JLabel message = new JLabel("<html><font size='4'><center>Learn some of the names of food.</center><br/>" +
        "Click the button at the bottom when you are done.</font></html>");
    private JLabel apple = new JLabel("<html><font size='6'>Apple</font></html>");
    private JLabel orange = new JLabel("<html><font size='6'>Orange</font></html>");
    private JLabel banana = new JLabel("<html><font size='6'>Banana</font></html>");
    private JLabel strawberry = new JLabel("<html><font size='6'>Strawberry</font></html>");
    private JLabel lemon = new JLabel("<html><font size='6'>Lemon</font></html>");
    private JLabel cherry = new JLabel("<html><font size='6'>Cherry</font></html>");
    private JLabel watermelon = new JLabel("<html><font size='6'>Watermelon</font></html>");
    private JLabel pasta = new JLabel("<html><font size='6'>Pasta</font></html>");
    private JLabel meat = new JLabel("<html><font size='6'>Meat</font></html>");
    private JLabel chicken = new JLabel("<html><font size='6'>Chicken</font></html>");
    private JLabel eggs = new JLabel("<html><font size='6'>Eggs</font></html>");
    private JButton endButton = new JButton("<html><font size='5'>Done</font></html>");
    public FoodLesson(){
        frame();
        endButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                JOptionPane.showMessageDialog(null, "Lesson Completed!");
                frame.dispose();
                new Lesson();
            }
        });
    }
    
    private void frame(){
        panel.setLayout(new GridBagLayout()); 
        panel.setBackground(new Color(65, 131, 126));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        
        panel.add(message, gbc);
        
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Food/apple.gif")), gbc);
        panel.add(apple, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Food/orange.gif")), gbc);
        panel.add(orange, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Food/banana.gif")), gbc);
        panel.add(banana, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Food/strawberry.gif")), gbc);
        panel.add(strawberry, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Food/lemon.gif")), gbc);
        panel.add(lemon, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Food/cherry.gif")), gbc);
        panel.add(cherry, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Food/watermelon.gif")), gbc);
        panel.add(watermelon, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Food/pasta.gif")), gbc);
        panel.add(pasta, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Food/meat.gif")), gbc);
        panel.add(meat, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Food/chicken.gif")), gbc);
        panel.add(chicken, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Food/eggs.gif")), gbc);
        panel.add(eggs, gbc);
        panel.add(endButton, gbc);
    
        JScrollPane scrPanel = new JScrollPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(scrPanel);
        frame.pack();
        frame.setVisible(true);
    }
}