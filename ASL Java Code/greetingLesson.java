import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Started by Cameron on March 23rd
 */
public class greetingLesson{
    private JFrame frame = new JFrame("Greetings Lesson");
    private JPanel panel = new JPanel();
    private JPanel newPanel = new JPanel();
    private JLabel text = new JLabel("What greeting is the person saying?");
    private JButton contButton = new JButton("Continue");
    public greetingLesson(){
        panel.setLayout(new FlowLayout(2));
        
        contButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                //new Lesson();
            }
        });
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.add(contButton, BorderLayout.SOUTH);
        frame.setSize(300, 400);
        frame.setVisible(true);
    }
}
