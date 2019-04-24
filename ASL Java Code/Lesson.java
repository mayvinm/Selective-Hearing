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
    private JLabel greetText = new JLabel("Greetings Lesson");
    private JLabel numberText = new JLabel("Numbers Lesson");
    private JLabel alphaText = new JLabel("Alphabet Lesson");
    private JLabel foodText = new JLabel("Food Lesson");
    private JButton quizButton = new JButton("Go to Quizes");
    private JButton greetButton = new JButton("Begin");
    private JButton numberButton = new JButton("Begin");
    private JButton alphaButton = new JButton("Begin");
    private JButton foodButton = new JButton("Begin");
    private JButton logoutButton = new JButton("Logout");
    public Lesson(){
        panel.setLayout(new GridLayout(4, 2));
        greetButton.setPreferredSize(new Dimension(80, 50));
        numberButton.setPreferredSize(new Dimension(80, 50));
        alphaButton.setPreferredSize(new Dimension(80, 50));
        foodButton.setPreferredSize(new Dimension(80, 50));
        logoutButton.setPreferredSize(new Dimension(80, 50));
        
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
                //put alphabet lesson constructor here;
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
