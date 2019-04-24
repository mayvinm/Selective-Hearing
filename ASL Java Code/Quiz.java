import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Started by Cameron on April 1st
 * Edited by Cameron on April 20th and April 24th
 * requires logout button
 */
public class Quiz{
    private JFrame frame = new JFrame("Quizzes");
    private JPanel panel = new JPanel();
    private JLabel greetText = new JLabel("Greetings Quiz");
    private JLabel numberText = new JLabel("Numbers Quiz");
    private JLabel alphaText = new JLabel("Alphabet Quiz");
    private JLabel foodText = new JLabel("Food Quiz");
    private JButton lessonButton = new JButton("Back to Lessons");
    private JButton greetButton = new JButton("Begin");
    private JButton numberButton = new JButton("Begin");
    private JButton alphaButton = new JButton("Begin");
    private JButton foodButton = new JButton("Begin");
    private JButton logoutButton = new JButton("Logout");
    public Quiz(){
        panel.setLayout(new FlowLayout(1));//needed
        greetButton.setPreferredSize(new Dimension(80, 50));
        numberButton.setPreferredSize(new Dimension(80, 50));
        alphaButton.setPreferredSize(new Dimension(80, 50));
        foodButton.setPreferredSize(new Dimension(80, 50));
        logoutButton.setPreferredSize(new Dimension(80, 50));
        
        logoutButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                JOptionPane.showMessageDialog(null, "Logged Out!");
                frame.dispose();
                new homeScreen();
            }
        });
        
        greetButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new greetingQuiz();
            }
        });
        
        numberButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new numberQuiz();
            }
        });
        
        alphaButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                //put alphabet constructor here;
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
