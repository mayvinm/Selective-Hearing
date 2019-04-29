import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Started by Cameron on March 5th
 * Edited by Cameron on April 3rd and April 24th
 */
public class Lesson{
    private JFrame frame = new JFrame("App Lessons");
    private JPanel panel = new JPanel();
    private JLabel greetText = new JLabel("<html><font size='8'>Greetings Lesson</font></html>");
    private JLabel numberText = new JLabel("<html><font size='8'>Numbers Lesson</font></html>");
    private JLabel alphaText = new JLabel("<html><font size='8'>Alphabet Lesson</font></html>");
    private JLabel foodText = new JLabel("<html><font size='8'>Food Lesson</font></html>");
    private JButton quizButton = new JButton("Go to Quizzes");
    private JButton greetButton = new JButton("Begin");
    private JButton numberButton = new JButton("Begin");
    private JButton alphaButton = new JButton("Begin");
    private JButton foodButton = new JButton("Begin");
    private JButton logoutButton = new JButton("Logout");
    public Lesson(){
        frame();
        
        logoutButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                JOptionPane.showMessageDialog(null, "Logged Out!");
                frame.dispose();
                new HomeScreen();
            }
        });
        
        greetButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new GreetingLesson();
            }
        });
        
        numberButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new NumberLesson();
            }
        });
        
        alphaButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new AlphaLesson();
            }
        });
        
        foodButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new FoodLesson();
            }
        });
        
        quizButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new Quiz();
            }
        });
    }
    
    public void frame(){
        panel.setLayout(new GridLayout(5, 0));
        panel.setBackground(new Color(65, 131, 126));
        
        panel.add(alphaText);
        panel.add(alphaButton);
        
        panel.add(numberText);
        panel.add(numberButton);
        
        panel.add(greetText);
        panel.add(greetButton);
        
        panel.add(foodText);
        panel.add(foodButton);
        
        panel.add(quizButton);
        panel.add(logoutButton);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
