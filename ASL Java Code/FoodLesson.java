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
    private JLabel message = new JLabel("<html>Learn some of the names of food.<br/>" +
        "Must finish lesson before leaving.</html>");
    private JLabel apple = new JLabel("Apple");
    private JLabel orange = new JLabel("Orange");
    private JLabel banana = new JLabel("Banana");
    private JLabel strawberry = new JLabel("Strawberry");
    private JLabel lemon = new JLabel("Lemon");
    private JLabel cherry = new JLabel("Cherry");
    private JLabel watermelon = new JLabel("Watermelon");
    private JLabel pasta = new JLabel("Pasta");
    private JLabel meat = new JLabel("Meat");
    private JLabel chicken = new JLabel("Chicken");
    private JLabel eggs = new JLabel("Eggs");
    private JButton endButton = new JButton("Done");
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
    
    public void frame(){
        panel.setLayout(new GridBagLayout()); 
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
