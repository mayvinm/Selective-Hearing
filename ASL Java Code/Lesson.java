import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Started by Cameron on March 5th
 * Edited by Cameron on April 3rd
 */
public class Lesson{
    private JFrame frame = new JFrame("App Lessons");
    private JPanel panel = new JPanel();
    private JLabel greetText = new JLabel("Greetings Lesson");
    private JLabel numberText = new JLabel("Numbers Lesson");
    private JLabel alphaText = new JLabel("Alphabet Lesson");
    private JButton quizButton = new JButton("Go to Quizes");
    private JButton greetButton = new JButton("Begin");
    private JButton numberButton = new JButton("Begin");
    private JButton alphaButton = new JButton("Begin");
    //private JButton anotherlessonButton = new JButton("Begin");
    public Lesson(){
        panel.setLayout(new GridLayout(4, 2));
        //greetButton.setPreferredSize(new Dimension(80, 50));
        //numberButton.setPreferredSize(new Dimension(80, 50));
        //alphaButton.setPreferredSize(new Dimension(80, 50));
        
        greetButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new greetingLesson();
            }
        });
        
        numberButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new numberLesson();
            }
        });
        
        alphaButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                //put alphabet constructor here;
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
        panel.add(quizButton);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

