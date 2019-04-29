import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Started by Cameron on April 1st
 * Edited by Cameron on April 20th and April 24th
 */
public class Quiz{
    private JFrame frame = new JFrame("App Quizzes");
    private JPanel panel = new JPanel();
    private JLabel greetText = new JLabel("<html><font size='8'>Greetings Quiz</font></html>");
    private JLabel numberText = new JLabel("<html><font size='8'>Numbers Quiz</font></html>");
    private JLabel alphaText = new JLabel("<html><font size='8'>Alphabet Quiz</font></html>");
    private JLabel foodText = new JLabel("<html><font size='8'>Food Quiz</font></html>");
    private JButton lessonButton = new JButton("Back to Lessons");
    private JButton greetButton = new JButton("Begin");
    private JButton numberButton = new JButton("Begin");
    private JButton alphaButton = new JButton("Begin");
    private JButton foodButton = new JButton("Begin");
    private JButton logoutButton = new JButton("Logout");
    public Quiz(){
        panel.setLayout(new GridLayout(5, 0));
        panel.setBackground(new Color(65, 131, 126));
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
                new GreetingQuiz();
            }
        });
        
        numberButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new NumberQuiz();
            }
        });
        
        alphaButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new AlphaQuiz();
            }
        });
        
        foodButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new FoodQuiz();
            }
        });
        
        lessonButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new Lesson();
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
        
        panel.add(lessonButton);
        panel.add(logoutButton);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
}