import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Started by Cameron on March 5th
 */
public class Lesson{
    private JFrame frame = new JFrame("App Lessons");
    private JPanel panel = new JPanel();
    private JLabel greetText = new JLabel("Greetings Lesson");
    private JLabel numberText = new JLabel("Numbers Lesson");
    private JLabel alphaText = new JLabel("Alphabet Lesson");
    private JButton greetButton = new JButton("Begin");
    private JButton numberButton = new JButton("Begin");
    private JButton alphaButton = new JButton("Begin");
    //private JButton anotherlessonButton = new JButton("Begin");
    public Lesson(){
        panel.setLayout(new FlowLayout(1));
        greetButton.setPreferredSize(new Dimension(80, 50));
        numberButton.setPreferredSize(new Dimension(80, 50));
        alphaButton.setPreferredSize(new Dimension(80, 50));
        
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
                //put alphabet contrustor here;
            }
        });
        panel.add(alphaText);
        panel.add(alphaButton);
        panel.add(numberText);
        panel.add(numberButton);
        panel.add(greetText);
        panel.add(greetButton);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.setSize(300, 400);
        frame.setVisible(true);
    }
}
